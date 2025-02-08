package com.frankfurtairport.avajlauncher;

/**
 * Abstract class representing a flyable object.
 */
abstract class Flyable
{
    /**
     * The weather tower to which the flyable object is registered.
     */
    protected WeatherTower weatherTower;

    /**
     * Updates the conditions of the flyable object.
     */
    public abstract void updateConditions();

    /**
     * Registers the flyable object with a weather tower.
     * @param weatherTower The weather tower to register with.
     */
    public void registerTower(WeatherTower p_Tower)
    {
        this.weatherTower = p_Tower;
        weatherTower.register(this);
    }
}