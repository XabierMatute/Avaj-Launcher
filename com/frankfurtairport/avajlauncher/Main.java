package com.frankfurtairport.avajlauncher;

public class Main
{
    public static void testNoiseMap()
    {
        NoiseMap noiseMap = new NoiseMap();
        System.out.println(noiseMap.getValue(0, 0));
        System.out.println(noiseMap.getValue(1, 1));
        System.out.println(noiseMap.getValue(2, 2));
        System.out.println(noiseMap.getValue(3, 3));
        System.out.println(noiseMap.getValue(3.14159, 3.14159));
        System.out.println(noiseMap.getValue(0.5, 0.5));
    }

    public static void testSineWave()
    {
        SineWave sineWave = new SineWave(1, 1, 0);
        System.out.println(sineWave.getValue(0));
        System.out.println(sineWave.getValue(0.5));
        System.out.println(sineWave.getValue(1));
        System.out.println(sineWave.getValue(1.0 / 2));
        System.out.println(sineWave.getValue(1.0 / 3));
        System.out.println(sineWave.getValue(1.0 / 4));
        System.out.println(sineWave.getValue(1.0 / 8));
        System.out.println(sineWave.getValue(1.0 / 16));
        System.out.println(sineWave.getValue(-0.25));
        // System.out.println(sineWave.getValue(2));
        // System.out.println(sineWave.getValue(3));
        // System.out.println(sineWave.getValue(3.14159));
        // System.out.println(sineWave.getValue(0.5));
    }

        public static void testSineWaves() {
        SineWave sineWave1 = new SineWave(1, 1, 0);
        SineWave sineWave2 = new SineWave(0.5, 2, Math.PI / 2);
        SineWave sineWave3 = new SineWave(0.25, 0.5, Math.PI);

        SineWave[] sineWaveArray = { sineWave1, sineWave2, sineWave3 };
        SineWaves sineWaves = new SineWaves(sineWaveArray);

        System.out.println(sineWaves.getValue(0));       // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 0
        System.out.println(sineWaves.getValue(0.5));     // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 0.5
        System.out.println(sineWaves.getValue(1));       // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 1
        System.out.println(sineWaves.getValue(1.0 / 2)); // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 0.5
        System.out.println(sineWaves.getValue(1.0 / 3)); // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 1/3
        System.out.println(sineWaves.getValue(1.0 / 4)); // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 1/4
        System.out.println(sineWaves.getValue(1.0 / 8)); // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 1/8
        System.out.println(sineWaves.getValue(1.0 / 16));// Expected output: sum of sineWave1, sineWave2, sineWave3 at x = 1/16
        System.out.println(sineWaves.getValue(-0.25));   // Expected output: sum of sineWave1, sineWave2, sineWave3 at x = -0.25
    }

    public static void testFourierSerie()
    {
        // double[] a = {1, 2, 3};
        double[] a = {1};
        // double[] b = {4, 5, 6};
        double[] b = {};
        FourierSerie fourierSerie = new FourierSerie(a, b);
        System.out.println(fourierSerie.getValue(0));
        System.out.println(fourierSerie.getValue(1));
        System.out.println(fourierSerie.getValue(2));
        System.out.println(fourierSerie.getValue(3));
        System.out.println(fourierSerie.getValue(3.14159));
        System.out.println(fourierSerie.getValue(0.5));
    }

    public static void testCoordinates()
    {
        System.out.println("Hello World");
        Coordinates coordinates = new Coordinates(1, 2, 3);
        System.out.println(coordinates);
        System.out.println("Longitude: " + coordinates.getLongitude());
        System.out.println("Latitude: " + coordinates.getLatitude());
        System.out.println("Height: " + coordinates.getHeight());
        Coordinates coordinates2 = new Coordinates(1, 2, 2);
        System.out.println(coordinates2);
        if (coordinates.equals(coordinates2))
        {
            System.out.println("Coordinates are equal");
        }
        else
        {
            System.out.println("Coordinates are not equal");
        }
        System.out.println(coordinates2.incrementHeight(1));
        if (coordinates.equals(coordinates2))
        {
            System.out.println("Coordinates are equal");
        }
        else
        {
            System.out.println("Coordinates are not equal");
        }
        try
        {
            coordinates2 = new Coordinates(1, 3, -42);
        }
        catch (Coordinates.InvalidCoordinateException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            coordinates.decrementHeight(5);
        }
        catch (Coordinates.InvalidCoordinateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        // testCoordinates();
        // testFourierSerie();
        // testSineWave();
        // testSineWaves();
        // testNoiseMap();
        NoiseMap noiseMap = new NoiseMap(5);
        noiseMap.generateCSV("noise_map.csv", 1500, 1500, 1);
    }
}
