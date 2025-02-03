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
    private static int seed

    private WeatherProvider() {
        Random random = new Random();
        seed = random.nextInt();
    }

    public static WeatherProvider getInstance()
    {
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        return weather[weatherIndex];
    }
}