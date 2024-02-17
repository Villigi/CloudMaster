package de.villigi.commands.impl;

import de.villigi.Master;
import de.villigi.commands.Command;

import java.util.concurrent.TimeUnit;

public class ShutdownCommand implements Command {
    @Override
    public void execute(String[] args) {

        Master.getTerminal().write(Master.prefix + "The Server will shutdown in 3 Seconds!");

      /*  try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       */

        Master.getTerminal().write(Master.prefix + "Server shutting down!");

        System.exit(0);
    }
}
