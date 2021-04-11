package com.epam.shape.observer.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.observer.ConeEvent;
import com.epam.shape.observer.Observer;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserver implements Observer {

    private final static Logger logger = LogManager.getLogger(ConeObserver.class);

    @Override
    public void updateSurfaceArea(ConeEvent coneEvent) {
        Cone cone = (Cone) coneEvent.getSource();
        long id = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        ShapeParameters parameters = warehouse.get(id);
        CalculationService service = new CalculationServiceImpl();
        try {
            double surfaceArea = service.calculateSurfaceArea(cone);
            parameters.setSurfaceArea(surfaceArea);
        } catch (ConeException e) {
            logger.error("exception in updateSurfaceArea method");
        }
    }

    @Override
    public void updateVolume(ConeEvent coneEvent) {
        Cone cone = (Cone) coneEvent.getSource();
        long id = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        ShapeParameters parameters = warehouse.get(id);
        CalculationService service = new CalculationServiceImpl();
        try {
            double volume = service.calculateVolume(cone);
            parameters.setVolume(volume);
        } catch (ConeException e) {
            logger.error("exception in updateVolume method");
        }
    }

}
