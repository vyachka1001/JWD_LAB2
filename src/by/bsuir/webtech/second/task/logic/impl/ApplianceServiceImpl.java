package by.bsuir.webtech.second.task.logic.impl;

import by.bsuir.webtech.second.task.dao.Dao;
import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.ApplianceType;
import by.bsuir.webtech.second.task.entity.comparator.AppliancePriceComparator;
import by.bsuir.webtech.second.task.logic.ApplianceService;

import java.util.List;
import java.util.Optional;

/**
 * An {@link ApplianceService} implementation.
 */
public class ApplianceServiceImpl implements ApplianceService {
    private final Dao<Appliance, ApplianceType> applianceDao;

    /**
     * Default constructor for appliance service.
     *
     * @param applianceDao appliance DAO to access data layer.
     */
    public ApplianceServiceImpl(Dao<Appliance, ApplianceType> applianceDao) {
        this.applianceDao = applianceDao;
    }

    /**
     * @see ApplianceService#getCheapestAppliance()
     */
    @Override
    public Optional<Appliance> getCheapestAppliance() {
        return applianceDao.getMinimumElement(new AppliancePriceComparator());
    }

    /**
     * @see ApplianceService#getAllTeapots()
     */
    @Override
    public List<Appliance> getAllTeapots() {
        return applianceDao.getAllByType(ApplianceType.TEAPOT);
    }
}
