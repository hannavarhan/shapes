package com.epam.shape.reader;

import com.epam.shape.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class TestConeReader {

    String filepath;
    ConeFileReader reader;
    ClassLoader loader;

    @BeforeClass
    public void init() {
        reader = new ConeFileReader();
        loader = TestConeReader.class.getClassLoader();
    }

    @Test(expectedExceptions = ConeException.class)
    public void testException() throws ConeException {
        reader.readLinesFromFile("wrong_path");
    }

    @Test
    public void testFullyRightFile() throws ConeException {
        URL resource = loader.getResource("file/cone1.txt");
        filepath = new File(resource.getFile()).getAbsolutePath();

        ArrayList<String> actual = new ArrayList<>();
        actual.add("3 5 7 2.5 2.0");
        actual.add("5 4.2 7 8 1");
        ArrayList<String> expected = reader.readLinesFromFile(filepath);
        Assert.assertEquals(  actual, expected);
    }

    @Test
    public void testPartlyWrongFile() throws ConeException {
        URL resource = loader.getResource("file/cone.txt");
        filepath = new File(resource.getFile()).getAbsolutePath();

        ArrayList<String> actual = new ArrayList<>();
        actual.add("2.5 2.66 4 5 5");
        actual.add("5 8 5 5 1.02");
        ArrayList<String> expected = reader.readLinesFromFile(filepath);
        Assert.assertEquals(  actual, expected);
    }
}
