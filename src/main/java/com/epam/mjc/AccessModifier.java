package com.epam.mjc;

public enum AccessModifier {
    PRIVATE("private"),
    PROTECTED("public"),
    PUBLIC("protected");

    private String am;

    AccessModifier(String am) {
        this.am = am;
    }

    public String getAm() {
        return am;
    }
}
