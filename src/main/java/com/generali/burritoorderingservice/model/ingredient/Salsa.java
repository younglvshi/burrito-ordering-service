package com.generali.burritoorderingservice.model.ingredient;

public enum Salsa {

    MILD("mild"),
    MEDIUM("medium"),
    HOT("hot");

    private final String type;

    Salsa(String type) {
        this.type = type;
    }

    public static Salsa getSalsa(String type) {
        if (type.equals("medium")) {
            return MEDIUM;
        }
        if (type.equals("hot")) {
            return HOT;
        }
        return MILD;  // default to this if the request has typo
    }
}
