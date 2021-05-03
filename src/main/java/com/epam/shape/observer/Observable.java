package com.epam.shape.observer;

public interface Observable {

    void attach(ConeObserver observer);

    void detach(ConeObserver observer);

    void notifyObservers();
}
