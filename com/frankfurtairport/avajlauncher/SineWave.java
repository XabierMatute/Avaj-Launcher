package com.frankfurtairport.avajlauncher;

class SineWave {
    private double amplitude;
    private double frequency;
    private double rotation;
    private double phase;
    private int height;

    public SineWave(double p_amplitude, double p_frequency, double p_rotation, double p_phase, int p_height) {
        this.amplitude = p_amplitude;
        this.frequency = p_frequency;
        this.rotation = p_rotation;
        this.phase = p_phase;
        this.height = p_height;
    }

    public SineWave() {
        this(1, 1, 0, 0, 0);
    }

    public int getValue(Coordinates p_coordinate) {
        int x = p_coordinate.getLongitude();
        int y = p_coordinate.getLatitude();
        int z = (int)(amplitude * Math.sin(frequency * (Math.sin(rotation) * x + Math.cos(rotation) * y) + phase) + height);
        return z;
    }
}