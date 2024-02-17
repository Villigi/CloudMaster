package de.villigi.server;

import de.villigi.Master;
import de.villigi.terminal.Screen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {

    private ServerSocket server;


    public Server(int port) {
        try {
            server =  new ServerSocket(port);
            //server.setSoTimeout(100000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void running() {
        while (true) {
            try {
                Socket client = server.accept();
                if(Screen.isInScreen(Screen.CLIENT_LOGGER)) {
                    Master.getTerminal().write("-----------» Client Connection «-----------");
                    Master.getTerminal().write(("Waiting for client ... "));
                    Master.getTerminal().write(("Port: " + server.getLocalPort()));
                    Master.getTerminal().write("adress: " + client.getRemoteSocketAddress());
                    Master.getTerminal().write("--------------------------------------------");
                }else{
                    Master.getTerminal().write(Master.prefix + "A client logged into the server!");
                }
                DataInputStream input = new DataInputStream(client.getInputStream());
               // DataOutputStream output = new DataOutputStream(client.getOutputStream());
                String inputString = input.readLine();
                //String inputStringNormal = input.readLine();
                System.out.println(inputString);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
