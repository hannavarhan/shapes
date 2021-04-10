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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConeFileReader {

    private final static Logger logger = LogManager.getLogger(CalculationServiceImpl.class);

    public ArrayList<String> readLinesFromFile(String path) throws ConeException {
        ArrayList<String> result;
        try {
            result = Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                    .filter(ConeStringValidator::isCone)
                    .collect(Collectors.toCollection(ArrayList::new));
            /*String line = reader.readLine();
            while (line != null) {
                if (ConeStringValidator.isCone(line)) {
                    result.add(line);
                    logger.info("string " + line + " is read");
                } else {
                    logger.error("line " + line + " is invalid");
                }
                line = reader.readLine();
            }*/
        } catch (IOException e) {
            logger.error("IOException in read from file method");
            throw new ConeException("IOException in read from file method");
        }
        return result;
    }
}
