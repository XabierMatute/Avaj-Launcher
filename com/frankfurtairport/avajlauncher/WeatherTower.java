package com.frankfurtairport.avajlauncher;

public class WeatherTower extends Tower {
    private WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinates p_coordinates) {
        return weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        weatherProvider.update();
        this.conditionChanged();
    }
}