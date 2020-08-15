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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.svetovid.dialogs.AutoCloseDialogFactory;
import org.svetovid.dialogs.Dialogs;
import org.svetovid.io.DefaultSvetovidReader;
import org.svetovid.io.DefaultSvetovidWriter;
import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidIOException;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;
import org.svetovid.util.JsonHelper;
import org.svetovid.util.Release;
import org.svetovid.util.Version;

/**
 * This is a utility class that serves as an easy access point to various
 * functionalities of Svetovid library.
 *
 * The main functionalities provided are readers and writers for standard input
 * and output streams and file access, as well as graphical user interface
 * message boxes and dialogs.
 *
 * @author Ivan Pribela
 */
public final class Svetovid {

    /** Default encoding is Unicode UTF-8. */
    public static final String CHARSET_NAME = "UTF-8";

    /** Default locale is US English. */
    public static final Locale LOCALE = Locale.US;

    /**
     * Default pattern for matching whitespace is same as in Java programming
     * language.
     */
    public static final Pattern WHITESPACE_PATTERN = Pattern
            .compile("\\p{javaWhitespace}+");

    /** Default token separator is a single space character. */
    public static final String WHITESPACE = " ";

    /** String that is used to substitute null value. */
    public static final String NULL_STRING = "null";

    /** By default, all writers will not flush automatically. */
    public static final boolean AUTO_FLUSH = false;

    /** By default, all readers and writers are not throwing exceptions. */
    public static final boolean THROW_EXCEPTIONS = false;

    /** Don't let anyone instantiate this class. */
    private Svetovid() {
    }

    /**
     * The "standard" input. This reader is already open and ready to supply
     * input data. Typically this stream corresponds to keyboard input or
     * another input source specified by the host environment or user.
     */
    public static StandardSvetovidReader in = new StandardSvetovidReader();

    /* Map of all open readers. */
    private static Map<String, SvetovidReader> readers = new HashMap<>();

    /**
     * Checks whether the given source can be used for input.
     *
     * @param source
     *            a string describing the source
     *
     * @return {@code true} if the given source can be read; {@code false}
     *         otherwise.
     */
    public static boolean testIn(String source) {
        try {
            in(source);
            return true;
        } catch (SvetovidIOException e) {
            return false;
        }
    }

    /**
     * The input reader for the given source. The returned reader is already
     * open and ready to supply input data. If the supplied source string is a
     * file name, the returned reader will correspond to that file. If the
     * source is a URL the reader will read the resource identified by that URL.
     * If the source is null, the returned reader will correspond to the
     * standard input stream. Otherwise, an exception will be thrown.
     *
     * @param source
     *            a string describing the source
     *
     * @return a {@link SvetovidReader} that can be used to read from the
     *         desired source.
     *
     * @throws SvetovidIOException
     *             if the reader cannot be created for the given source or an
     *             error occurred during the operation.
     */
    public static SvetovidReader in(String source) throws SvetovidIOException {
        if (source == null) {
            return in;
        }
        synchronized (readers) {
            IOException ex = null;
            SvetovidReader reader = readers.get(source);
            if (reader == null) {
                try {
                    URL url = new URL(source);
                    URLConnection connection = url.openConnection();
                    reader = new DefaultSvetovidReader(
                            connection.getInputStream());
                    readers.put(source, reader);
                } catch (IOException e) {
                    ex = e;
                }
            }
            if (reader == null) {
				try {
	            	StackTraceElement[] stack = Thread.currentThread().getStackTrace();
	            	String className = stack[stack.length - 1].getClassName();
	            	InputStream stream = Class.forName(className).getResourceAsStream(source);
	            	if (stream != null) {
	            		reader = new DefaultSvetovidReader(stream);
	            		readers.put(source, reader);
	            	}
				} catch (ClassNotFoundException e) {
					// Don't report, try other options
				}
            }
            if (reader == null) {
                try {
                    reader = new DefaultSvetovidReader(
                            new FileInputStream(source));
                    readers.put(source, reader);
                } catch (FileNotFoundException e) {
                    ex = e;
                }
            }
            if (reader == null) {
                throw new SvetovidIOException("BadSource", ex, source);
            }
            return reader;
        }
    }

    /**
     * Closes the reader (if any) and releases any resources associated with the
     * given source.
     *
     * @param source
     *            the source for which to close the reader
     * @return the closed reader.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public static SvetovidReader closeIn(String source)
            throws SvetovidIOException {
        synchronized (readers) {
            SvetovidReader reader = readers.remove(source);
            if (reader != null) {
                reader.close();
            }
            return reader;
        }
    }

    /**
     * Closes the given reader and releases any resources associated with the
     * underlying source. See {@link SvetovidReader#close} for details.
     *
     * @param reader
     *            the reader to close
     * @return the closed reader.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public static SvetovidReader close(SvetovidReader reader)
            throws SvetovidIOException {
        synchronized (readers) {
            String source = null;
            Set<Entry<String, SvetovidReader>> entries = readers.entrySet();
            for (Entry<String, SvetovidReader> entry : entries) {
                if (entry.getValue() == reader) {
                    source = entry.getKey();
                    break;
                }
            }
            return closeIn(source);
        }
    }

    /**
     * The "standard" output. This writer is already open and ready to accept
     * output data. Typically this stream corresponds to display output or
     * another output destination specified by the host environment or user.
     */
    public static StandardSvetovidWriter out = new StandardSvetovidWriter();

    /**
     * The "standard" error output. This writer is already open and ready to
     * accept output data. Typically this stream corresponds to display output
     * or another output destination specified by the host environment or user.
     * By convention, this output stream is used to display error messages or
     * other information that should come to the immediate attention of a user
     * even if the principal output stream, the value of the variable
     * {@link #out}, has been redirected to a file or other destination that is
     * typically not continuously monitored.
     */
    public static StandardSvetovidErrorWriter err =
            new StandardSvetovidErrorWriter();

    /* Map of all open writers. */
    private static Map<String, SvetovidWriter> writers = new HashMap<>();

    /**
     * Checks whether the given target can be used for output.
     *
     * @param target
     *            a string describing the target
     *
     * @return {@code true} if it is possible to write to the given target;
     *         {@code false} otherwise.
     */
    public static boolean testOut(String target) {
        return testOut(target, false);
    }

    /**
     * Checks whether the data can be appended to the given target.
     *
     * @param target
     *            a string describing the target
     *
     * @return {@code true} if it is possible to append data to the given
     *         target; {@code false} otherwise.
     */
    public static boolean testAppend(String target) {
        return testOut(target, true);
    }

    /**
     * Checks whether the given target can be used for output.
     *
     * @param target
     *            a string describing the target
     * @param append
     *            {@code true} to check if the data can be appended to the
     *            target; {@code false} to check if the data can be overwritten
     *
     * @return {@code true} if it is possible to write to the given target;
     *         {@code false} otherwise.
     */
    public static boolean testOut(String target, boolean append) {
        try {
            out(target, append);
            return true;
        } catch (SvetovidIOException e) {
            return false;
        }
    }

    /**
     * The output writer for the given target. The returned writer is already
     * open and ready to accept output data. If the supplied target string is a
     * file name, the returned writer will correspond to that file. If the
     * target is null, the returned writer will correspond to the standard
     * output stream. Otherwise, an exception will be thrown.
     *
     * @param target
     *            a string describing the writter's target
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     */
    public static SvetovidWriter out(String target) {
        return out(target, false);
    }

    /**
     * The output writer that will append data to the given target. The returned
     * writer is already open and ready to accept output data. If the supplied
     * target string is a file name, the returned writer will correspond to that
     * file. If the target is null, the returned writer will correspond to the
     * standard output stream. Otherwise, an exception will be thrown.
     *
     * @param target
     *            a string describing the writter's target
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     */
    public static SvetovidWriter append(String target) {
        return out(target, true);
    }

    /**
     * The output writer that will optionally append data to the given target.
     * The returned writer is already open and ready to accept output data. If
     * the supplied target string is a file name, the returned writer will
     * correspond to that file. If the target is null, the returned writer will
     * correspond to the standard output stream. Otherwise, an exception will be
     * thrown.
     *
     * @param target
     *            a string describing the writter's target
     * @param append
     *            should the data be appended to the given target or not
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     *
     * @throws SvetovidIOException
     *             if the writer cannot be created for the given target or an
     *             error occurred during the operation.
     */
    public static SvetovidWriter out(String target, boolean append)
            throws SvetovidIOException {
        if (target == null) {
            return out;
        }
        synchronized (writers) {
            IOException ex = null;
            SvetovidWriter writer = writers.get(target);
            if (writer == null) {
                try {
                    writer = new DefaultSvetovidWriter(
                            new FileOutputStream(target, append));
                    writers.put(target, writer);
                } catch (FileNotFoundException e) {
                    ex = e;
                }
            }
            if (writer == null) {
                throw new SvetovidIOException("BadTarget", ex, target);
            }

            return writer;
        }
    }

    /**
     * Closes the writer (if any) and releases any resources associated with the
     * given target.
     *
     * @param target
     *            the target for which to close the writer
     * @return the closed writer.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public static SvetovidWriter closeOut(String target)
            throws SvetovidIOException {
        synchronized (writers) {
            SvetovidWriter writer = writers.remove(target);
            if (writer != null) {
                writer.close();
            }
            return writer;
        }
    }

    /**
     * Closes the given writer and releases any resources associated with the
     * underlying target. See {@link SvetovidWriter#close} for details.
     *
     * @param writer
     *            the writer to close
     * @return the closed writer.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public static SvetovidWriter close(SvetovidWriter writer)
            throws SvetovidIOException {
        synchronized (writers) {
            String target = null;
            Set<Entry<String, SvetovidWriter>> entries = writers.entrySet();
            for (Entry<String, SvetovidWriter> entry : entries) {
                if (entry.getValue() == writer) {
                    target = entry.getKey();
                    break;
                }
            }
            return closeOut(target);
        }
    }

    /**
     * The graphical user interface factory used to create and show message and
     * dialog boxes.
     */
    public static final AutoCloseDialogFactory gui = Dialogs.getFactory(LOCALE);

    static {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
    }

    /* The thread that runs at the VM shutdown to close all opened streams. */
    private static class ShutdownThread extends Thread {

        @Override
        public void run() {
            in.close();
            out.close();
            err.close();
            synchronized (readers) {
                for (SvetovidReader reader : readers.values()) {
                    reader.close();
                }
            }
            synchronized (writers) {
                for (SvetovidWriter writer : writers.values()) {
                    writer.close();
                }
            }
        }
    }

    static {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(
                Thread.getDefaultUncaughtExceptionHandler()));
    }

    /* Exception handler that prints uncaught exceptions in all threads. */
    private static class UncaughtExceptionHandler implements
            Thread.UncaughtExceptionHandler {

        private java.lang.Thread.UncaughtExceptionHandler delegate;

        public UncaughtExceptionHandler(
                Thread.UncaughtExceptionHandler delegate) {
            this.delegate = delegate;
        }

        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            if (delegate != null) {
                delegate.uncaughtException(thread, throwable);
            } else {
                SvetovidException.printStackTrace(thread, throwable,
                        System.err, Svetovid.LOCALE);
            }
        }
    }

    private static final String VERSION_DATA_FILE = "version.properties";
    private static Properties versionData;
    private static String versionString;
    private static Version versionObject;
    static {
        versionData = new Properties();
        try {
            versionData.load(Svetovid.class.getClassLoader().getResourceAsStream(VERSION_DATA_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        versionString = versionData.getProperty("version");
        if (versionString == null) {
            versionString = "unknown";
        }
        versionObject = new Version(versionString);
    }

    public static String getVersionString() {
        return versionString;
    }

    public static Version getVersion() {
        return versionObject;
    }

    public static List<Release> getLibraryReleases() {
        String libraryReleasesUrl = "https://api.github.com/repos/ivanpribela/svetovid-lib/releases";
        Object libraryReleasesData = Svetovid.in(libraryReleasesUrl).readObject();
        List<Release> releases = new ArrayList<>();
        for (Object libraryReleaseData : JsonHelper.getArray(libraryReleasesData, ".")) {
            try {
                String tagName = JsonHelper.getString(libraryReleaseData, "tag_name");
                Version version = new Version(tagName);
                String htmlUrl =  JsonHelper.getString(libraryReleaseData, "html_url");
                URL url = new URL(htmlUrl);
                Release release = new Release(version, url);
                releases.add(release);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return releases;
    }
}
