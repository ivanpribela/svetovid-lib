package org.svetovid.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public final class Svetovid {

    public static final String CHARSET_NAME = "UTF-8";
    public static final Locale LOCALE = Locale.US;
    public static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    public static final String WHITESPACE = " ";
    public static final boolean AUTO_FLUSH = false;

    public static StandardSvetovidReader in = new StandardSvetovidReader();
    private static Map<String, SvetovidReader> readers = new HashMap<>();

    public static SvetovidReader in(String source) {
        synchronized (readers) {
            SvetovidReader reader = readers.get(source);
            if (reader == null) {
                try {
                    URL url = new URL(source);
                    URLConnection connection = url.openConnection();
                    reader = new DefaultSvetovidReader(connection.getInputStream());
                    readers.put(source, reader);
                } catch (IOException e) {
                    // Do nothing
                }
            }
            if (reader == null) {
                try {
                    reader = new DefaultSvetovidReader(new FileInputStream(source));
                    readers.put(source, reader);
                } catch (FileNotFoundException e) {
                    // Do nothing
                }
            }
            return reader;
        }		
    }

    protected static SvetovidReader removeIn(String source) {
        synchronized (readers) {
            SvetovidReader reader = readers.get(source);
            if (reader != null) {
                readers.remove(source);
            }
            return reader;
        }		
    }

    protected static SvetovidReader removeIn(SvetovidReader reader) {
        synchronized (readers) {
            String source = null;
            Set<Entry<String, SvetovidReader>> entries = readers.entrySet();
            for (Entry<String, SvetovidReader> entry : entries) {
                if (entry.getValue() == reader) {
                    source = entry.getKey();
                    break;
                }
            }
            return removeIn(source);
        }		
    }

    public static StandardSvetovidWriter out = new StandardSvetovidWriter();
    public static StandardSvetovidErrorWriter err = new StandardSvetovidErrorWriter();
    private static Map<String, SvetovidWriter> writers = new HashMap<>();

    public static SvetovidWriter out(String source) {
        return out(source, false);
    }

    public static SvetovidWriter append(String source) {
        return out(source, true);
    }

    public static SvetovidWriter out(String source, boolean append) {
        synchronized (writers) {
            SvetovidWriter writer = writers.get(source);
            if (writer == null) {
                try {
                    writer = new DefaultSvetovidWriter(new FileOutputStream(source, append));
                } catch (FileNotFoundException e) {
                    // Do nothing
                }
                writers.put(source, writer);
            }
            return writer;
        }
    }

    protected static SvetovidWriter removeOut(String source) {
        synchronized (writers) {
            SvetovidWriter writer = writers.get(source);
            if (writer != null) {
                writers.remove(source);
            }
            return writer;
        }		
    }

    protected static SvetovidWriter removeOut(SvetovidWriter writer) {
        synchronized (writers) {
            String source = null;
            Set<Entry<String, SvetovidWriter>> entries = writers.entrySet();
            for (Entry<String, SvetovidWriter> entry : entries) {
                if (entry.getValue() == writer) {
                    source = entry.getKey();
                    break;
                }
            }
            return removeOut(source);
        }		
    }

    static {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread() {	});
    }

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

    public static void main(String[] args) throws Exception {
        String[] v = in("http://www.oracle.com").readAllLines();
        //System.out.println(Arrays.toString(v));
        out.setWhitespace("\n");
        out.writeln(v);
    }
}
