package websocket;

import databaseManager.Repository;
import entity.Person;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
@ServerEndpoint("/datingApp")
public class EchoEndpoint {
    
    Repository repo = new Repository();
    List<Session> sessions = new ArrayList<>();
    
    @OnOpen 
    public void onOpen(Session session) {
        sessions.add(session);
    }
    
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    
    @OnMessage
    public void onMessage(Session session, String message) {
        handleMessage(session, message);
    }
    
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    
    private void handleMessage(Session session, String message) {
        JsonObject js;
        try (JsonReader jsonReader = Json.createReader(new StringReader(message))){
           js = jsonReader.readObject();
        }
        
        String name = js.getString("name", "");
        int age = Integer.parseInt(js.getString("age", ""));
        String status = js.getString("status", "");

        Person p = new Person(name, age, status);
        
        repo.storePerson(p);
    }

        
}
