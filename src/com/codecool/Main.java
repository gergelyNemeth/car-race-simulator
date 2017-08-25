package com.codecool;

import java.util.*;

public class Main {

    private static List<Vehicle> cars = new ArrayList<>();
    private static List<Vehicle> motorcycles = new ArrayList<>();
    private static List<Vehicle> trucks = new ArrayList<>();
    private static List<Vehicle> vehicles = new ArrayList<>();

    private static Boolean isRaining() {
        double chanceToRain = 0.3;
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();
        return random < chanceToRain;
    }

    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Vehicle car = new Car();
            Vehicle motorcycle = new Motorcycle();
            Vehicle truck = new Truck();
            cars.add(car);
            motorcycles.add(motorcycle);
            trucks.add(truck);
            vehicles.add(car);
            vehicles.add(motorcycle);
            vehicles.add(truck);
        }
    }

    private static void simulateRace() {
        int carSpeedLimit = 70; // km/h
        int raceTime = 50; // hours

        for (int i = 0; i < raceTime; i++) {
            if (isRaining()) {
                Car.setSpeedLimit(carSpeedLimit);
            }
            for (Vehicle car : cars) {
                car.moveForAnHour();
            }
            // Reset speed limit of the cars after an hour
            Car.setSpeedLimit(0);

            for (Vehicle  motorcycle : motorcycles) {
                if (isRaining()) {
                    motorcycle.setRainSpeed();
                }
                motorcycle.moveForAnHour();
            }

            for (Vehicle  truck : trucks) {
                truck.moveForAnHour();
            }
        }
    }

    private static void printRaceResults() {
        vehicles.sort((v1, v2) -> v2.getDistanceTraveled() - v1.getDistanceTraveled());
        int place = 1;
        System.out.println("\nRace Results:\n");
        for (Vehicle vehicle : vehicles) {
            printVehicles(place, vehicle);
            place++;
        }
    }

    private static void printVehicles(int place, Vehicle vehicle) {
        printVehicles(place,
                vehicle.getName(),
                vehicle.getDistanceTraveled(),
                vehicle.getClass().getSimpleName());
    }

    private static void printVehicles(int place, String name, int distanceTraveled, String type) {
        System.out.print(place + ": ");
        System.out.print(name + " - ");
        System.out.print(distanceTraveled + " km - ");
        System.out.println(type);
    }


    public static void main(String[] args) {
        createVehicles();
        simulateRace();
        printRaceResults();
    }
}
