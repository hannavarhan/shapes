package com.epam.shape.parser;

import com.epam.shape.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParser {

    ConeParser parser = new ConeParser();

    @Test
    public void testParser() {
        double[] actual = new double[]{3, 5, 7, 2.5, 2.0};
        double[] expected = parser.parseConeString("3 5 7 2.5 2.0");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParserWithZero() {
        double[] actual = new double[]{0, 0, 0, 2.5, 2.0};
        double[] expected = parser.parseConeString("0 0.0 0.00 2.50 2.0");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testValidationParser() throws ConeException {
        parser.parseConeStringWithValidation("s");
    }
}
