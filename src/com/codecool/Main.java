package com.codecool;

import java.util.*;

public class Main {

    private static Boolean isRaining() {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(10);
        // 30% chance to rain
        return random < 3;
    }

    public static void main(String[] args) {
        System.out.println(isRaining());
    }
}
