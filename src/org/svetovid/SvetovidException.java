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

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

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
    public SvetovidException(String messageKey, Throwable cause,
            Object... messageArguments) {
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
        ResourceBundle bundle =
                ResourceBundle.getBundle("i18n/exception", locale);
        String pattern =
                bundle.getString(getClass().getSimpleName() + "." + messageKey);
        return MessageFormat.format(pattern, messageArguments);
    }

    /**
     * Prints this exception and its stack trace to the standard error stream.
     */
    @Override
    public void printStackTrace() {
        printStackTrace(null, this);
    }

    /**
     * Prints this exception and its stack trace to the specified print stream.
     *
     * @param stream
     *            {@code PrintStream} to use for output
     */
    @Override
    public void printStackTrace(PrintStream stream) {
        printStackTrace(null, this, stream);
    }

    /**
     * Prints this exception and its stack trace to the specified print writer.
     *
     * @param writer
     *            {@code PrintWriter} to use for output
     */
    @Override
    public void printStackTrace(PrintWriter writer) {
        printStackTrace(null, this, writer);
    }

    /**
     * Prints this exception and its stack trace to the standard error stream in
     * the specified locale.
     *
     * @param locale
     *            the local to use for printing
     */
    public void printStackTrace(Locale locale) {
        printStackTrace(null, this, locale);
    }

    /**
     * Prints this exception and its stack trace to the specified print stream
     * in the specified locale.
     *
     * @param stream
     *            {@code PrintStream} to use for output
     * @param locale
     *            the local to use for printing
     */
    public void printStackTrace(PrintStream stream, Locale locale) {
        printStackTrace(null, this, stream, locale);
    }

    /**
     * Prints this exception and its stack trace to the specified print writer
     * in the specified locale.
     *
     * @param writer
     *            {@code PrintWriter} to use for output
     * @param locale
     *            the local to use for printing
     */
    public void printStackTrace(PrintWriter writer, Locale locale) {
        printStackTrace(null, this, writer, locale);
    }

    /**
     * Prints the supplied throwable and its stack trace to the standard error
     * stream. If the thread is supplied also, its name is printed before the
     * throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     */
    public static void printStackTrace(Thread thread, Throwable throwable) {
        printStackTrace(thread, throwable, Svetovid.LOCALE);
    }

    /**
     * Prints the supplied throwable and its stack trace to the specified print
     * stream. If the thread is supplied also, its name is printed before the
     * throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param stream
     *            {@code PrintStream} to use for output
     */
    public static void printStackTrace(Thread thread, Throwable throwable,
            PrintStream stream) {
        printStackTrace(thread, throwable, stream, Svetovid.LOCALE);
    }

    /**
     * Prints the supplied throwable and its stack trace to the specified print
     * writer. If the thread is supplied also, its name is printed before the
     * throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param writer
     *            {@code PrintWriter} to use for output
     */
    public static void printStackTrace(Thread thread, Throwable throwable,
            PrintWriter writer) {
        printStackTrace(thread, throwable, writer, Svetovid.LOCALE);
    }

    /**
     * Prints the supplied throwable and its stack trace to the standard error
     * stream in the specified locale. If the thread is supplied also, its name
     * is printed before the throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param locale
     *            the local to use for printing
     */
    public static void printStackTrace(Thread thread, Throwable throwable,
            Locale locale) {
        printStackTrace(thread, throwable, System.err);
    }

    /**
     * Prints the supplied throwable and its stack trace to the specified print
     * stream in the specified locale. If the thread is supplied also, its name
     * is printed before the throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param stream
     *            {@code PrintStream} to use for output
     * @param locale
     *            the local to use for printing
     */
    public static void printStackTrace(Thread thread, Throwable throwable,
            PrintStream stream, Locale locale) {
        String text = getStackTraceString(thread, throwable, locale);
        stream.println(text);
    }

    /**
     * Prints the supplied throwable and its stack trace to the specified print
     * writer in the specified locale. If the thread is supplied also, its name
     * is printed before the throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param writer
     *            {@code PrintWriter} to use for output
     * @param locale
     *            the local to use for printing
     */
    public static void printStackTrace(Thread thread, Throwable throwable,
            PrintWriter writer, Locale locale) {
        String text = getStackTraceString(thread, throwable, locale);
        writer.println(text);
    }

    /**
     * Returns the message string in the specified locale containing the
     * supplied throwable and its stack trace.
     *
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param locale
     *            the local to use for printing
     *
     * @return the string containing the supplied throwable and its stack trace.
     */
    public static String getStackTraceString(Throwable throwable,
            Locale locale) {
        return getStackTraceString(null, throwable, locale);
    }

    /**
     * Returns the message string in the specified locale containing the
     * supplied throwable and its stack trace. If the thread is supplied also,
     * its name is printed before the throwable.
     *
     * @param thread
     *            the thread on which the throwable was thrown; if it is
     *            {@code null} no thread info is printed
     * @param throwable
     *            the throwable whose stack trace is to be printed
     * @param locale
     *            the local to use for printing
     *
     * @return the string containing the supplied throwable and its stack trace.
     */
    public static String getStackTraceString(Thread thread,
            Throwable throwable, Locale locale) {
        StringBuilder builder = new StringBuilder();
        ResourceBundle bundle =
                ResourceBundle.getBundle("i18n/exception", locale);
        if (thread != null) {
            appendThreadInfo(builder, thread, "", bundle, locale);
        }
        Set<Throwable> dejaVu = Collections.newSetFromMap(
                new IdentityHashMap<Throwable, Boolean>());
        appendStackTrace(builder, throwable, null, "Main", "", dejaVu, bundle,
                locale);
        return builder.toString();
    }

    protected static void appendThreadInfo(StringBuilder builder, Thread thread,
            String prefix, ResourceBundle bundle, Locale locale) {
        String pattern = "StackTrace.Thread";
        pattern = bundle.getString(pattern);
        String threadName = thread.getName();
        pattern = MessageFormat.format(pattern, threadName);
        builder.append(prefix);
        builder.append(pattern);
    }

    protected static void appendStackTrace(StringBuilder builder,
            Throwable throwable, StackTraceElement[] originalStackTrace,
            String role, String prefix, Set<Throwable> dejaVu,
            ResourceBundle bundle, Locale locale) {
        if (dejaVu.contains(throwable)) {
            appendThrowable(builder, throwable, "Cycle", prefix, bundle,
                    locale);
            return;
        }
        dejaVu.add(throwable);
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int m = stackTrace.length - 1;
        int common = 0;
        if (originalStackTrace != null) {
            int n = originalStackTrace.length - 1;
            while (m >= 0 &&
                    n >=0 &&
                    stackTrace[m].equals(originalStackTrace[n])) {
                m--;
                n--;
            }
            common = stackTrace.length - 1 - m;
        }
        appendThrowable(builder, throwable, role, prefix, bundle, locale);
        String indent = "StackTrace.Indent";
        indent = prefix + bundle.getString(indent);
        for (int i = 0; i <= m; i++) {
            appendStackTraceElement(builder, stackTrace[i], indent, bundle,
                    locale);
        }
        if (common != 0) {
            String pattern = "StackTrace.More";
            pattern = bundle.getString(pattern);
            pattern = MessageFormat.format(pattern, common);
            builder.append(indent);
            builder.append(pattern);
            builder.append('\n');
        }
        for (Throwable supressed : throwable.getSuppressed()) {
            appendStackTrace(builder, supressed, stackTrace, "Supressed",
                    indent, dejaVu, bundle, locale);
        }
        Throwable cause = throwable.getCause();
        if (cause != null) {
            appendStackTrace(builder, cause, stackTrace, "Cause", prefix,
                    dejaVu, bundle, locale);
        }
    }

    protected static void appendThrowable(StringBuilder builder,
            Throwable throwable, String role, String prefix,
            ResourceBundle bundle, Locale locale) {
        String pattern = "StackTrace." + role;
        pattern = bundle.getString(pattern);
        String className = throwable.getClass().getName();
        String message;
        if (throwable instanceof SvetovidException) {
            SvetovidException se = (SvetovidException) throwable;
            message = se.getMessage(locale);
        } else {
            message = throwable.getLocalizedMessage();
        }
        pattern = MessageFormat.format(pattern, className, message);
        builder.append(prefix);
        builder.append(pattern);
        builder.append('\n');
    }

    protected static void appendStackTraceElement(StringBuilder builder,
            StackTraceElement element, String prefix, ResourceBundle bundle,
            Locale locale) {
        String pattern = "StackTrace.Element";
        pattern = bundle.getString(pattern);
        String className = element.getClassName();
        String methodName = element.getMethodName();
        String source = element.getFileName();
        if (element.isNativeMethod()) {
            source = bundle.getString("StackTrace.Native");
        } else if (source == null) {
            source = bundle.getString("StackTrace.Unknown");
        } else {
            if (element.getLineNumber() >= 0) {
                source = source + ":" + element.getLineNumber();
            }
        }
        pattern = MessageFormat.format(pattern, className, methodName, source);
        builder.append(prefix);
        builder.append(pattern);
        builder.append('\n');
    }
}
