package com.epam.shape.entity;

import com.epam.shape.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private final static Logger logger = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;
    private Map<Long, ShapeParameters> map;

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

    public ShapeParameters get(Long id) throws ConeException {
        if (!map.containsKey(id)) {
            logger.error("Warehouse does not contains cone with id {}", id);
            throw new ConeException("Warehouse does not contains cone with id " + id);
        }
        return map.get(id);
    }

    public ShapeParameters put(Long id, ShapeParameters value) {
        return map.put(id, value);
    }

    public ShapeParameters remove(Long id) {
        return map.remove(id);
    }
}
