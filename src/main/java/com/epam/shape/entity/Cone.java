package com.epam.shape.entity;

import com.epam.shape.exception.ConeException;
import com.epam.shape.observer.ConeEvent;
import com.epam.shape.observer.Observable;
import com.epam.shape.observer.ConeObserver;
import com.epam.shape.validator.ConeDataValidator;

import java.util.ArrayList;
import java.util.Comparator;

public class Cone extends Shape implements Observable {

    private Point center;
    private double radius;
    private double height;
    private ArrayList<ConeObserver> observers = new ArrayList<>();

    public Cone(Point center, double radius, double height) {
        super();
        this.center = center;
        this.radius = radius;
        this.height = height;
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
        if (!ConeDataValidator.isRadiusValid(radius)) {
            throw new ConeException("radius cannot be null");
        }
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ConeException {
        if (!ConeDataValidator.isHeightValid(radius)) {
            throw new ConeException("height cannot be null");
        }
        this.height = height;
        notifyObservers();
    }

    @Override
    public void attach(ConeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ConeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        ConeEvent event = new ConeEvent(this);
        if (!observers.isEmpty()) {
            for (ConeObserver observer : observers) {
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
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        int result = center == null ? 0 : center.hashCode();
        result = 31 * result + (int) radius;
        result = 31 * result + (int) height;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(this.getId());
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }

    public static class HeightComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getHeight(), o2.getHeight());
        }
    }

    public static class RadiusComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
    }

    public static class XPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
        }
    }

    public static class YPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getY(), o2.getCenter().getY());
        }
    }

    public static class ZPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
        }
    }

}
