package de.villigi.terminal;

import de.villigi.Master;
import de.villigi.commands.impl.ScreenCommand;
import de.villigi.minecraft.Minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum Screen {


    CLIENT_LOGGER, MINECRAFT_SERVER;

    public static boolean isInScreen(Screen screen) {
        boolean b = false;
        if(ScreenCommand.currentScreen.contains(screen)) {
            b = true;
        }
        return b;
    }


    public static void sendMinecraftScreen(String servername) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(Minecraft.processMap.get(servername).getInputStream()));
            Thread thread = new Thread(() -> {
                String line;
                System.out.println("write!");
                try{
                    while ((line = reader.readLine()) != null) {
                        if(ScreenCommand.screenName.contains(servername)) {
                            Master.getTerminal().write(line);
                        }else{
                            break;
                        }
                    }
                }catch (IOException x) {
                    x.printStackTrace();
                }
            });
            thread.start();
    }


}
