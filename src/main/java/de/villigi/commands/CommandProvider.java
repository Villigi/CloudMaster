package de.villigi.commands;

import de.villigi.commands.impl.DebugCommand;
import de.villigi.commands.impl.HelpCommand;
import de.villigi.commands.impl.ScreenCommand;
import de.villigi.commands.impl.ShutdownCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommandProvider {


    private HashMap<String, Command> commands = new HashMap<>();

    public void registerCommand(String id, Command command) {
        this.commands.put(id, command);
    }


    public CommandProvider() {
        this.registerCommand("stop", new ShutdownCommand());
        this.registerCommand("help", new HelpCommand());
        this.registerCommand("debug", new DebugCommand());
        this.registerCommand("screen", new ScreenCommand());
    }



    public void call(String[] args) {
        var arguments = new ArrayList<>(Arrays.stream(args).toList());
        String id = arguments.remove(0);
        if(this.commands.containsKey(id)) {
            this.commands.get(id).execute(arguments.toArray(new String[0]));
        }
    }




}
