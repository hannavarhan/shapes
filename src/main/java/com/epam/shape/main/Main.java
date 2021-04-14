package com.epam.shape.main;

import com.epam.shape.creator.ConeCreator;
import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.ShapeParameters;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ConeException;
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
        ConeCreator coneCreator = new ConeCreator();
        for(String line : readLines) {
            double[] array = parser.parseConeString(line);
            coneCreator.fillRepositoryWithCone(array);
        }
        coneCreator.fillRepositoryWithCone(new Point(-5, 8, 2), 1, 2.25);
        coneCreator.fillRepositoryWithCone(1.2, 2, 8, 1.8, 3.33);


        Repository repository = Repository.getInstance();
        for(Cone cone : repository.getCones()) {
            logger.info(cone);
            Warehouse warehouse = Warehouse.getInstance();
            ShapeParameters shapeParameters = warehouse.get(cone.getId());
            logger.info(shapeParameters);
        }

        Specification specification = new IdSpecification(1L);
        logger.info(repository.queryStream(specification));

        Specification specificationR = new RadiusSpecification(1, 4);
        logger.info(repository.queryStream(specificationR));

    }
}
