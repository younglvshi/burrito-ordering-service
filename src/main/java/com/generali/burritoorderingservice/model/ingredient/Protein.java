package com.generali.burritoorderingservice.model.ingredient;

public enum Protein {

    BEAN("bean"),
    BEEF("beef"),
    CHICKEN("chicken"),
    PORK("pork"),
    SHRIMP("shrimp"),
    STEAK("steak");

    private final String type;

    Protein(String type) {
        this.type = type;
    }

    public static Protein getProtein(String type) {
        if (type.equals("beef")) {
            return BEEF;
        }
        if (type.equals("chicken")) {
            return CHICKEN;
        }
        if (type.equals("pork")) {
            return PORK;
        }
        if (type.equals("shrimp")) {
            return SHRIMP;
        }
        if (type.equals("steak")){
            return STEAK;
        }
        return BEAN;  // default to this if the request has typo
    }

}
