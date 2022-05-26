package com.generali.burritoorderingservice.model.ingredient;

public enum Tortilla {

    CORN("corn"),
    FLOUR("flour");

    private final String type;

    Tortilla(String type) {
        this.type = type;
    }

    public static Tortilla getTortilla(String type) {
        if (type.equals("corn")) {
            return CORN;
        }
        return FLOUR;  // default to this if the request has typo
    }

}
