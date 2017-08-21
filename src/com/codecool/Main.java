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

    private static void simulateRace() {
        // Move the vehicles for 50 hours
        for (int i = 0; i < 50; i++) {
            for (Car car : cars) {
                car.moveForAnHour();
            }
        }
        if (isRaining()) {
            System.out.println("It's a rainy day!");
        }
    }

    private static void printRaceResults() {
        cars.sort((car1, car2) -> car2.distance - car1.distance);
        int counter = 1;
        for (Car car : cars) {
            System.out.print(counter + ": ");
            System.out.print(car.name + " - ");
            System.out.print(car.distance + " km - ");
            System.out.println(car.getClass().getSimpleName());
            counter++;
        }
    }


    public static void main(String[] args) {
        createVehicles();
        simulateRace();
        printRaceResults();
    }
}
