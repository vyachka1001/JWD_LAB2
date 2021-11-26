package by.bsuir.webtech.second.task.dao;

import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.ApplianceType;

import java.util.*;

/**
 * An appliance {@link Dao} implementation.
 */
public class ApplianceDao implements Dao<Appliance, ApplianceType> {

    private static final ApplianceDao APPLIANCE_DAO = new ApplianceDao();

    /**
     * Datasource for appliance DAO.
     */
    private final EnumMap<ApplianceType, List<Appliance>> appliances = new EnumMap<>(ApplianceType.class);

    private ApplianceDao() {
    }

    /**
     * Get singleton instance of appliance DAO.
     *
     * @return singleton instance of appliance DAO.
     */
    public static ApplianceDao getInstance() {
        return APPLIANCE_DAO;
    }

    /**
     * Get minimum appliance based on comparator.
     *
     * @param comparator comparator for the objects
     * @return optional appliance
     */
    @Override
    public Optional<Appliance> getMinimumElement(Comparator<Appliance> comparator) {
        return appliances.values().stream().flatMap(List::stream).min(comparator);
    }

    /**
     * Get list of appliances of given type.
     *
     * @param applianceType appliance type
     * @return list of appliances with given type
     */
    @Override
    public List<Appliance> getAllByType(ApplianceType applianceType) {
        return appliances.get(applianceType);
    }

    /**
     * Save all appliances represented as a map.
     *
     * @param applianceMap map of appliances
     */
    @Override
    public void saveAll(Map<ApplianceType, List<Appliance>> applianceMap) {
        applianceMap.forEach((key, value) -> {
            this.appliances.computeIfAbsent(key, k -> new ArrayList<>());
            this.appliances.get(key).addAll(value);
        });
    }
}
