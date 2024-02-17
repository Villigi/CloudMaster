package de.villigi.terminal;

import org.fusesource.jansi.Ansi;

public enum Color {

    HIGHLIGHTER(101,101,101),
    DEFAULT(181, 181 ,181),
    DARK(60,60,60);

    String ansi;

    private static final Color[] VALUES = values();

    Color(int red, int green, int blue) {
        this.ansi = Ansi.ansi().a(Ansi.Attribute.RESET).fgRgb(red, green, blue).toString();
    }

    public static String translate(String output) {
        for(Color color : VALUES) {
            output = output.replace("&" + color.ordinal(), color.ansi);
        }
        return output;
    }



}
