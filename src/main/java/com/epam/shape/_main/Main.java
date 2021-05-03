package com.epam.shape._main;

import com.epam.shape.factory.ConeFactory;
import com.epam.shape.filler.RepositoryFiller;
import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
import com.epam.shape.filler.WarehouseFiller;
import com.epam.shape.observer.impl.ConeObserverImpl;
import com.epam.shape.parser.ConeParser;
import com.epam.shape.reader.ConeFileReader;
import com.epam.shape.repository.Repository;
import com.epam.shape.repository.Specification;
import com.epam.shape.repository.impl.IdSpecification;
import com.epam.shape.repository.impl.RadiusSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ConeException {

        ClassLoader loader = Main.class.getClassLoader();
        URL resource = loader.getResource("file/cone2.txt");
        String filepath = new File(resource.getFile()).getAbsolutePath();

        ConeFileReader reader = new ConeFileReader();
        ArrayList<String> readLines = reader.readLinesFromFile(filepath);
        ConeParser parser = new ConeParser();
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        for (String line : readLines) {
            double[] array = parser.parseConeString(line);
            Cone cone = ConeFactory.getConeFromFactory(array);
            repositoryFiller.fillRepositoryWithCone(cone);
        }

        Repository repository = Repository.getInstance();
        for (Cone cone : repository.getCones()) {
            logger.info(cone);
            warehouseFiller.fillWarehouse(cone);
            Warehouse warehouse = Warehouse.getInstance();
            ShapeParameters shapeParameters = warehouse.get(cone.getId());
            logger.info(shapeParameters);
        }

        Specification specification = new IdSpecification(1L);
        logger.info(repository.queryStream(specification));

        Specification specificationR = new RadiusSpecification(1, 4);
        logger.info(repository.queryStream(specificationR));

        Cone cone = ConeFactory.getConeFromFactory(0, 0, 0, 1, 2);
        warehouseFiller.fillWarehouse(cone);
        repositoryFiller.fillRepositoryWithCone(cone);
        cone.attach(new ConeObserverImpl());
        cone.setHeight(5);
    }
}
