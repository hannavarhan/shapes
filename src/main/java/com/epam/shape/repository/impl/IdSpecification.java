package com.epam.shape.repository.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.repository.Specification;

public class IdSpecification implements Specification {

    private long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = cone.getId() == id;
        return result;
    }
}
