/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Jakob
 */
@ServerEndpoint("/whatsapp")
public class WebSocketHandler {
    
    
    List<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        sessions.add(session);
        
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (Session client : sessions) {
            client.getAsyncRemote().sendText(message);
        }
        
        String firstName = object.getString("firstName");

    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }
}
