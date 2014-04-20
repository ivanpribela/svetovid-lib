import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

public class Svetovid {

    public static StandardSvetovidReader in = org.svetovid.io.Svetovid.in;
    public static StandardSvetovidWriter out = org.svetovid.io.Svetovid.out;
    public static StandardSvetovidErrorWriter err = org.svetovid.io.Svetovid.err;

    public static SvetovidReader in(String source) {
        return org.svetovid.io.Svetovid.in(source);
    }

    public static SvetovidWriter out(String source) {
        return org.svetovid.io.Svetovid.out(source);
    }

    public static SvetovidWriter append(String source) {
        return org.svetovid.io.Svetovid.append(source);
    }

    public static SvetovidWriter out(String source, boolean append) {
        return org.svetovid.io.Svetovid.out(source, append);
    }
}
