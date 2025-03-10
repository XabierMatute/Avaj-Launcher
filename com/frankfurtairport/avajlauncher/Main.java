package com.frankfurtairport.avajlauncher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {
    private static String path;
    private static int simulationCount = 0;
    private static WeatherTower weatherTower = new WeatherTower();
    private static AircraftFactory aircraftFactory = AircraftFactory.getInstance();

    private static String outputFile = "simulation.txt";
    private static FileWriter writer = null;

    private static void createOutputFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        writer = new FileWriter(file);
        weatherTower.setWriter(writer);
    }

    private static void parseInput(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        if (line == null || !line.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "Invalid input file: first line must be a positive integer instead of: " + line);
        }
        simulationCount = Integer.parseInt(line);
        if (simulationCount < 0) {
            throw new IllegalArgumentException(
                    "Invalid input file: simulation count must be a positive integer instead of: " + simulationCount);
        }
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 5) {
                throw new IllegalArgumentException(
                        "Invalid input file: each aircraft line must have 5 parts: type, name, longitude, latitude, height.\n\tInvalid line: "
                                + line);
            }
            String type = parts[0];
            String name = parts[1];
            int longitude = Integer.parseInt(parts[2]);
            int latitude = Integer.parseInt(parts[3]);
            int height = Integer.parseInt(parts[4]);
            Coordinates coordinates = new Coordinates(longitude, latitude, height);

            Flyable aircraft = aircraftFactory.newAircraft(type, name, coordinates);
            if (aircraft == null)
                throw new IllegalArgumentException("cannot create aircraft of type " + type);
            aircraft.registerTower(weatherTower);
        }
        reader.close();
    }

    private static void runSimulation() {
        for (int i = 0; i < simulationCount; i++) {
            weatherTower.changeWeather();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java com.frankfurtairport.avajlauncher.Main <input_file>");
            return;
        }
        path = args[0];
        try {
            createOutputFile(outputFile);
            parseInput(path);
            runSimulation();
            writer.close();
        } catch (Coordinates.InvalidCoordinateException e) {
            System.out.println("Invalid coordinate error: " + e.getMessage());
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage() + " " + e.getClass());
        }
    }
}
