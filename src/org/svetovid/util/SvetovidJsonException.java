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

package org.svetovid.util;

import org.svetovid.SvetovidException;

/**
 * Signals that an error occurred while working with JSON objects.
 *
 * @author Ivan Pribela
 */
public class SvetovidJsonException extends SvetovidException {

    private static final long serialVersionUID = 7164424464583951740L;

    /**
     * Constructs a {@code SvetovidJsonException} with the specified message.
     *
     * @param requestedType
     *            The JSON type to which the object could not be cast
     * @param actualType
     *            The type of the object found
     * @param cause
     *            The cause, which is saved for later retrieval by the
     *            {@link #getCause()} method. A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.
     */
    public SvetovidJsonException(JsonType requestedType, Class<?> actualType,
            Throwable cause) {
        super("Conversion", cause, requestedType.toString(),
                actualType.getSimpleName());
    }

    /**
     * Constructs a {@code SvetovidJsonException} with the specified message.
     *
     * @param requestedType
     *            The JSON type to which the object could not be cast
     * @param actualType
     *            The type of the object found
     */
    public SvetovidJsonException(JsonType requestedType, Class<?> actualType) {
        super("Conversion", requestedType.toString(),
                actualType.getSimpleName());
    }
}
