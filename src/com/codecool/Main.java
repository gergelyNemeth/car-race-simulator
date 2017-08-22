package com.codecool;

import java.util.*;

public class Main {

    private static List<Car> cars = new ArrayList<>();
    private static List<Motorcycle> motorcycles = new ArrayList<>();
    private static List<Truck> trucks = new ArrayList<>();

    private static Boolean isRaining() {
        double chanceToRain = 0.3;
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();
        return random < chanceToRain;
    }

    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
            motorcycles.add(new Motorcycle());
            trucks.add(new Truck());
        }
    }

    private static void simulateRace() {
        int carSpeedLimit = 70; // km/h
        int raceTime = 50; // hours

        for (int i = 0; i < raceTime; i++) {
            if (isRaining()) {
                Car.setSpeedLimit(carSpeedLimit);
            }
            for (Car car : cars) {
                car.moveForAnHour();
            }
            // Reset speed limit of the cars after an hour
            Car.setSpeedLimit(0);

            for (Motorcycle motorcycle : motorcycles) {
                if (isRaining()) {
                    motorcycle.setRainSpeed();
                }
                motorcycle.moveForAnHour();
            }

            for (Truck truck : trucks) {
                truck.moveForAnHour();
            }
        }
    }

    private static void printRaceResults() {
        cars.sort((car1, car2) -> car2.distanceTraveled - car1.distanceTraveled);
        motorcycles.sort((m1, m2) -> m2.distanceTraveled - m1.distanceTraveled);
        trucks.sort((t1, t2) -> t2.distanceTraveled - t1.distanceTraveled);
        int place = 1;
        System.out.println("Cars:");
        for (Car car : cars) {
            printVehicles(place, car);
            place++;
        }
        place = 1;
        System.out.println("\nMotorcycles:");
        for (Motorcycle motorcycle : motorcycles) {
            printVehicles(place, motorcycle);
            place++;
        }
        place = 1;
        System.out.println("\nTrucks:");
        for (Truck truck : trucks) {
            printVehicles(place, truck);
            place++;
        }
    }

    private static void printVehicles(int place, Car car) {
        printVehicles(place,
                car.name,
                car.distanceTraveled,
                car.getClass().getSimpleName());
    }

    private static void printVehicles(int place, Motorcycle motorcycle) {
        printVehicles(place,
                motorcycle.name,
                motorcycle.distanceTraveled,
                motorcycle.getClass().getSimpleName());
    }

    private static void printVehicles(int place, Truck truck) {
        printVehicles(place,
                truck.name,
                truck.distanceTraveled,
                truck.getClass().getSimpleName());
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
