package com.epam.shape.observer;

public interface ConeObserver {

    void updateSurfaceArea(ConeEvent coneEvent);

    void updateVolume(ConeEvent coneEvent);
}
