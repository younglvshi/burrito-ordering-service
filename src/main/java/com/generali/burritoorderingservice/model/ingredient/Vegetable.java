package com.generali.burritoorderingservice.model.ingredient;

public enum Vegetable {

    CABBAGE("cabbage"),
    CORN("corn"),
    JALAPENOS("jalapenos");

    private final String type;

    Vegetable(String type) {
        this.type = type;
    }

    public static Vegetable getVegetable(String type) {
        if (type.equals("corn")) {
            return CORN;
        }
        if (type.equals("jalapenos")) {
            return JALAPENOS;
        }
        return CABBAGE;  // default to this if the request has typo
    }

}
