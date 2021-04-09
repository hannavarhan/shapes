package com.epam.shape.service;

import com.epam.shape.entity.Cone;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.ConeException;

public interface CalculationService {

    double calculateSurfaceArea(Cone cone) throws ConeException;

    double calculateVolume(Cone cone) throws ConeException;

    double calculateVolumeRatio(Cone cone, double z) throws ConeException;

    boolean isCustomCone(Point center, double radius, double height); //является ли объект конусом так делать??

    boolean isOnCoordinatePlane(Cone cone) throws ConeException;

}
