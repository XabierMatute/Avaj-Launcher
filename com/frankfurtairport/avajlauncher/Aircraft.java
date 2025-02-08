package com.frankfurtairport.avajlauncher;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an aircraft.
 */
public class Aircraft extends Flyable {
    protected static List<Long> ids = new ArrayList<>();

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    /**
     * Constructor for the Aircraft class.
     * @param p_id The unique identifier.
     * @param p_name The name of the aircraft.
     * @param p_coordinates The coordinates of the aircraft.
     */
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        if (ids.contains(p_id))
            throw new IllegalArgumentException("An aircraft with the id " + p_id + " already exists.");

        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;

        ids.add(p_id);
    }

    public void updateConditions()
    {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        switch (weather) { 
            case "SUN":
                reactToSun();
                break;
            case "RAIN":
                reactToRain();
                break;
            case "FOG" :
                reactToFog();
                break;
            case "SNOW" :
                reactToSnow();
                break;
            default:
            throw new IllegalArgumentException("Condición climática no reconocida: " + weather);
        }
        if 
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "("+ id + ")";
    }
}