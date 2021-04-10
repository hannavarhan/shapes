package com.epam.shape.repository.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.repository.Specification;

public class HeightSpecification implements Specification {

    private double maxHeight;

    public HeightSpecification(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = cone.getHeight() <= maxHeight;
        return false;
    }
}
