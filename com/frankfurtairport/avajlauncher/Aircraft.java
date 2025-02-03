package com.frankfurtairport.avajlauncher;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    // protected WeatherTower weatherTower;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    public void registerTower(WeatherTower p_tower) {
        // this.weatherTower = p_tower;
        p_tower.register(this);
    }
}