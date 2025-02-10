package com.frankfurtairport.avajlauncher;

abstract class Flyable
{
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_Tower)
    {
        this.weatherTower = p_Tower;
        weatherTower.register(this);
    }

    protected void sendMessage(String p_message)
    {
        weatherTower.reciveMessage(this, p_message);
    }
}