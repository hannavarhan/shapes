package com.epam.shape.util;

public class IdGenerator {

    private static long counter;

    private IdGenerator() {
    }

    public static long generateShapeId() {
        return counter++;
    }
}
