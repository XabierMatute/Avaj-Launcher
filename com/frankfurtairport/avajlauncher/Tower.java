package com.frankfurtairport.avajlauncher;

import java.util.ArrayList;
import java.io.FileWriter;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    private FileWriter writer = null;

    public void setWriter(FileWriter p_writer) {
        writer = p_writer;
    }

    public void register(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            throw new IllegalArgumentException("The flyable is already registered.");
        }
        observers.add(p_flyable);
        try {
            writer.write("Tower says: " + p_flyable + " registered to weather tower.\n");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage() + e);
        }
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        try {
            writer.write("Tower says: " + p_flyable + " unregistered from weather tower.\n");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage() + e);
        }
    }

    protected void conditionChanged() {
        Flyable[] copy = observers.toArray(new Flyable[0]);
        for (Flyable flyable : copy) {
            flyable.updateConditions();
        }
    }

    public void reciveMessage(Flyable p_flyable, String p_message) {
        if (!observers.contains(p_flyable)) {
            throw new IllegalArgumentException("The flyable is not registered.");
        }
        try {
            writer.write(p_flyable + ": " + p_message + "\n");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage() + e);
        }
    }
}