package com.epam.shape.repository;

import com.epam.shape.entity.Cone;

public interface Specification {

    boolean specify(Cone cone);
}
