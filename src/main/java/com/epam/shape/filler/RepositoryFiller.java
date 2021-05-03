package com.epam.shape.filler;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;
import com.epam.shape.factory.ConeFactory;
import com.epam.shape.repository.Repository;

public class RepositoryFiller {

    public void fillRepositoryWithCone(Point point, double radius, double height) throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(point, radius, height);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    public void fillRepositoryWithCone(double x, double y, double z, double radius, double height)
            throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(x, y, z, radius, height);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    public void fillRepositoryWithCone(double[] array)
            throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(array);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    public void fillRepositoryWithCone(Cone cone) {
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

}
