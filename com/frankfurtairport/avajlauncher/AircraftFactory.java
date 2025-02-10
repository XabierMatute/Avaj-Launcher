package com.frankfurtairport.avajlauncher;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static int idCounter = 0;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        try {
            Class<?> clazz = Class.forName("com.frankfurtairport.avajlauncher.aircrafts." + p_type);
            return (Flyable) clazz.getConstructor(long.class, String.class, Coordinates.class)
                                  .newInstance(nextId(), p_name, p_coordinates);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private long nextId() {
        return idCounter++;
    }
}