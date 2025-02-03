package com.frankfurtairport.avajlauncher;

import java.util.Objects;

// Value object to store the coordinates of the aircraft
/**
 * Represents the geographical coordinates of an aircraft.
 */
class Coordinates {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_HEIGHT = 100;
    private int longitude;
    private int latitude;
    private int height;

    /**
     * Constructs a Coordinates object with the specified longitude, latitude, and height.
     *
     * @param p_longitude the longitude of the coordinates.
     * @param p_latitude the latitude of the coordinates.
     * @param p_height the height of the coordinates.
     */
    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.checkLongitude();
        this.latitude = p_latitude;
        this.checkLatitude();
        this.height = p_height;
        this.checkHeight();
    }

    /**
     * Checks if the longitude is within the valid range.
     *
     * @throws InvalidCoordinateException if the longitude is less than the minimum coordinate.
     */
    private void checkLongitude() {
        if (this.longitude < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Longitude cannot be negative: " + this.longitude);
        }
    }

    /**
     * Gets the current longitude.
     *
     * @return the current longitude.
     */
    public int getLongitude() {
        return this.longitude;
    }

    /**
     * Increments the longitude by a specified amount.
     *
     * @param increment the amount to increment the longitude by.
     * @return the updated Coordinates object.
     */
    public Coordinates incrementLongitude(int increment) {
        this.longitude += increment;
        this.checkLongitude();
        return this;
    }

    /**
     * Decrements the longitude by a specified amount.
     *
     * @param decrement the amount to decrement the longitude by.
     * @return the updated Coordinates object.
     */
    public Coordinates decrementLongitude(int decrement) {
        return this.incrementLongitude(-decrement);
    }

    /**
     * Checks if the latitude is within the valid range.
     *
     * @throws InvalidCoordinateException if the latitude is less than the minimum coordinate.
     */
    private void checkLatitude() {
        if (this.latitude < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Latitude cannot be negative: " + this.latitude);
        }
    }

    /**
     * Gets the current latitude.
     *
     * @return the current latitude.
     */
    public int getLatitude() {
        return this.latitude;
    }

    /**
     * Increments the latitude by a specified amount.
     *
     * @param increment the amount to increment the latitude by.
     * @return the updated Coordinates object.
     */
    public Coordinates incrementLatitude(int increment) {
        this.latitude += increment;
        this.checkLatitude();
        return this;
    }

    /**
     * Decrements the latitude by a specified amount.
     *
     * @param decrement the amount to decrement the latitude by.
     * @return the updated Coordinates object.
     */
    public Coordinates decrementLatitude(int decrement) {
        return this.incrementLatitude(-decrement);
    }

    /**
     * Checks if the height is within the valid range.
     *
     * @throws InvalidCoordinateException if the height is less than the minimum coordinate.
     */
    private void checkHeight() {
        if (this.height < MIN_COORDINATE) {
            throw new InvalidCoordinateException("Height cannot be negative: " + this.height);
        }
        if (this.height > MAX_HEIGHT) {
            this.height = MAX_HEIGHT;
        }
    }

    /**
     * Gets the current height.
     *
     * @return the current height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Increments the height by a specified amount.
     *
     * @param increment the amount to increment the height by.
     * @return the updated Coordinates object.
     */
    public Coordinates incrementHeight(int increment) {
        this.height += increment;
        this.checkHeight();
        return this;
    }

    /**
     * Decrements the height by a specified amount.
     *
     * @param decrement the amount to decrement the height by.
     * @return the updated Coordinates object.
     */
    public Coordinates decrementHeight(int decrement) {
        return this.incrementHeight(-decrement);
    }

    /**
     * Checks if this Coordinates object is equal to another object.
     *
     * @param obj the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
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

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, height);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "(" + this.longitude + ", " + this.latitude + ", " + this.height + ")";
    }

    /**
     * Exception thrown when a coordinate value is invalid.
     */
    public static class InvalidCoordinateException extends RuntimeException {
        /**
         * Constructs an InvalidCoordinateException with the specified detail message.
         *
         * @param message the detail message.
         */
        public InvalidCoordinateException(String message) {
            super(message);
        }
    }
}