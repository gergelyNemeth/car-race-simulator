package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Car implements Vehicle {
    private String name;
    private static int speedLimit = 0;
    private int normalSpeed;
    private int actualSpeed;
    private int distanceTraveled;
    private static List<String> usedNames = new ArrayList<>();

    Car() {
        actualSpeed = calculateNormalSpeed();
        name = createNewName();
        distanceTraveled = 0;
    }

    private int calculateNormalSpeed() {
        Random randomGenerator = new Random();
        int minSpeed = 80;
        int maxSpeed = 110;
        double random = randomGenerator.nextDouble();
        normalSpeed = minSpeed + (int) (random * (maxSpeed - minSpeed));

        return normalSpeed;
    }

    private String createNewName() {
        String[] names = {"Elysium", "Specter", "Wolf", "Legacy", "Buffalo", "Centaur",
                "Prestige", "Intro", "Blend", "Evolution", "Crest", "Thunder",
                "Nebula", "Chase", "Shadow", "Quicksilver", "Trailblazer", "Guardian",
                "Blast", "Enigma", "Centurion", "Bolt", "Vortex", "Fragment", "Freedom",
                "Renegade", "Hydra", "Stardust", "Liberty", "Desire"};
        Random randomGenerator = new Random();
        int i = 0;
        int j = 0;
        Boolean nameNotUsed = true;
        String newName = "";
        while (nameNotUsed) {
            while (i == j) {
                i = randomGenerator.nextInt(30);
                j = randomGenerator.nextInt(30);
            }
            newName = names[i] + " " + names[j];
            if (!usedNames.contains(newName)) {
                usedNames.add(newName);
                nameNotUsed = false;
            }
            i = j;
        }
        return newName;
    }

    static void setSpeedLimit(int limit) {
        speedLimit = limit;
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void moveForAnHour() {
        setRainSpeed();
        distanceTraveled += actualSpeed;
    }

    public void setRainSpeed() {
        if (speedLimit > 0) {
            actualSpeed = speedLimit;
        } else {
            actualSpeed = normalSpeed;
        }
    }
}
