package net.messi.earlyadmin.controller;

import com.google.gson.Gson;
import net.messi.earlyadmin.VO.LogVo;
import net.messi.earlyadmin.component.BaseRedisService;
import net.messi.earlyadmin.constant.IPAddress;
import net.messi.earlyadmin.utils.HttpClientUtils;
import net.messi.earlyadmin.utils.JSONResult;
import net.messi.earlyadmin.utils.JsonToObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("layuiadmin/log")
public class LogController {

    @Autowired
    private BaseRedisService redisService;

    private Map<Integer,Integer> goodsMap = new HashMap<>();

    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @ResponseBody
    @GetMapping("/preHeat")
    public JSONResult preHeat(){
        //日志路径
        String path = "/usr/local/nginx/logs/access.log";
//        String path = "C:\\Users\\duncan\\Desktop\\log.log";
        String line = null;
        BufferedReader reader = null;
        long time = 30 * 60;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"utf-8"));
            int index = 0;
            while ((line = reader.readLine()) != null && index <= 1000){
                if (!(line+"LEO").equals("LEO")) {  //日志空行
                    if (line.contains("requestPath=product")) {
                        line = line.split(",")[1].split(" ")[1].split("&")[1].split("=")[1];
                        Integer lineNum = Integer.parseInt(line);
                        if (goodsMap.get(lineNum) == null) {
                            String goodsDetailDto = HttpClientUtils.sendGetRequest(IPAddress.IPADDRESS + line);
                            //预热商品
                            redisService.set("product_info_:" + lineNum, goodsDetailDto, time);
                            logger.info("预热成功={}", line);
                            goodsMap.put(lineNum, 1);
                            index++;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (Exception eq){
                eq.printStackTrace();
            }
        }
        return JSONResult.ok();
    }

    @ResponseBody
    @GetMapping("/getLogs")
    public JSONResult getLogs(Integer page,Integer limit){
        String path = "/usr/local/nginx/logs/access.log";
//        String path = "C:\\Users\\duncan\\Desktop\\log.log";
        String line = null;
        BufferedReader reader = null;
        String logs = null;
        List<LogVo> logVos = new ArrayList<>();
        try {
            logs = redisService.getValue("logs_"+page);
            if (null != logs){
                logVos = JsonToObject.toObj(logs);
            }
        }catch (Exception el){
            el.printStackTrace();
        }

        if (logVos.size() == 0) {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "utf-8"));
                LogVo vo = null;
                while ((line = reader.readLine()) != null) {
                    if (!(line+"LEO").equals("LEO")) {
                        vo = new LogVo();
                        vo.setIp(line.split(",")[0]);
                        vo.setUrl(line.split(",")[1]);
                        logVos.add(vo);
                    }
                }
                long time = 30 * 60;
                redisService.set("logs_"+page,new Gson().toJson(logVos),time);
                logger.info("日志成功添加进缓存");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (Exception eq) {
                    eq.printStackTrace();
                }
            }
        }
        int start = (page - 1) * limit;
        int end = start + limit;
        if (end >= logVos.size()){
            if (start >= logVos.size()){
                return JSONResult.ok();
            }else {
                return JSONResult.ok(logVos.subList(start,logVos.size()),logVos.size());
            }
        }else if (start >= logVos.size()){
            return JSONResult.ok();
        }
        return JSONResult.ok(logVos.subList(start,end),logVos.size());
    }
}
