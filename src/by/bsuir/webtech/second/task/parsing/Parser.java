package by.bsuir.webtech.second.task.parsing;

import java.util.List;
import java.util.Map;

/**
 * Basic parser interface supporting object classes.
 *
 * @param <T> the object type
 * @param <K> the class of object
 */
public interface Parser<T, K> {
    /**
     * Parse the file.
     *
     * @param path path to file
     * @return map of class-to-object values
     * @throws ParserException in case of errors during parsing
     */
    Map<K, List<T>> parse(String path) throws ParserException;
}
