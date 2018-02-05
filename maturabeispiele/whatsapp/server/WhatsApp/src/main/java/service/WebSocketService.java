/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.glassfish.tyrus.server.Server;

/**
 *
 * @author Jakob
 */
public class WebSocketService {

    public static void main(String[] args) {
        runServer();
    }

    public static void runServer() {
        Server server = new Server("localhost", 8025, "/websockets", WebSocketHandler.class);
        
        try {
            server.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the chat-server.");
            reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }

}
