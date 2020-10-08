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

import java.awt.GraphicsEnvironment;
import java.util.List;

import org.svetovid.dialogs.AutoCloseDialogFactory;
import org.svetovid.dialogs.Dialogs;
import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidIOException;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;
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
public class Svetovid {

    /** Don't let anyone instantiate this class. */
    private Svetovid() {
    }

    /**
     * The "standard" input. This reader is already open and ready to supply
     * input data. Typically this stream corresponds to keyboard input or
     * another input source specified by the host environment or user.
     */
    public static StandardSvetovidReader in = org.svetovid.Svetovid.in;

    /**
     * The "standard" output. This writer is already open and ready to accept
     * output data. Typically this stream corresponds to display output or
     * another output destination specified by the host environment or user.
     */
    public static StandardSvetovidWriter out = org.svetovid.Svetovid.out;

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
    public static StandardSvetovidErrorWriter err = org.svetovid.Svetovid.err;

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
        return org.svetovid.Svetovid.testIn(source);
    }

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
        return org.svetovid.Svetovid.testOut(target);
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
        return org.svetovid.Svetovid.testAppend(target);
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
        return org.svetovid.Svetovid.testOut(target, append);
    }

    /**
     * The input reader for the given source. The returned reader is already
     * open and ready to supply input data. If the supplied source string is a
     * file name, the returned reader will correspond to that file. If the
     * source is a url the reader will read the resource identified by that url.
     * Otherwise, the returned reader will correspond to the standard input
     * stream.
     *
     * @param source
     *            a string describing the source
     *
     * @return a {@link SvetovidReader} that can be used to read from the
     *         desired source.
     */
    public static SvetovidReader in(String source) {
        return org.svetovid.Svetovid.in(source);
    }

    /**
     * The output writer for the given target. The returned writer is already
     * open and ready to accept output data. If the supplied target string is a
     * file name, the returned writer will correspond to that file; otherwise it
     * will correspond to the standard output stream.
     *
     * @param target
     *            a string describing the writter's target
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     */
    public static SvetovidWriter out(String target) {
        return org.svetovid.Svetovid.out(target);
    }

    /**
     * The output writer that will append data to the given target. The returned
     * writer is already open and ready to accept output data. If the supplied
     * target string is a file name, the returned writer will correspond to that
     * file; otherwise it will correspond to the standard output stream.
     *
     * @param target
     *            a string describing the writter's target
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     */
    public static SvetovidWriter append(String target) {
        return org.svetovid.Svetovid.append(target);
    }

    /**
     * The output writer that will optionally append data to the given target.
     * The returned writer is already open and ready to accept output data. If
     * the supplied target string is a file name, the returned writer will
     * correspond to that file; otherwise it will correspond to the standard
     * output stream.
     *
     * @param target
     *            a string describing the writter's target
     * @param append
     *            should the data be appended to the given target or not
     *
     * @return a {@link SvetovidWriter} that can be used to write to the desired
     *         target.
     */
    public static SvetovidWriter out(String target, boolean append) {
        return org.svetovid.Svetovid.out(target, append);
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
        return org.svetovid.Svetovid.closeIn(source);
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
        return org.svetovid.Svetovid.closeOut(target);
    }

    /**
     * The graphical user interface factory used to create and show message and
     * dialog boxes.
     */
    public static AutoCloseDialogFactory gui = Dialogs
            .getFactory(org.svetovid.Svetovid.LOCALE);

    /**
     * The main method just prints out the version number.
     *
     * @param args
     *            this argument is just ignored
     */
    public static void main(String[] args) {

        // Get own version
        Version myVersion = org.svetovid.Svetovid.getVersion();

        // Show running version
        Svetovid.out.println("Svetovid: " + myVersion);

        // Show dialog if there is no console
        if (System.console() == null && !GraphicsEnvironment.isHeadless()) {
            Dialogs.showInformation(null, "Svetovid: " + myVersion);
        }

        // Fetch info on newer versions
        List<Release> releases = org.svetovid.Svetovid.getLibraryReleases();
        for (Release release : releases) {
            if (release.getVersion().compareTo(myVersion) > 0) {
                Svetovid.out.println();
                Svetovid.out.println("Version " + release.getVersion() + " available from:");
                Svetovid.out.println(release.getUrl());
            }
        }

    }
}
