package net.messi.earlyadmin.controller;

import net.messi.earlyadmin.mapper.NideshopGoodsMapper;
import net.messi.earlyadmin.pojo.NideshopGoods;
import net.messi.earlyadmin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpMethod.POST;

@RestController
@RequestMapping("layuiadmin/goods")
public class GoodsAdminController {

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @ResponseBody
    @GetMapping("/getAllGoods")
    public JSONResult getAllGoods(Integer page, Integer limit, HttpServletResponse response){
        int start = (page - 1) * limit;
        List<NideshopGoods> goodsList = goodsMapper.findAllGoodsByLimit(start,limit);
        response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问
        response.addHeader("Access-Control-Allow-Method","POST,GET");//允许访问的方式
        return JSONResult.ok(goodsList,goodsList.size());
    }
}
