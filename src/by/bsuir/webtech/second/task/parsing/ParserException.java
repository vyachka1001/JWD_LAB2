package by.bsuir.webtech.second.task.parsing;

/**
 * Wrapper for the parser exception when
 * {@link javax.xml.parsers.ParserConfigurationException} or
 * {@link java.io.IOException} or
 * {@link by.bsuir.webtech.second.task.parsing.builder.ApplianceBuilderException} or
 * {@link org.xml.sax.SAXException} failed.
 * Thrown by {@link Parser}.
 *
 * @author newvlad2001
 */
public class ParserException extends Exception {
    /**
     * Construct a {@code ParserException} with the specified detail message
     * and nested exception.
     *
     * @param message the detail message
     * @param cause   the nested exception
     */
    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a {@code ParserException} with the specified detail message.
     *
     * @param message the detail message
     */
    public ParserException(String message) {
        super(message);
    }
}
