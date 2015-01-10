import org.svetovid.dialogs.AutoCloseDialogFactory;
import org.svetovid.dialogs.Dialogs;
import org.svetovid.io.StandardSvetovidErrorWriter;
import org.svetovid.io.StandardSvetovidReader;
import org.svetovid.io.StandardSvetovidWriter;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

public class Svetovid {

    public static StandardSvetovidReader in = org.svetovid.Svetovid.in;
    public static StandardSvetovidWriter out = org.svetovid.Svetovid.out;
    public static StandardSvetovidErrorWriter err = org.svetovid.Svetovid.err;

    public static SvetovidReader in(String source) {
        return org.svetovid.Svetovid.in(source);
    }

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
