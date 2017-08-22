package com.codecool;

import java.util.Random;

class Car {
    String name;
    static int speedLimit = 0;
    private int normalSpeed;
    int distanceTraveled;
    int actualSpeed;

    static void setSpeedLimit(int limit) {
        speedLimit = limit;
    }

    Car() {
        Random randomGenerator = new Random();
        // Speed
        int minSpeed = 80;
        int maxSpeed = 110;
        double random = randomGenerator.nextDouble();
        normalSpeed = minSpeed + (int) (random * (maxSpeed - minSpeed));
        actualSpeed = normalSpeed;
        // Name
        String[] names = {"Elysium", "Specter", "Wolf", "Legacy", "Buffalo", "Centaur",
                "Prestige", "Intro", "Blend", "Evolution", "Crest", "Thunder",
                "Nebula", "Chase", "Shadow", "Quicksilver", "Trailblazer", "Guardian",
                "Blast", "Enigma", "Centurion", "Bolt", "Vortex", "Fragment", "Freedom",
                "Renegade", "Hydra", "Stardust", "Liberty", "Desire"};
        int i = 0;
        int j = 0;
        while (i == j) {
            i = randomGenerator.nextInt(30);
            j = randomGenerator.nextInt(30);
        }
        name = names[i] + " " + names[j];

        distanceTraveled = 0;
    }

    void moveForAnHour() {
        if (speedLimit > 0) {
            actualSpeed = speedLimit;
        } else {
            actualSpeed = normalSpeed;
        }
        distanceTraveled += actualSpeed;
    }
}
