/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Jakob Hanner
 */
public class REST_JavaSE {
  
    // Basis URI 
    public static final String BASE_URI = "http://localhost:8080/server/api/";

    public static org.glassfish.grizzly.http.server.HttpServer startServer() {
        // Im Package "service" alle Klassen durchsuchen, um REST Services zu finden
        final ResourceConfig rc = new ResourceConfig().packages("service","filter");
        // Server starten
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        // Server starten
        final org.glassfish.grizzly.http.server.HttpServer server = startServer();        
        // Static Content - Im Projekt-Verzeichnis "public" liegen die html-Files : localhost:8080/index.html
        server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("public"), "/");
        
        System.out.println(String.format("Server startet at %s\nHit enter to stop ...", BASE_URI));
        System.in.read();
        server.stop();
    }
}