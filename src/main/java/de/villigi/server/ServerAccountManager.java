package de.villigi.server;

import de.villigi.Master;
import de.villigi.terminal.Screen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAccountManager {



    private ServerSocket server;


    public ServerAccountManager(int port) {
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
                String inputString = input.readUTF();
                if(inputString.equals("user=villigi,pw=ChaseDogLove#2021")) {
                    Master.getTerminal().write(Master.prefix + "The Client " + client.getRemoteSocketAddress() + " has sign up in the Endervillage Cloud Client Manager! with the account from Villigi.");
                    DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                    outputStream.write(1);
                }else {
                    Master.getTerminal().write(Master.prefix + "The Client " + client.getRemoteSocketAddress() + " tried to logging in to the Endervillage Cloud Management Client! ");
                    DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                    outputStream.write(0);
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
