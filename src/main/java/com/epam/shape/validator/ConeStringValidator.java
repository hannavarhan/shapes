package com.epam.shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConeStringValidator {

    private final static Logger logger = LogManager.getLogger(ConeStringValidator.class);

    final static String IS_VALID_CONE_STRING =
            "^(-?\\d+(\\.)?(\\d{1,2})?\\s){3}(([1-9]\\d*(\\.)?(\\d{1,2})?)|([0]\\.\\d{1,2}))\\s(([1-9]\\d*(\\.)?(\\d{1,2})?)|([0]\\.\\d{1,2}))$";

    public static boolean isCone(String line) {
        Pattern pattern = Pattern.compile(IS_VALID_CONE_STRING);
        Matcher matcher = pattern.matcher(line.trim());
        boolean isMatches = matcher.matches();
        logger.info("method isCone for line " + line + " returns " + isMatches);
        return isMatches;
    }
}
