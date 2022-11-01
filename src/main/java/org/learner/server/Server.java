package org.learner.server;

import org.learner.handler.BaseHandler;
import org.learner.handler.HandlerFactory;
import org.learner.parser.ParsedRequest;
import org.learner.parser.RequestParser;
import org.learner.response.CustomHttpResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket = null;
        try{
            // open socket to port 1299
            serverSocket = new ServerSocket(1299);
            System.out.println("Opened socket: " + 1299);
            while(true){
                // keep listening for new clients, one at a time
                try{
                    socket = serverSocket.accept();

                }
                catch (IOException e){
                    System.out.println("Error opening socket");
                    System.exit(1);
                }

                InputStream inputStream = socket.getInputStream();
                byte[] b = new byte[1024*20];
                inputStream.read(b);
                String input = new String(b).trim();


                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(out, true); // char output to the client

                // HTTP Response
                if(!input.isEmpty()){
                    //writer.println(processRequest(input));
                    System.out.println(processRequest(input));
                }
                else{
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Server: TEST");
                    writer.println("Connection: close");
                    writer.println("Content-type: text/html");
                    writer.println("");
                }
                socket.close();

            }
        }
        catch (IOException e){
            System.out.println("Error opening socket");
            System.exit(1);
        }
    }

    public static String processRequest(String requestString){
        ParsedRequest parsedRequest = RequestParser.parse(requestString);
        BaseHandler handler = HandlerFactory.getHandler(parsedRequest);
        CustomHttpResponse response = handler.handleRequest(parsedRequest);
        //response.headers.put("Content-type", "application/json");
        return response.toString();
    }
}