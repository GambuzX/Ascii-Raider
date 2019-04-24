package com.asciiraider.g710.model.element;

import java.security.InvalidParameterException;

public class Symbol {

    private char ascii;
    private String foregroundColor;
    private String backgroundColor;

    public Symbol(char ascii, String foregroundColor) throws InvalidParameterException {
        setForegroundColor(foregroundColor);
        setBackgroundColor("#000000");
        this.ascii = ascii;
    }

    public Symbol(char ascii, String foregroundColor, String backgroundColor) throws InvalidParameterException {
        setForegroundColor(foregroundColor);
        setBackgroundColor(backgroundColor);
        this.ascii = ascii;
    }

    public char getAscii() {
        return ascii;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setForegroundColor(String hexColor) throws InvalidParameterException {
        if (!validHexColor(hexColor)) throw new InvalidParameterException("Invalid hex color");
        this.foregroundColor = hexColor;
    }

    public void setBackgroundColor(String hexColor) throws InvalidParameterException {
        if (!validHexColor(hexColor)) throw new InvalidParameterException("Invalid hex color");
        this.backgroundColor = hexColor;
    }

    private boolean validHexColor(String hexColor) {
        if (hexColor.length() < 2 || hexColor.length() > 7) return false;
        if (hexColor.charAt(0) != '#') return false;
        for (char c : hexColor.substring(1).toCharArray()) {
            if (!isHexChar(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isHexChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }
}
