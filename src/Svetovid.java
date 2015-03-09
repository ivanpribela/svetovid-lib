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

import org.svetovid.dialogs.AutoCloseDialogFactory;
import org.svetovid.dialogs.Dialogs;
import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

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
        Svetovid.out.println("Svetovid: " + org.svetovid.Svetovid.getVersion());
    }
}
