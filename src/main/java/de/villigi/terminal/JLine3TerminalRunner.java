package de.villigi.terminal;

import de.villigi.Master;

public class JLine3TerminalRunner extends Thread {

    private JLine3Terminal terminal;


    public JLine3TerminalRunner(JLine3Terminal terminal) {
        this.terminal = terminal;

        setDaemon(false);
        setName("JLine3TerminalRunner");
        setPriority(1);
        this.start();
    }

    @Override
    public void run() {
        String line;
        while ((line = terminal.getLineReader().readLine(Master.prefix)) != null) {
            Master.getCommandProvider().call(line.split(" "));

        }

    }




}
