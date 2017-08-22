package com.codecool;

import java.util.*;

public class Main {

    private static List<Car> cars = new ArrayList<>();

    private static Boolean isRaining() {
        double chanceToRain = 0.3;
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();
        return random < chanceToRain;
    }

    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
    }

    private static void simulateRace() {
        int carSpeedLimit = 70; // km/h
        int raceTime = 50; // hours

        for (int i = 0; i < raceTime; i++) {
            if (isRaining()) {
                Car.setSpeedLimit(carSpeedLimit);
                System.out.printf("Race time: %s hour(s), it's raining, speed limit is %s!\n", i + 1, Car.speedLimit);
            }
            System.out.println(Car.speedLimit);
            for (Car car : cars) {
                car.moveForAnHour();
            }
            // Reset speed limit of the cars after an hour
            Car.setSpeedLimit(0);
        }
    }

    private static void printRaceResults() {
        cars.sort((car1, car2) -> car2.distanceTraveled - car1.distanceTraveled);
        int counter = 1;
        for (Car car : cars) {
            System.out.print(counter + ": ");
            System.out.print(car.name + " - ");
            System.out.print(car.distanceTraveled + " km - ");
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
