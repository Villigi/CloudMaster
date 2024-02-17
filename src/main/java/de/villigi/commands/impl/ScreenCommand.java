package de.villigi.commands.impl;

import de.villigi.Master;
import de.villigi.commands.Command;
import de.villigi.minecraft.Minecraft;
import de.villigi.terminal.Screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScreenCommand implements Command {


    public static List<Screen> currentScreen = new ArrayList<>();
    public static List<String> screenName = new ArrayList<>();

    @Override
    public void execute(String[] args) {
        if(args.length == 1) {
            String screen = args[0];
            if(screen.equalsIgnoreCase("clientlog")) {
                if(currentScreen.contains(Screen.CLIENT_LOGGER)) {
                    currentScreen.remove(Screen.CLIENT_LOGGER);
                    Master.getTerminal().write(Master.prefix + "You no more see this screen.");
                }else {
                    currentScreen.add(Screen.CLIENT_LOGGER);
                    Master.getTerminal().write(Master.prefix + "You are see now the CLIENT_LOGGER screen.");
                }
            }else if(Minecraft.processMap.containsKey(args[0])){
                if(screenName.contains(args[0])) {
                    currentScreen.remove(Screen.MINECRAFT_SERVER);
                    screenName.remove(args[0]);
                    Master.getTerminal().write(Master.prefix + "You no more see this screen.");
                }else{
                    screenName.add(args[0]);
                    Master.getTerminal().write(Master.prefix + "You are see now the CLIENT_LOGGER screen.");
                    Screen.sendMinecraftScreen(args[0]);
                }
            }
        }else{
            Master.getTerminal().write(Master.prefix + "Please use: screen <screens: clientlog>");
        }



    }
}
