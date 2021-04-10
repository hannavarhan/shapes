package com.epam.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class StringParser {

    private final static Logger logger = LogManager.getLogger(StringParser.class);

    final String SPACE_REGEX = "\\s+";

    public double[] parseConeString(String coneString) {
        String[] lineElements = coneString.split(SPACE_REGEX);
        double[] array = new double[lineElements.length];
        for (int i = 0; i < lineElements.length; i++) {
            array[i] = Double.parseDouble(lineElements[i]);
        }
        logger.info("Method parseConeString returns " + Arrays.toString(array));
        return array;
    }
}
