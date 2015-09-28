/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.svetovid;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Signals that a parsing error of some sort has occurred.
 *
 * @author Ivan Pribela
 *
 * @see org.svetovid.io.SvetovidReader
 * @see org.svetovid.io.SvetovidWriter
 */
public class SvetovidFormatException extends SvetovidException {

    private static final long serialVersionUID = 1829394491209593218L;

    /**
     * Constructs a {@code SvetovidFormatException} with the specified message.
     *
     * @param type
     *            The type to which the string could not be parsed
     * @param string
     *            The string that could not be parsed
     */
    public SvetovidFormatException(Class<?> type, String string) {
        super(type.getSimpleName(),
                string == null ? null : "\"" + string + "\"");
    }

    /**
     * Constructs a {@code SvetovidFormatException} with the specified detail
     * message and cause.
     *
     * @param type
     *            The type to which the string could not be parsed
     * @param string
     *            The string that could not be parsed
     * @param cause
     *            The cause, if any
     */
    public SvetovidFormatException(Class<?> type, String string,
            Throwable cause) {
        super(type.getSimpleName(), cause,
                string == null ? null : "\"" + string + "\"");
    }

    /**
     * Constructs a {@code SvetovidFormatException} with multiple suppressed
     * causes.
     *
     * @param causes
     *            The suppressed causes of this exception
     */
    public SvetovidFormatException(Throwable... causes) {
        super("Array");
        for (Throwable cause : causes) {
            addSuppressed(cause);
        }
    }

    /**
     * Constructs a {@code SvetovidFormatException} with multiple suppressed
     * causes.
     *
     * @param causes
     *            The suppressed causes of this exception
     */
    public SvetovidFormatException(List<? extends Throwable> causes) {
        super("Array");
        for (Throwable cause : causes) {
            addSuppressed(cause);
        }
    }

    /**
     * Constructs a {@code SvetovidFormatException} with the specified detail
     * message and cause.
     *
     * @param messageKey
     *            The resource bundle key of the detail message, which is saved
     *            for later retrieval by the {@link #getMessage()} method
     * @param string
     *            The string that could not be parsed
     * @param cause
     *            The cause, if any
     */
    public SvetovidFormatException(String messageKey, String string,
            Throwable cause) {
        super(messageKey, cause, string);
    }

    /**
     * Constructs a {@code SvetovidFormatException} with the specified detail
     * message and cause.
     *
     * @param string
     *            The string that could not be parsed
     * @param cause
     *            The cause of the format exception
     */
    public SvetovidFormatException(IllegalFormatException cause, String string) {
        super("PrintFormat." + cause.getClass().getSimpleName(), cause, string);
    }
}
