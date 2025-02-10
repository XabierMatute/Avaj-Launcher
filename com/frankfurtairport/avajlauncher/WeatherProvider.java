package com.frankfurtairport.avajlauncher;

import java.util.Random;

public class WeatherProvider
{
    private static String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};
    private static WeatherProvider instance = null;

    private SineWave rainWave;
    private SineWave snowWave;
    private SineWave fogWave;

    private Random random = new Random();

    private void createNewRainWave()
    {
        double amplitude = random.nextDouble() * 100;
        double frequency = random.nextDouble() * 10 + 0.5;
        double rotation = random.nextDouble() * 2 * Math.PI;
        double phase = random.nextDouble() * Math.PI;
        int height = random.nextInt(55);
        rainWave = new SineWave(amplitude, frequency, rotation, phase, height);
    }

    private void createNewSnowWave()
    {
        double amplitude = random.nextDouble() * 80;
        double frequency = random.nextDouble() * 10 + 0.5;
        double rotation = random.nextDouble() * 2 * Math.PI;
        double phase = random.nextDouble() * 2 * Math.PI;
        int height = random.nextInt(50) + 25;
        snowWave = new SineWave(amplitude, frequency, rotation, phase, height);
    }

    private void createNewFogWave()
    {
        double amplitude = random.nextDouble() * 100;
        double frequency = random.nextDouble() * 10 + 0.5;
        double rotation = random.nextDouble() * 2 * Math.PI;
        double phase = random.nextDouble() * 2 * Math.PI;
        int height = random.nextInt(100);
        fogWave = new SineWave(amplitude, frequency, rotation, phase, height);
    }

    private void createNewWaves()
    {
        createNewRainWave();
        createNewSnowWave();
        createNewFogWave();
    }

    private WeatherProvider() {
        createNewWaves();
    }

    public static WeatherProvider getInstance()
    {
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }


    public void update()
    {
        createNewWaves();
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        if (p_coordinates.getHeight() > fogWave.getValue(p_coordinates))
        {
            return weather[0];
        }
        if (p_coordinates.getHeight() < rainWave.getValue(p_coordinates))
        {
            return weather[2];
        }   
        if (p_coordinates.getHeight() < snowWave.getValue(p_coordinates) && p_coordinates.getHeight() > rainWave.getValue(p_coordinates))
        {
            return weather[3];
        }

        return weather[1];
    }
}