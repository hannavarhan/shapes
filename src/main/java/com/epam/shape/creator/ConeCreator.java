package com.epam.shape.creator;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.factory.ConeFactory;
import com.epam.shape.repository.Repository;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;

public class ConeCreator {

    public boolean fillRepositoryWithCone(Point point, double radius, double height) throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(point, radius, height);
        createWarehouse(cone);
        Repository repository = Repository.getInstance();
        return repository.add(cone);
    }

    public boolean fillRepositoryWithCone(double x, double y, double z, double radius, double height)
            throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(x, y, z, radius, height);
        createWarehouse(cone);
        Repository repository = Repository.getInstance();
        return repository.add(cone);
    }

    private void createWarehouse(Cone cone) throws ConeException {
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
