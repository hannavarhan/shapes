package com.epam.shape.entity;

import com.epam.shape.exception.ConeException;

import java.util.Objects;

public class Cone {

    private Point center;
    private double radius;
    private double height;
    private int coneId;

    public Cone(Point center, double radius, double height) {
        this.center = center;
        this.radius = radius;
        this.height = height;
    }

    public Cone() {
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        if (radius <= 0) {
            throw new ConeException("radius cannot be null");
        }
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getConeId() {
        return coneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone that = (Cone) o;
        return Double.compare(that.radius, radius) == 0 &&
                Double.compare(that.height, height) == 0 &&
                coneId == that.coneId &&
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, height, coneId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomCone{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", coneId=").append(coneId);
        sb.append('}');
        return sb.toString();
    }
}
