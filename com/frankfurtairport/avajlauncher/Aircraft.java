package com.frankfurtairport.avajlauncher;

import java.util.ArrayList;
import java.util.List;

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

    protected String landMessage = "generic reaction to landing";

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
                sendMessage(sunMessage);
                this.coordinates.incrementLongitude(sunLongitudeIncrement);
                this.coordinates.incrementLatitude(sunLatitudeIncrement);
                this.coordinates.incrementHeight(sunHeightIncrement);
                break;
            case "RAIN":
                sendMessage(rainMessage);
                this.coordinates.incrementHeight(rainHeightIncrement);
                this.coordinates.incrementLongitude(rainLongitudeIncrement);
                this.coordinates.incrementLatitude(rainLatitudeIncrement);
                break;
            case "FOG" :
                sendMessage(fogMessage);
                this.coordinates.incrementHeight(fogHeightIncrement);
                this.coordinates.incrementLongitude(fogLongitudeIncrement);
                this.coordinates.incrementLatitude(fogLatitudeIncrement);
                break;
            case "SNOW" :
                sendMessage(snowMessage);
                this.coordinates.incrementHeight(snowHeightIncrement);
                this.coordinates.incrementLongitude(snowLongitudeIncrement);
                this.coordinates.incrementLatitude(snowLatitudeIncrement);
                break;
            default:
                throw new IllegalArgumentException("Condición climática no reconocida: " + weather);
        }
        if (this.coordinates.getHeight() <= 0) {
            sendMessage(landMessage);
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "("+ id + ")";
    }
}