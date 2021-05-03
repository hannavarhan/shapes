package com.epam.shape.observer.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.observer.ConeEvent;
import com.epam.shape.observer.ConeObserver;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserverImpl implements ConeObserver {

    private final static Logger logger = LogManager.getLogger(ConeObserverImpl.class);

    @Override
    public void updateSurfaceArea(ConeEvent coneEvent) {
        Cone cone = coneEvent.getSource();
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            ShapeParameters parameters = warehouse.get(id);
            CalculationService service = new CalculationServiceImpl();
            double surfaceArea = service.calculateSurfaceArea(cone);
            parameters.setSurfaceArea(surfaceArea);
            logger.info("Surface area {} was changed", surfaceArea);
        } catch (ConeException e) {
            logger.error("exception {} in updateSurfaceArea method", e.getMessage());
        }
    }

    @Override
    public void updateVolume(ConeEvent coneEvent) {
        Cone cone = coneEvent.getSource();
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            ShapeParameters parameters = warehouse.get(id);
            CalculationService service = new CalculationServiceImpl();
            double volume = service.calculateVolume(cone);
            parameters.setVolume(volume);
            logger.info("Volume area {} was chanched", volume);
        } catch (ConeException e) {
            logger.error("exception {} in updateVolume method", e.getMessage());
        }
    }

}
