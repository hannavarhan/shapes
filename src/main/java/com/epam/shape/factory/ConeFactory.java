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
        validateData(radius, height);
        Cone cone = new Cone(point, radius, height);
        logger.info("new cone {} was created", cone);
        return cone;
    }

    public static Cone getConeFromFactory(double x, double y, double z, double radius, double height)
            throws ConeException {
        validateData(radius, height);
        Point point = new Point(x, y, z);
        Cone cone = new Cone(point, radius, height);
        logger.info("new cone {} was created", cone);
        return cone;
    }

    private static void validateData(double radius, double height) throws ConeException {
        if (!ConeDataValidator.isRadiusValid(radius)
                || !ConeDataValidator.isHeightValid(height)) {
            logger.error("data {} or {} is invalid", radius, height);
            throw new ConeException("data is invalid: " + radius + " or " + height);
        }
    }
}
