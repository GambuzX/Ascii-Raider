package com.asciiraider.g710.model.utilities;

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
}
