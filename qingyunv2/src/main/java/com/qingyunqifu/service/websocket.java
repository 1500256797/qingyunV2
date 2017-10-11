package com.qingyunqifu.service;


import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
public class websocket {

    private Session session;

    private static CopyOnWriteArraySet<websocket> webSockets = new CopyOnWriteArraySet<websocket>();
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        System.out.println("有新的连接，总数是："+ webSockets.size());

    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("连接关闭，总数是："+ webSockets.size());


    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("收到客户端发来的消息");
    }

    public void sendMessage(String message) throws IOException {
        for (websocket websocket: webSockets) {
            System.out.println("发送消息");
            websocket.session.getBasicRemote().sendText(message);

        }
    }
}
