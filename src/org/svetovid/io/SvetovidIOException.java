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

package org.svetovid.io;

import java.io.IOException;

import org.svetovid.SvetovidException;

/**
 * Signals that an I/O exception of some sort has occurred. This class is the
 * general class of exceptions produced by failed or interrupted I/O operations.
 *
 * @author Ivan Pribela
 *
 * @see SvetovidReader
 * @see SvetovidWriter
 */
public class SvetovidIOException extends SvetovidException {

    private static final long serialVersionUID = -4381176842757568440L;

    /**
     * Constructs a {@code SvetovidIOException} with the specified message.
     *
     * @param messageKey
     *            The resource bundle key of the detail message, which is saved
     *            for later retrieval by the {@link #getMessage()} method
     * @param messageArguments
     *            Optional arguments for formatting of the detail message
     */
    public SvetovidIOException(String messageKey, Object... messageArguments) {
        super(messageKey, messageArguments);
    }

    /**
     * Constructs a {@code SvetovidIOException} with the specified detail
     * message and cause.
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
    public SvetovidIOException(String messageKey, Throwable cause,
            Object... messageArguments) {
        super(messageKey, cause, messageArguments);
    }

    /**
     * Constructs a {@code SvetovidIOException} with the specified cause.
     *
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated into this exception's detail message, but a
     * generic one is used instead.
     *
     * @param messageKey
     *            The resource bundle key of the detail message, which is saved
     *            for later retrieval by the {@link #getMessage()} method
     * @param cause
     *            The cause, which is saved for later retrieval by the
     *            {@link #getCause()} method. A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.
     */
    public SvetovidIOException(String messageKey, IOException cause) {
        super(messageKey, cause, cause.getMessage());
    }
}
