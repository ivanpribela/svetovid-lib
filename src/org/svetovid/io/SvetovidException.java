package org.svetovid.io;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.svetovid.Svetovid;

/**
 * {@code SvetovidException} is the superclass of those exceptions that can be
 * thrown during the operation of this library. {@code SvetovidException} and
 * its subclasses are <em>unchecked
 * exceptions</em>.
 *
 * @author Ivan Pribela
 */
public class SvetovidException extends RuntimeException {

    private static final long serialVersionUID = 6174499953383903816L;

    private String messageKey;
    private Object[] messageArguments;

    /**
     * Constructs a {@code SvetovidException} with the specified message.
     *
     * @param messageKey
     *            The resource bundle key of the detail message, which is saved
     *            for later retrieval by the {@link #getMessage()} method
     * @param messageArguments
     *            Optional arguments for formatting of the detail message
     */
    public SvetovidException(String messageKey, Object... messageArguments) {
        super(messageKey);
        this.messageKey = messageKey;
        this.messageArguments = messageArguments;
    }

    /**
     * Constructs a {@code SvetovidException} with the specified detail message
     * and cause.
     *
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated into this exception's detail message.
     *
     * @param messageKey
     *            The resource bundle key of the detail message, which is saved
     *            for later retrieval by the {@link #getMessage()} method
     * @param cause
     *            The cause, which is saved for later retrieval by the
     *            {@link #getCause()} method. A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.
     * @param messageArguments
     *            Optional arguments for formatting of the detail message
     */
    public SvetovidException(String messageKey, Throwable cause, Object... messageArguments) {
        super(messageKey, cause);
        this.messageKey = messageKey;
        this.messageArguments = messageArguments;
    }

    /**
     * Returns the detail message string of this exception.
     *
     * @return the formatted detail message of this exception instance.
     */
    @Override
    public String getMessage() {
        return getMessage(Svetovid.LOCALE);
    }

    /**
     * Creates a localized description of this exception.
     *
     * @param locale
     *            the {@code Locale} in which to return the message
     *
     * @return The localized description of this exception.
     */
    public String getMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n/exception", locale);
        String pattern = bundle.getString(getClass().getSimpleName() + "." + messageKey);
        return MessageFormat.format(pattern, messageArguments);
    }
}
