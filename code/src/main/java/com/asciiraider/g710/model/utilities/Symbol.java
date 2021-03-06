package com.asciiraider.g710.model.utilities;

public class Symbol {

    private char ascii;
    private HexColorString foregroundColor;
    private HexColorString backgroundColor;

    public Symbol(char ascii, HexColorString foregroundColor) {
        this.backgroundColor = new HexColorString();
        this.foregroundColor = foregroundColor;
        this.ascii = ascii;
    }

    public Symbol(char ascii, HexColorString foregroundColor, HexColorString backgroundColor) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.ascii = ascii;
    }

    public char getAscii() {
        return ascii;
    }

    public String getForegroundColorString() {
        return foregroundColor.toString();
    }

    public String getBackgroundColorString() {
        return backgroundColor.toString();
    }
    public void setForegroundColor(HexColorString hexColor) {
        this.foregroundColor = hexColor;
    }

    public void setBackgroundColor(HexColorString hexColor) {
        this.backgroundColor = hexColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return getAscii() == symbol.getAscii() &&
                getForegroundColorString().equals(symbol.getForegroundColorString()) &&
                getBackgroundColorString().equals(symbol.getBackgroundColorString());
    }
}
