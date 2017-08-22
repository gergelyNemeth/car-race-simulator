package com.codecool;

import java.util.Random;

class Truck {

    String name;
    private int normalSpeed = 100;
    private int actualSpeed;
    private int breakDownLeft;

    int distanceTraveled;

    Truck() {
        actualSpeed = normalSpeed;
        breakDownLeft = 0;

        Random randomGenerator = new Random();
        int nameNumber = randomGenerator.nextInt(100);
        name = Integer.toString(nameNumber);

        distanceTraveled = 0;
    }

    private Boolean breakDown() {
        if (breakDownLeft > 0) {
            breakDownLeft -= 1;
            return true;
        } else {
            double chanceToBreakDown = 0.05;
            Random randomGenerator = new Random();
            double random = randomGenerator.nextDouble();

            if (random < chanceToBreakDown) {
                breakDownLeft = 2;
                return true;
            }
            return false;
        }
    }

    void moveForAnHour() {
        if (breakDown()) {
            actualSpeed = 0;
        } else {
            actualSpeed = normalSpeed;
        }
        distanceTraveled += actualSpeed;
    }
}
