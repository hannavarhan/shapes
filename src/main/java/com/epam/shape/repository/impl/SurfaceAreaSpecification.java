package com.epam.shape.repository.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.exception.ConeException;
import com.epam.shape.repository.Specification;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SurfaceAreaSpecification implements Specification {

    private final static Logger logger = LogManager.getLogger(SurfaceAreaSpecification.class);

    double minSurfaceArea;
    double maxSurfaceArea;

    public SurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationService service = new CalculationServiceImpl();
        double surfaceArea = 0;
        try {
            surfaceArea = service.calculateSurfaceArea(cone);
        } catch (ConeException e) {
            logger.info("exception cannot be generated here");
        }
        boolean result = surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
        return result;
    }
}
