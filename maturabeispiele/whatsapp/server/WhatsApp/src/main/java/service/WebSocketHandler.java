/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Person;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONObject;
import repository.Repository;

/**
 *
 * @author Jakob
 */
@ServerEndpoint("/whatsapp")
public class WebSocketHandler {

    Repository repo = new Repository();

    List<Session> sessions = new ArrayList<>();
    HashMap<Person, Session> registered = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        repo.init();
        sessions.add(session);

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JsonReader jsonReader = Json.createReader(new StringReader(message));
        JsonObject request = jsonReader.readObject();

        String typ = request.getString("typ", "");
        String username = request.getString("username", "");
        String password = request.getString("password", "");
        String group = request.getString("group", "");
        String payload = request.getString("payload", "");

        //User meldet sich am Server an
        if (!typ.isEmpty() && !username.isEmpty() && !password.isEmpty() && group.isEmpty() && payload.isEmpty()) {
            registered.put(new Person(username, password), session);
        }

        //User meldet sich am Server ab
        if (!typ.isEmpty() && !username.isEmpty() && password.isEmpty() && group.isEmpty() && payload.isEmpty()) {
            registered.remove(username);
        }

        //User sendet Message an alle User einer Gruppe
        if (!typ.isEmpty() && username.isEmpty() && password.isEmpty() && !group.isEmpty() && !payload.isEmpty()) {
            JSONObject o = new JSONObject();

            String tempUsername = "";

            for (Map.Entry<Person, Session> user : registered.entrySet()) {
                Person p = user.getKey();
                Session s = user.getValue();
                if (s.equals(session)) {
                    tempUsername = p.getUsername();
                    break;
                }
            }

            o.append("typ", typ);
            o.append("sender", tempUsername);
            o.append("group", group);
            o.append("payload", payload);

            for (Session client : sessions) {
                client.getAsyncRemote().sendObject(o);
            }
        }

        //User fragt den Server in welchen Gruppen er registriert ist
        if (!typ.isEmpty() && username.isEmpty() && password.isEmpty() && group.isEmpty() && payload.isEmpty()) {
            JSONObject o = new JSONObject();

            o.append("typ", typ);
            o.append("value", repo.getGroupsByUsername(username));
            
            for (Map.Entry<Person, Session> user : registered.entrySet()) {
                Person p = user.getKey();
                Session s = user.getValue();
                if (s.equals(session)) {
                    s.getAsyncRemote().sendObject(o);
                    break;
                }
            }
        }
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
