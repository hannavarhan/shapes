package com.epam.shape.service.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;
import com.epam.shape.service.CalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculationServiceImpl implements CalculationService {

    private final static Logger logger = LogManager.getLogger(CalculationServiceImpl.class);

    @Override
    public double calculateSurfaceArea(Cone cone) throws ConeException {
        if (cone == null) {
            logger.error("cone is null in calculateSurfaceArea method");
            throw new ConeException("cone shouldn't be null");
        }
        double generatrixLength = Math.sqrt(cone.getRadius() * cone.getRadius() +
                cone.getHeight() * cone.getHeight());
        double surfaceArea = Math.PI * cone.getRadius() * generatrixLength +
                Math.PI * cone.getRadius() * cone.getRadius();
        String result = String.format("%.2f", surfaceArea).replace(",", ".");
        double surfaceAreaResult = Double.parseDouble(result);
        logger.info("surfaceArea is " + surfaceAreaResult);
        return surfaceAreaResult;
    }

    @Override
    public double calculateVolume(Cone cone) throws ConeException {
        if (cone == null) {
            logger.error("cone is null in calculateVolume method");
            throw new ConeException("cone shouldn't be null");
        }
        double volume = Math.PI * cone.getHeight() * cone.getRadius() * cone.getRadius() / 3.0;
        String result = String.format("%.2f", volume).replace(",", ".");
        double volumeResult = Double.parseDouble(result);
        logger.info("volume is " + volumeResult);
        return volumeResult;
    }

    @Override
    public double calculateVolumeRatio(Cone cone, double z) throws ConeException {
        if (cone == null) {
            logger.error("cone is null in calculateVolumeRatio method");
            throw new ConeException("cone shouldn't be null");
        }
        if ((cone.getCenter().getZ() + cone.getHeight()) < z || cone.getCenter().getZ() > z) {
            logger.error("plane z=" + z + " does not intersect cone " + cone);
            throw new ConeException("plane z=" + z + " does not intersect cone " + cone);
        }
        double secondHeight = cone.getCenter().getZ() + cone.getHeight() - z;
        double secondRadius = secondHeight * cone.getRadius() / cone.getHeight();
        Cone littleCone = new Cone(cone.getCenter(), secondRadius, secondHeight);
        double higherVolume = calculateVolume(littleCone);

        double lowerVolume = calculateVolume(cone) - higherVolume;
        logger.info("lowerVolume: " + lowerVolume);

        double ratio = higherVolume / lowerVolume;
        String result = String.format("%.2f", ratio).replace(",", ".");
        double ratioResult = Double.parseDouble(result);
        logger.info("ratio is " + ratioResult);
        return ratioResult;
    }

    @Override
    public boolean isCustomCone(Point center, double radius, double height) { //???
        boolean isCone = radius > 0 && height > 0;
        return isCone;
    }

    @Override
    public boolean isOnCoordinatePlane(Cone cone) throws ConeException {
        if (cone == null) {
            logger.error("cone is null in calculateVolumeRatio method");
            throw new ConeException("cone shouldn't be null");
        }
        boolean isOnPlane = cone.getCenter().getZ() == 0;
        logger.info(cone + " is on coordinate plane: " + isOnPlane);
        return isOnPlane;
    }
}
