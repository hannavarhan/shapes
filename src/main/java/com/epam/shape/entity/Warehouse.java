package com.epam.shape.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    Map<Long, ShapeParameters> map;

    public Warehouse() {
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
