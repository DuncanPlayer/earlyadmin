package net.messi.earlyadmin.controller;

import net.messi.earlyadmin.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

@RestController
@RequestMapping("layuiadmin/config")
public class ConfigController {

    @ResponseBody
    @GetMapping("set")
    public JSONResult setConfig(String configVal,String fileName){
        String path = "/usr/local/nginx/html/json/";
        String filePath = path + fileName;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(configVal);
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return JSONResult.ok();
    }
}
