package com.epam.shape.creator;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.repository.Repository;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;

public class ConeWarehouseCreator {

    public Warehouse createConeWarehouse(Repository repository) throws ConeException {
        Warehouse warehouse = new Warehouse();
        CalculationService service = new CalculationServiceImpl();
        for(Cone cone : repository.getCones()) {
            double surfaceArea = service.calculateSurfaceArea(cone);
            double volume = service.calculateVolume(cone);
            ShapeParameters shapeParameters = new ShapeParameters();
            shapeParameters.setSurfaceArea(surfaceArea);
            shapeParameters.setVolume(volume);
            long id = cone.getConeId();
            warehouse.put(id, shapeParameters);
        }
        return warehouse;
    }
}
