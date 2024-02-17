package de.villigi.commands.impl;

import de.villigi.Master;
import de.villigi.commands.Command;
import de.villigi.minecraft.Minecraft;

public class DebugCommand implements Command {

    public static boolean state = false;


    @Override
    public void execute(String[] args) {

        if(args.length == 1) {
            Master.getTerminal().write(Master.prefix + "Server will start under the name " + args[0]);
            Minecraft.download(args[0]);
        }else{
            Master.getTerminal().write(Master.prefix + "Please give a name for the Server!");
        }

    }
}
