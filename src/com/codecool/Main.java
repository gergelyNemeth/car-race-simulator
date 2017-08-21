package com.codecool;

import java.util.*;

public class Main {

    private static List<Car> cars = new ArrayList<>();

    private static Boolean isRaining() {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(10);
        // 30% chance to rain
        return random < 3;
    }

    private static void createVehicles() {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(10);
        // 30% chance to limit the cars speed to 70 km/h
        if (random <= 3) {
            Car.setSpeedLimit(70);
        }
        // Create 10 cars
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
    }


    public static void main(String[] args) {
        createVehicles();
    }
}
