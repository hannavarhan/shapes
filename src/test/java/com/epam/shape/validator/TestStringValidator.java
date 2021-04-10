package com.epam.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStringValidator {

    @Test
    public void testValidString() {
        String validString = "5 8 5 5 1.02";
        Assert.assertTrue(ConeStringValidator.isCone(validString));
    }

    @Test
    public void testInvalidString() {
        String validString = "5 8 5 5 1.02a";
        Assert.assertFalse(ConeStringValidator.isCone(validString));
    }
}
