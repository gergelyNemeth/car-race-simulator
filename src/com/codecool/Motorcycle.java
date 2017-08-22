package com.codecool;

import java.util.Random;

class Motorcycle {
    String name;
    private int normalSpeed = 100;
    private int actualSpeed;
    private int rainSpeed;
    int distanceTraveled;

    Motorcycle(int nameNumber) {
        actualSpeed = normalSpeed;
        name = "Motorcycle " + Integer.toString(nameNumber);
        distanceTraveled = 0;
    }

    void setRainSpeed() {
        Random randomGenerator = new Random();
        int minSlowingDown = 5;
        int maxSlowingDown = 50;
        double random = randomGenerator.nextDouble();
        rainSpeed = normalSpeed - (int) ((random * maxSlowingDown) - minSlowingDown);
    }

    void moveForAnHour() {
        if (rainSpeed > 0) {
            actualSpeed = rainSpeed;
        } else {
            actualSpeed = normalSpeed;
        }
        distanceTraveled += actualSpeed;
    }
}
