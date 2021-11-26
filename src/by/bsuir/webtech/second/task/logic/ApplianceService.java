package by.bsuir.webtech.second.task.logic;

import by.bsuir.webtech.second.task.entity.Appliance;

import java.util.List;
import java.util.Optional;

/**
 * A service interface for appliance manipulation.
 */
public interface ApplianceService {
    /**
     * Get cheapest appliance.
     *
     * @return optional cheapest appliance
     */
    Optional<Appliance> getCheapestAppliance();

    /**
     * Get all teapots.
     *
     * @return list of teapots.
     */
    List<Appliance> getAllTeapots();
}
