package com.frankfurtairport.avajlauncher;

import java.util.ArrayList;
import java.util.Iterator;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            throw new IllegalArgumentException("The flyable is already registered.");
        }
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        Iterator<Flyable> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Flyable flyable = iterator.next();
            flyable.updateConditions();
        }
    }
}