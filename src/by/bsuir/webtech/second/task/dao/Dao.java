package by.bsuir.webtech.second.task.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Basic DAO interface supporting object classes.
 *
 * @param <T> the object type
 * @param <K> the class of object
 */
public interface Dao<T, K> {
    /**
     * Get object minimum value based on comparator.
     *
     * @param comparator comparator for the objects
     * @return the optional minimal value base on comparator
     */
    Optional<T> getMinimumElement(Comparator<T> comparator);

    /**
     * Get list of all objects with specific class.
     *
     * @param type class of an object
     * @return list of objects with given type
     */
    List<T> getAllByType(K type);

    /**
     * Save the map of class-to-object values.
     *
     * @param values map of class-to-object values
     */
    void saveAll(Map<K, List<T>> values);
}
