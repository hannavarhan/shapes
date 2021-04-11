package com.epam.shape.entity;

import com.epam.shape.parser.StringParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private final static Logger logger = LogManager.getLogger(Warehouse.class);

    Map<Long, ShapeParameters> map;
    private static Warehouse instance;

    public static Warehouse getInstance() {
        if (instance == null) {
            logger.info("creating singleton warehouse");
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse() {
        this.map = new HashMap<>();
    }

    public ShapeParameters get(Long id) {
        return map.get(id);
    }

    public Map<Long, ShapeParameters> getMap() {
        return map;
    }

    public ShapeParameters put(Long id, ShapeParameters value) {
        return map.put(id, value);
    }

    public ShapeParameters remove(Long id) {
        return map.remove(id);
    }
}
