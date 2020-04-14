package net.messi.earlyadmin.component;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 处理订单通知
 */
@Component
@ServerEndpoint("/order/notice/{shopId}")
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    //key 就是订单id
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    //店家Id
    private String shopId;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("shopId") String shopId) {
        this.session = session;
        this.shopId = shopId;
        if(webSocketMap.containsKey(shopId)){
            webSocketMap.remove(shopId);
            webSocketMap.put(shopId,this);
            //加入set中
        }else{
            webSocketMap.put(shopId,this);
        }
        logger.info("店铺登陆成功={}",shopId);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(shopId)){
            webSocketMap.remove(shopId);
        }
        logger.info("店家退出={}",shopId);
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("error={}",error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     * */
    public static void sendInfo(String message,@PathParam("shopId") String shopId) {
        logger.info("发送订单消息到店铺={}",shopId);
        if(StringUtils.isNotBlank(shopId) && webSocketMap.containsKey(shopId)){
            try {
                webSocketMap.get(shopId).sendMessage(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            logger.error("店家{}不在线",shopId);
        }
    }

}

