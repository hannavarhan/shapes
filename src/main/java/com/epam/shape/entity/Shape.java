package com.epam.shape.entity;

import com.epam.shape.util.IdGenerator;

public abstract class Shape {

    private long shapeId;

    public Shape() {
        this.shapeId = IdGenerator.generateShapeId();
    }

    public long getId() {
        return shapeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shapeId == shape.shapeId;
    }

    @Override
    public int hashCode() {
        return (int) shapeId;
    }
}
