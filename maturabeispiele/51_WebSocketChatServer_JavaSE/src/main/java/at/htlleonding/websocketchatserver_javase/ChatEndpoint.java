package at.htlleonding.websocketchatserver_javase;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 *
 * @author H. Lackinger
 */
@ServerEndpoint("/chat")
public class ChatEndpoint {
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
   
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("person");
    private static EntityManager em = emf.createEntityManager();
    
    @OnOpen
    public void onOpen(Session session) throws IOException {
        sessions.add(session);
        
    }

    @OnMessage
    public void distribute(String message, Session session) {
        for (Session client : sessions) {
            client.getAsyncRemote().sendText(message);
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