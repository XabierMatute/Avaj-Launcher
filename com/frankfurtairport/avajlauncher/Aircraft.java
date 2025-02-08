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

    protected String sunMessage = "generic reaction to sun";
    protected int sunLongitudeIncrement = 0;
    protected int sunLatitudeIncrement = 0;
    protected int sunHeightIncrement = 0;
    
    protected String rainMessage = "generic reaction to rain";
    protected int rainLongitudeIncrement = 0;
    protected int rainLatitudeIncrement = 0;
    protected int rainHeightIncrement = 0;
    
    protected String fogMessage = "generic reaction to fog";
    protected int fogHeightIncrement = 0;
    protected int fogLongitudeIncrement = 0;
    protected int fogLatitudeIncrement = 0;
    
    protected String snowMessage = "generic reaction to snow";
    protected int snowHeightIncrement = 0;
    protected int snowLongitudeIncrement = 0;
    protected int snowLatitudeIncrement = 0;

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
                System.out.println(this + ": " + sunMessage);
                this.coordinates.incrementLongitude(sunLongitudeIncrement);
                this.coordinates.incrementLatitude(sunLatitudeIncrement);
                this.coordinates.incrementHeight(sunHeightIncrement);
                break;
            case "RAIN":
                System.out.println(this + ": " + rainMessage);
                this.coordinates.incrementHeight(rainHeightIncrement);
                this.coordinates.incrementLongitude(rainLongitudeIncrement);
                this.coordinates.incrementLatitude(rainLatitudeIncrement);
                break;
            case "FOG" :
                System.out.println(this + ": " + fogMessage);
                this.coordinates.incrementHeight(fogHeightIncrement);
                this.coordinates.incrementLongitude(fogLongitudeIncrement);
                this.coordinates.incrementLatitude(fogLatitudeIncrement);
                break;
            case "SNOW" :
                System.out.println(this + ": " + snowMessage);
                this.coordinates.incrementHeight(snowHeightIncrement);
                this.coordinates.incrementLongitude(snowLongitudeIncrement);
                this.coordinates.incrementLatitude(snowLatitudeIncrement);
                break;
            default:
                throw new IllegalArgumentException("Condición climática no reconocida: " + weather);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "("+ id + ")";
    }
}