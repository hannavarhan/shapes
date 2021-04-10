package com.epam.shape.parser;

import com.epam.shape.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParser {

    StringParser parser = new StringParser();

    @Test
    public void testParser() throws ConeException {
        double[] actual = new double[]{3, 5, 7, 2.5, 2.0};
        double[] expected = parser.parseConeString("3 5 7 2.5 2.0");
        Assert.assertEquals(actual, expected);
    }
}
