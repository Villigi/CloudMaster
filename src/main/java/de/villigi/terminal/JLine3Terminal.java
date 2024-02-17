package de.villigi.terminal;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.io.IOException;

public class JLine3Terminal {


    private Terminal terminal;


    private LineReader lineReader;

    public JLine3Terminal() {


        try {
            this.terminal = TerminalBuilder.builder()
                    .system(true)
                    .dumb(true)
                    .streams(System.in, System.out)
                    .build();

            this.lineReader = LineReaderBuilder.builder().terminal(terminal).build();

            new JLine3TerminalRunner(this);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void write(String input) {
        this.terminal.puts(InfoCmp.Capability.carriage_return);
        this.terminal.writer().println(Color.translate(input));
        this.terminal.flush();
    }
    public LineReader getLineReader() {
        return lineReader;
    }
}
