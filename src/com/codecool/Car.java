package com.codecool;

import java.util.Random;

class Car {
    String name;
    private int normalSpeed;
    private int distanceTraveled;
    int distance;
    private static int speedLimit;

    private static final int MINSPEED = 80;
    private static final int MAXSPEED = 120;

    static void setSpeedLimit(int limit) {
        speedLimit = limit;
    }

    Car() {
        Random randomGenerator = new Random();
        // Speed
        Float random = randomGenerator.nextFloat();
        normalSpeed = MINSPEED + (int) (random * (MAXSPEED - MINSPEED));
        if (speedLimit > 0) {
            normalSpeed = speedLimit;
        }
        // Name
        String[] names = {"Elysium", "Specter", "Wolf", "Legacy", "Buffalo", "Centaur",
                "Prestige", "Intro", "Blend", "Evolution", "Crest", "Thunder",
                "Nebula", "Chase", "Shadow", "Quicksilver", "Trailblazer", "Guardian",
                "Blast", "Enigma"};
        int i = 0;
        int j = 0;
        while (i == j) {
            i = randomGenerator.nextInt(20);
            j = randomGenerator.nextInt(20);
        }
        name = names[i] + " " + names[j];

        distanceTraveled = 0;
    }

    void moveForAnHour() {
        distanceTraveled += 1;
        distance = normalSpeed * distanceTraveled;
    }
}
