package com.generali.burritoorderingservice.util;

public class OrderIdGenerator {

    private static int orderId = 100;

    public static int getNextId() {
        return orderId++;
    }
}
