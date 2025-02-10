package com.frankfurtairport.avajlauncher;

import java.util.Objects;

public class Coordinates {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_HEIGHT = 100;
    private static final int MIN_HEIGHT = 0;
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.checkLongitude();
        this.latitude = p_latitude;
        this.checkLatitude();
        this.height = p_height;
        this.hardCheckHeight();
    }

    private void checkLongitude() {
        if (this.longitude < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Longitude cannot be negative: " + this.longitude);
        }
    }

    public int getLongitude() {
        return this.longitude;
    }

    public Coordinates incrementLongitude(int increment) {
        this.longitude += increment;
        this.checkLongitude();
        return this;
    }

    public Coordinates decrementLongitude(int decrement) {
        return this.incrementLongitude(-decrement);
    }

    private void checkLatitude() {
        if (this.latitude < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Latitude cannot be negative: " + this.latitude);
        }
    }

    public int getLatitude() {
        return this.latitude;
    }

    public Coordinates incrementLatitude(int increment) {
        this.latitude += increment;
        this.checkLatitude();
        return this;
    }

    public Coordinates decrementLatitude(int decrement) {
        return this.incrementLatitude(-decrement);
    }

    private void checkHeight() {
        if (this.height < MIN_COORDINATE) {
            this.height = MIN_HEIGHT;
        }
        if (this.height > MAX_HEIGHT) {
            this.height = MAX_HEIGHT;
        }
    }

    private void hardCheckHeight() {
        if (this.height < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Height cannot be negative: " + this.height);
        }
        if (this.height > MAX_HEIGHT) {
            throw new InvalidCoordinateException("Height cannot be greater than " + MAX_HEIGHT + ": " + this.height);
        }
    }

    public int getHeight() {
        return this.height;
    }

    public Coordinates incrementHeight(int increment) {
        this.height += increment;
        this.checkHeight();
        return this;
    }

    public Coordinates decrementHeight(int decrement) {
        return this.incrementHeight(-decrement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) obj;
        return longitude == that.longitude && latitude == that.latitude && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, height);
    }

    @Override
    public String toString() {
        return "(" + this.longitude + ", " + this.latitude + ", " + this.height + ")";
    }

    public static class InvalidCoordinateException extends RuntimeException {
        public InvalidCoordinateException(String message) {
            super(message);
        }
    }
}