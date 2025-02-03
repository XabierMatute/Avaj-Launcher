package com.frankfurtairport.avajlauncher;

public class AircraftFactory {
    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(System.currentTimeMillis(), p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(System.currentTimeMillis(), p_name, p_coordinates);
            case "Baloon":
                return new Baloon(System.currentTimeMillis(), p_name, p_coordinates);
            default:
                return null;
        }
    }
}