package com.postbar.backend.dao.websocket;
import com.postbar.backend.core.utils.WebSocketUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.postbar.backend.core.utils.WebSocketUtils.sendMessageAll;

@RestController
@ServerEndpoint("/chat/{username}")
public class ChatServerEndpoint {
    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        WebSocketUtils.ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        WebSocketUtils.ONLINE_USER_SESSIONS.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            throw new RuntimeException("onClose error",e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            throw new RuntimeException("onError excepiton", e);
        }
    }
}
