package com.epam.shape.factory;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;
import com.epam.shape.validator.ConeDataValidator;

public class ConeFactory {

    public static Cone getConeFromFactory(Point point, double radius, double height) throws ConeException {
        if (ConeDataValidator.isRadiusValid(radius)
                && ConeDataValidator.isHeightValid(height)) {
            return new Cone(point, radius, height);
        } else {
            throw new ConeException("data is invalid");
        }
    }

    public static Cone getConeFromFactory(double x, double y, double z, double radius, double height) //can we do like that??
            throws ConeException {
        if (ConeDataValidator.isRadiusValid(radius)
                && ConeDataValidator.isHeightValid(height)) {
            Point point = new Point(x, y, z);
            return new Cone(point, radius, height);
        } else {
            throw new ConeException("data is invalid");
        }
    }
}
