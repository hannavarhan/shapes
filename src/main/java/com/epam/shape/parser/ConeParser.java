package com.epam.shape.parser;

import com.epam.shape.exception.ConeException;
import com.epam.shape.validator.ConeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ConeParser {

    private final static Logger logger = LogManager.getLogger(ConeParser.class);

    private final String SPACE_REGEX = "\\s+";

    public double[] parseConeString(String coneString) {
        String[] lineElements = coneString.split(SPACE_REGEX);
        double[] array = new double[lineElements.length];
        for (int i = 0; i < lineElements.length; i++) {
            array[i] = Double.parseDouble(lineElements[i]);
        }
        logger.info("Method parseConeString returns " + Arrays.toString(array));
        return array;
    }

    public double[] parseConeStringWithValidation(String coneString) throws ConeException {
        if (!ConeStringValidator.isCone(coneString)) {
            logger.error("string {} is inalid", coneString);
            throw new ConeException("string " + coneString + " is invalid");
        }
        double[] array = parseConeString(coneString);
        return array;
    }
}
