package by.bsuir.webtech.second.task.parsing.builder;

/**
 * Wrapper for the appliance builder exceptions when
 * {@link NumberFormatException} failed.
 * Thrown by {@link ApplianceXmlBuilder}.
 *
 * @author newvlad2001
 */
public class ApplianceBuilderException extends Exception {
    /**
     * Construct a {@code ApplianceBuilderException} with the specified detail message
     * and nested exception.
     *
     * @param message the detail message
     * @param cause   the nested exception
     */
    public ApplianceBuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
