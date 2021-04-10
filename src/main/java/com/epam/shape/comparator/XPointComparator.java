package com.epam.shape.comparator;

import com.epam.shape.entity.Cone;

import java.util.Comparator;

public class XPointComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
    }
}
