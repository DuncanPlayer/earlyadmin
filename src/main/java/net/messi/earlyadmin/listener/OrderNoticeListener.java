package net.messi.earlyadmin.listener;

import com.alibaba.fastjson.JSON;
import net.messi.earlyadmin.component.WebSocketServer;
import net.messi.earlyadmin.configure.RabbitConfig;
import net.messi.earlyadmin.mapper.NideshopGoodsMapper;
import net.messi.earlyadmin.pojo.NideshopGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderNoticeListener {

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    private static Logger logger = LoggerFactory.getLogger(OrderNoticeListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_NOTICE_ORDER)
    public void process(Message message){
        try {
            Integer orderId = JSON.parseObject(new String(message.getBody(),"utf-8"), Integer.class);
            List<NideshopGoods> goodsList = goodsMapper.findGoodsByOrderId(orderId);
            for (NideshopGoods goods:goodsList){
                logger.info("收到下订单通知={},店铺id={}",orderId,goods.getBrandId().toString());
                WebSocketServer.sendInfo(orderId.toString(),goods.getBrandId().toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
