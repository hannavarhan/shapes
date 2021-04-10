package com.epam.shape.repository.impl;

import com.epam.shape.entity.Cone;
import com.epam.shape.exception.ConeException;
import com.epam.shape.repository.Specification;
import com.epam.shape.service.CalculationService;
import com.epam.shape.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolumeSpecification implements Specification {

    private double minVolume;
    private double maxVolume;

    private final static Logger logger = LogManager.getLogger(VolumeSpecification.class);

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationService service = new CalculationServiceImpl();
        double volume = 0;
        try {
            volume = service.calculateVolume(cone);
        } catch (ConeException e) {
            logger.info("exception cannot be generated here, check it!!!");
            //exception cannot be generated here, should I catch it here??
        }
        boolean result = volume >= minVolume && volume <= maxVolume;
        return result;
    }
}
