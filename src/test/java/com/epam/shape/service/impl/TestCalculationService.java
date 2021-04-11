package com.epam.shape.service.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;
import com.epam.shape.service.CalculationService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalculationService {

    CalculationService service;
    Cone cone;

    @BeforeClass
    public void init() {
        service = new CalculationServiceImpl();
        cone = new Cone(new Point(5, 5, 0), 3, 4);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testNullException() throws ConeException {
        service.calculateSurfaceArea(null);
    }

    @Test
    public void testSurfaceArea() throws ConeException {
        double actual = 75.40;
        double expected = service.calculateSurfaceArea(cone);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testVolume() throws ConeException {
        double actual = 37.70;
        double expected = service.calculateVolume(cone);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testVolumeRatio() throws ConeException {
        double actual = 0.14;
        double expected = service.calculateVolumeRatio(cone, 2);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testVolumeRatioException() throws ConeException {
        double expected = service.calculateVolumeRatio(cone, -2);
    }

    @Test
    public void testCoordinatePlane() throws ConeException {
        boolean expected = service.isOnCoordinatePlane(cone);
        Assert.assertTrue(expected);
    }

}
