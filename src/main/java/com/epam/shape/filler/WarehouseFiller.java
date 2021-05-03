package com.epam.shape.filler;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;

public class WarehouseFiller {

    public void fillWarehouse(Cone cone) throws ConeException {
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        CalculationService service = new CalculationServiceImpl();
        double surfaceArea = service.calculateSurfaceArea(cone);
        double volume = service.calculateVolume(cone);
        ShapeParameters shapeParameters = new ShapeParameters();
        shapeParameters.setSurfaceArea(surfaceArea);
        shapeParameters.setVolume(volume);
        warehouse.put(id, shapeParameters);
    }
}
