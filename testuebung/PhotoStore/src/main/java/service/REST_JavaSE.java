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

    public static final String BASE_URI = "http://localhost:8080/server/api/";

    public static org.glassfish.grizzly.http.server.HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("service,filter");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final org.glassfish.grizzly.http.server.HttpServer server = startServer();
        server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("public"), "/");

        System.out.println("Server startet");
        System.in.read();
        server.stop();
    }

}
