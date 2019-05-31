package com.asciiraider.g710.model.utilities;

import java.util.Objects;

public class Symbol {

    private char ascii;
    private HexColorString foregroundColor;
    private HexColorString backgroundColor;
    //private String resource;

    public Symbol(char ascii, HexColorString foregroundColor) {//, String resource) {
        this.backgroundColor = new HexColorString();
        this.foregroundColor = foregroundColor;
        this.ascii = ascii;
        //this.resource = resource;
    }

    public Symbol(char ascii, HexColorString foregroundColor, HexColorString backgroundColor) {//, String resource) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.ascii = ascii;
        //this.resource = resource;
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
/*
    public String getResource() {
        return resource;
    }
*/
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
                Objects.equals(foregroundColor, symbol.foregroundColor) &&
                Objects.equals(backgroundColor, symbol.backgroundColor);
    }
}
