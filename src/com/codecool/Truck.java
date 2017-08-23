package com.codecool;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Truck {

    private String name;
    private int normalSpeed = 100;
    private int actualSpeed;
    private int breakDownLeft;
    private int distanceTraveled;
    private static List<String> usedNames = new ArrayList<>();

    Truck() {
        actualSpeed = normalSpeed;
        breakDownLeft = 0;
        name = createNewName();
        distanceTraveled = 0;
    }

    private String createNewName() {
        Random randomGenerator = new Random();
        Boolean nameNotUsed = true;
        String newName = "";
        while (nameNotUsed) {
            int nameNumber = randomGenerator.nextInt(100);
            newName = Integer.toString(nameNumber);
            if (!usedNames.contains(newName)) {
                usedNames.add(newName);
                nameNotUsed = false;
            }
        }
        return newName;
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

    String getName() {
        return name;
    }

    int getDistanceTraveled() {
        return distanceTraveled;
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
