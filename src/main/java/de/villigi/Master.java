package de.villigi;

import de.villigi.commands.CommandProvider;
import de.villigi.server.Server;
import de.villigi.terminal.JLine3Terminal;

import java.util.concurrent.TimeUnit;

public class Master {

    private static JLine3Terminal terminal;
    private static CommandProvider commandProvider;

    public static String prefix = "Cloud » ";

    public static void main(String[] args) {
        System.out.println("test");
        terminal = new JLine3Terminal();
        commandProvider = new CommandProvider();

        getTerminal().write(prefix + "---------------------------------------------");
        getTerminal().write(prefix + "xxxxxxx - The cloud will start - xxxxxxx");
        getTerminal().write(prefix + "---------------------------------------------");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        getTerminal().write(prefix + "--------------------Info---------------------");
        getTerminal().write(prefix + "Use the screen command to see the client log!");
        getTerminal().write(prefix + "Use the help command to see all commands!");
        getTerminal().write(prefix + "---------------------------------------------");

        getTerminal().write(prefix + "Cloud loaded ✓");


        Server server = new Server(1338);
        server.running();
    }

    public static CommandProvider getCommandProvider() {
        return commandProvider;
    }
    public static JLine3Terminal getTerminal() {
        return terminal;
    }

}
