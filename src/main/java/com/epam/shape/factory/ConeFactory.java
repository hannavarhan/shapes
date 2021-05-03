package com.epam.shape.factory;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;
import com.epam.shape.validator.ConeDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeFactory {

    private final static Logger logger = LogManager.getLogger(ConeFactory.class);

    public static Cone getConeFromFactory(Point point, double radius, double height) throws ConeException {
        if (!ConeDataValidator.isRadiusValid(radius)
                || !ConeDataValidator.isHeightValid(height)) {
            logger.error("radius {} or height {} is invalid", radius, height);
            throw new ConeException("Radius or height is invalid: " + radius + " or " + height);
        }
        Cone cone = new Cone(point, radius, height);
        logger.info("new cone {} was created", cone);
        return cone;
    }

    public static Cone getConeFromFactory(double x, double y, double z, double radius, double height)
            throws ConeException {
        Point point = new Point(x, y, z);
        Cone cone = getConeFromFactory(point, radius, height);
        return cone;
    }

    public static Cone getConeFromFactory(double[] array) throws ConeException {
        if (array.length != 5) {
            logger.error("wrong array size {} in factory", array.length);
            throw new ConeException("Wrong array size " + array.length);
        }
        double radius = array[3];
        double height = array[4];
        Point point = new Point(array[0], array[1], array[2]);
        Cone cone = getConeFromFactory(point, radius, height);
        return cone;
    }
}
