package com.frankfurtairport.avajlauncher;

/**
 * Represents a sine wave with amplitude, frequency, and phase.
 */
class SineWave {
    private double amplitude;
    private double frequency;
    private double rotation;
    private double phase;
    private int height;

    /**
     * Constructs a SineWave with specified amplitude, frequency, rotation, phase, and height.
     *
     * @param p_amplitude the amplitude of the sine wave
     * @param p_frequency the frequency of the sine wave
     * @param p_rotation the rotation of the sine wave
     * @param p_phase the phase of the sine wave
     * @param p_height the height of the sine wave
     */
    public SineWave(double p_amplitude, double p_frequency, double p_rotation, double p_phase, int p_height) {
        this.amplitude = p_amplitude;
        this.frequency = p_frequency;
        this.rotation = p_rotation;
        this.phase = p_phase;
        this.height = p_height;
    }

    /**
     * Constructs a SineWave with default values.
     */
    public SineWave() {
        this(1, 1, 0, 0, 0);
    }
    /**
     * Calculates the value of the sine wave at a given point.
     *
     * @param Coordinate the coordinate to calculate the value at. (height is ignored, it is the result)
     * @return the value of the sine wave height at the given coordinate.
     */
    public int getValue(Coordinates p_coordinate) {
        int x = p_coordinate.getLongitude();
        int y = p_coordinate.getLatitude();
        int z = (int)(amplitude * Math.sin(frequency * (Math.sin(rotation) * x + Math.cos(rotation) * y) + phase) + height);
        return z;
    }
}