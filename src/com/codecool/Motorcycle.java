package com.codecool;

import java.util.Random;

class Motorcycle implements Vehicle {
    private String name;
    private static int nameNumber = 1;
    private static int normalSpeed = 100;
    private int actualSpeed;
    private int rainSpeed;
    private int distanceTraveled;

    Motorcycle() {
        actualSpeed = normalSpeed;
        name = "Motorcycle " + Integer.toString(nameNumber);
        distanceTraveled = 0;
        nameNumber += 1;
    }

    public void setRainSpeed() {
        Random randomGenerator = new Random();
        int minSlowingDown = 5;
        int maxSlowingDown = 50;
        double random = randomGenerator.nextDouble();
        rainSpeed = normalSpeed - (int) ((random * maxSlowingDown) - minSlowingDown);
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void moveForAnHour() {
        if (rainSpeed > 0) {
            actualSpeed = rainSpeed;
        } else {
            actualSpeed = normalSpeed;
        }
        distanceTraveled += actualSpeed;
    }
}
