package de.villigi.commands.impl;

import de.villigi.Master;
import de.villigi.commands.Command;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        Master.getTerminal().write("------------» Endervillage «------------");
        Master.getTerminal().write("Commands:");
        Master.getTerminal().write(" - stop » This will stop the Endervillage Service. ");
        Master.getTerminal().write(" - help » This will shows all commands or events.");
        Master.getTerminal().write(" - screen <screen: clientlog> » This will show the client log. ");
        Master.getTerminal().write("");
        Master.getTerminal().write("----------------------------------------");



    }
}
