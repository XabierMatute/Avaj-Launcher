package com.frankfurtairport.avajlauncher;

/**
 * Represents a sine wave with amplitude, frequency, and phase.
 */
class SineWave {
    private double amplitude;
    private double frequency;
    private double phase;

    /**
     * Constructs a SineWave with specified amplitude, frequency, and phase.
     *
     * @param p_amplitude the amplitude of the sine wave
     * @param p_frequency the frequency of the sine wave
     * @param p_phase the phase of the sine wave
     */
    public SineWave(double p_amplitude, double p_frequency, double p_phase) {
        this.amplitude = p_amplitude;
        this.frequency = p_frequency;
        this.phase = p_phase;
        System.out.println("New wave created with formula: " + this.amplitude + " * sin(" + this.frequency + " * x + " + this.phase + ")");
    }

    /**
     * Constructs a SineWave with specified amplitude and default frequency and phase.
     * Default frequency is 1.0 and default phase is 0.0.
     *
     * @param p_amplitude the amplitude of the sine wave
     */
    public SineWave(double p_amplitude) {
        this(p_amplitude, 1.0, 0.0); // Default values: frequency = 1.0, phase = 0.0
    }

    /**
     * Constructs a SineWave with default amplitude, frequency, and phase.
     * Default amplitude is 1.0, default frequency is 1.0, and default phase is 0.0.
     */
    public SineWave() {
        this(1.0, 1.0, 0.0); // Default values: amplitude = 1.0, frequency = 1.0, phase = 0.0
    }

    /**
     * Calculates the value of the sine wave at a given point.
     *
     * @param x the input value
     * @return the value of the sine wave at the given point
     */
    public double getValue(double x) {
        double result = this.amplitude * Math.sin(this.frequency * x * 2 * Math.PI + this.phase);
        if (Double.isNaN(result)) {// throw exception if result is NaN
                    System.out.println("wave: " + this.amplitude + " * sin(" + this.frequency + " * x + " + this.phase + ")");

            throw new IllegalArgumentException("Invalid input: x = " + x);
        }
        return this.amplitude * Math.sin(this.frequency * x * 2 * Math.PI + this.phase);
    }
}

class SineWaves
{
    private SineWave[] sineWaves;

    public SineWaves(SineWave[] p_sineWaves)
    {
        this.sineWaves = p_sineWaves;
    }

    public double getValue(double x)
    {
        double result = 0;
        for (int i = 0; i < this.sineWaves.length; i++)
        {
            result += this.sineWaves[i].getValue(x);
        }
        return result;
    }
}