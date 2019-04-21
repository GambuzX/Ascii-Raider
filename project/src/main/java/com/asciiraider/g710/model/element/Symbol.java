package com.asciiraider.g710.model.element;

import java.security.InvalidParameterException;

public class Symbol {

    private char ascii;
    private String hexColor;

    public Symbol(char ascii, String hexColor) throws InvalidParameterException {
        setHexColor(hexColor);
        this.ascii = ascii;
    }

    public char getAscii() {
        return ascii;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) throws InvalidParameterException {
        if (!validHexColor(hexColor)) throw new InvalidParameterException("Invalid hex color");
        this.hexColor = hexColor;
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
