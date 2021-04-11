package com.epam.shape.observer;

public interface Observer {

    void updateSurfaceArea(ConeEvent coneEvent);

    void updateVolume(ConeEvent coneEvent);
}
