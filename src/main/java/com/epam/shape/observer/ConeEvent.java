package com.epam.shape.observer;

import com.epam.shape.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ConeEvent(Cone source) { //do we need to check for null and throw custom exception???
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }
}
