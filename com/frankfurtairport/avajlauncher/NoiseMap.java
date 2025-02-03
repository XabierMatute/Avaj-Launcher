package com.frankfurtairport.avajlauncher;

import java.util.Random;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class NoiseMap
{
    private SineWaves abscissa_wave;
    private SineWaves ordinate_wave;
    private SineWaves final_wave;
    private int n;

    private SineWave generateRandomWave()
    {
        Random random = new Random();
        // double amplitude = random.nextDouble();
        // double frequency = random.nextDouble();
        // double phase = random.nextDouble();
        double amplitude = random.nextInt(1420) * 0.1 / this.n;
        double frequency = 1.0/ random.nextInt(100) / random.nextInt(100);
        if (Double.isInfinite(frequency)) {
            frequency = 1.0;
        }
        double phase = random.nextDouble(2 * Math.PI);
        return new SineWave(amplitude, frequency, phase);
    }

    private SineWaves generateRandomWaves(int n)
    {
        SineWave[] waves = new SineWave[n];
        for (int i = 0; i < n; i++)
        {
            waves[i] = generateRandomWave();
        }
        return new SineWaves(waves);
    }

    public NoiseMap(int p_n)
    {
        this.n = p_n;
        this.abscissa_wave = generateRandomWaves(n);
        // this.ordinate_wSineWave[] waves = new SineWave[n];
        // SineWave[] waves = new SineWave[n];
        // for (int i = 0; i < n; i++)
        // {
        //     SineWave wave = new SineWave(0);
        //     waves[i] = wave;
        // }
        // this.ordinate_wave = new SineWaves(waves);
        this.ordinate_wave = generateRandomWaves(n);
        this.final_wave = generateRandomWaves(n);
    }

    public NoiseMap()
    {
        this.n = 10;
        this.abscissa_wave = generateRandomWaves(n);
        this.ordinate_wave = generateRandomWaves(n);
        this.final_wave = generateRandomWaves(n);
    }

    public double getValue(double p_x, double p_y)
    {
        double x = this.abscissa_wave.getValue(p_x);
        double y = this.ordinate_wave.getValue(p_y);

        
        return final_wave.getValue(x * y);
    }

        public void generateCSV(String filename, int width, int height, double step) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (double y = 0; y < height; y += step) {
                for (double x = 0; x < width; x += step) {
                    double value = getValue(x, y);
                    writer.write(String.format("%.2f", value));
                    if (x + step < width) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
        NoiseMap noiseMap = new NoiseMap();
        noiseMap.generateCSV("noise_map.csv", 200, 200, 1.0);
    }
}