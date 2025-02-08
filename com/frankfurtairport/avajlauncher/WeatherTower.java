package com.frankfurtairport.avajlauncher;

/**
 * Represents a weather tower that provides weather information.
 */
public class WeatherTower extends Tower {
    private WeatherProvider weatherProvider = WeatherProvider.getInstance();

    /**
     * Gets the current weather for the given coordinates.
     * @param p_coordinates The coordinates to get the weather for.
     * @return The current weather as a string.
     */
    public String getWeather(Coordinates p_coordinates) {
        return weatherProvider.getCurrentWeather(p_coordinates);
    }

    /**
     * Changes the weather conditions.
     */
    public void changeWeather() {
        weatherProvider.update();
        this.conditionChanged();
    }
}