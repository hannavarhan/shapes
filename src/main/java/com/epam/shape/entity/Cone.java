package com.epam.shape.entity;

import com.epam.shape.exception.ConeException;
import com.epam.shape.observer.ConeEvent;
import com.epam.shape.observer.Observable;
import com.epam.shape.observer.Observer;

import java.util.ArrayList;
import java.util.Objects;

public class Cone implements Observable {

    private Point center;
    private double radius;
    private double height;
    private static int counter;
    private long coneId;
    private ArrayList<Observer> observers = new ArrayList<>();

    static {
        counter = 0;
    }

    public Cone(Point center, double radius, double height) {
        this.center = center;
        this.radius = radius;
        this.height = height;
        this.coneId = counter++;
    }

    public Cone() {
        this.coneId = counter++;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        if (radius <= 0) {
            throw new ConeException("radius cannot be null");
        }
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObservers();
    }

    public long getConeId() {
        return coneId;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        ConeEvent event = new ConeEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.updateSurfaceArea(event);
                observer.updateVolume(event);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone that = (Cone) o;
        return Double.compare(that.radius, radius) == 0 &&
                Double.compare(that.height, height) == 0 &&
                coneId == that.coneId && //do we need to compare by id here??
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, height, coneId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", coneId=").append(coneId);
        sb.append('}');
        return sb.toString();
    }
}
