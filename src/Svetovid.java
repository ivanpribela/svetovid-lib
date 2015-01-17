import org.svetovid.dialogs.AutoCloseDialogFactory;
import org.svetovid.dialogs.Dialogs;
import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

public class Svetovid {

    /** Don't let anyone instantiate this class */
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
     * {@link out}, has been redirected to a file or other destination that is
     * typically not continuously monitored.
     */
    public static StandardSvetovidErrorWriter err = org.svetovid.Svetovid.err;

    /**
     * The input reader for the given source. The returned stream is already
     * open and ready to supply input data. If the supplied source string is a
     * file name, the returned reader will correspond to that file. If the
     * source is a url the reader will read the resource identified by that url.
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
     * The output writter for the given target. This stream is already open and
     * ready to accept output data. Typically this stream corresponds to display
     * output or another output destination specified by the host environment or
     * user.
     */
    public static SvetovidWriter out(String source) {
        return org.svetovid.Svetovid.out(source);
    }

    public static SvetovidWriter append(String source) {
        return org.svetovid.Svetovid.append(source);
    }

    public static SvetovidWriter out(String source, boolean append) {
        return org.svetovid.Svetovid.out(source, append);
    }

    public static AutoCloseDialogFactory gui = Dialogs.getFactory(org.svetovid.Svetovid.LOCALE);
}
