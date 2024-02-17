package de.villigi.minecraft;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;

public class Minecraft {


    public static HashMap<String, Process> processMap = new HashMap<>();

    public static void download(String servername) {
        String folder = "./minecraft/"+ servername + "/";
        String serverUrl = "https://launcher.mojang.com/v1/objects/bb2b6b1aefcd70dfd1892149ac3a215f6c636b07/server.jar";
        String serverFileName = "server.jar";
        try {
            downloadFile(serverUrl, serverFileName);

            // Schritt 2: Serververzeichnis erstellen, falls nicht vorhanden
            File serverDirectory = new File(folder);
            if (!serverDirectory.exists()) {
                serverDirectory.mkdirs();
            }

            // Schritt 3: Server JAR-Datei ins Serververzeichnis verschieben
            File serverFile = new File(serverFileName);
            File newServerFile = new File(serverDirectory, serverFileName);
            serverFile.renameTo(newServerFile);

            try {
                File file = new File("minecraft/"+servername+"/eula.txt");
                if(!file.exists()) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("minecraft/"+servername+"/eula.txt"));
                    writer.write("eula=true");
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", serverFileName);
            processBuilder.directory(serverDirectory);
            Process process = processBuilder.start();

            processMap.put(servername, process);

            System.out.println("Minecraft Server wurde erfolgreich installiert in: " + folder);
        } catch (IOException e) {
            System.err.println("Fehler beim Installieren des Servers: " + e.getMessage());
        }





    }

    public static void downloadFile(String url, String fileName) throws IOException {
        URL website = new URL(url);
        try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
             FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}
