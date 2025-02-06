package com.frankfurtairport.avajlauncher;

import java.util.Random;

// class WeatherProvider <<Singleton>>
// {
// -string[] weather
// -WeatherProvider()
// +string getCurrentWeather(Coordinates p_coordinates)
// }


class WeatherProvider
{
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider instance = null;

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance()
    {
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        //WIP modo filadelfia
        //TODO: una forma de generarlo que dependa de las cordenadas y me mole
    
        return "SUN";
    }
}