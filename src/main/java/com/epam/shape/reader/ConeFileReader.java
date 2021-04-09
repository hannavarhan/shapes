package com.epam.shape.reader;

import com.epam.shape.exception.ConeException;
import com.epam.shape.service.impl.CalculationServiceImpl;
import com.epam.shape.validator.ConeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConeFileReader {

    private final static Logger logger = LogManager.getLogger(CalculationServiceImpl.class);

    public ArrayList<String> readLinesFromFile(String path) throws ConeException { //use java 8
        ArrayList<String> result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                if (ConeStringValidator.isCone(line)) {
                    result.add(line);
                    logger.info("string " + line + " is read");
                } else {
                    logger.error("line " + line + " is invalid");
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.error("file " + path + " not found in read from file method");
            throw new ConeException("file not found in read from file method");
        } catch (IOException e) {
            logger.error("IOException in read from file method");
            throw new ConeException("IOException in read from file method");
        }
        return result;
    }
}
