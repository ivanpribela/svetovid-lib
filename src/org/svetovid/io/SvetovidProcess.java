package org.svetovid.io;

public class SvetovidProcess {

    public final Process process;
    public final SvetovidWriter in;
    public final SvetovidReader out;
    public final SvetovidReader err;

    public SvetovidProcess(Process process) {
        this.process = process;
        in = new DefaultSvetovidWriter(process.getOutputStream());
        out = new DefaultSvetovidReader(process.getInputStream());
        err = new DefaultSvetovidReader(process.getErrorStream());
    }

    public String toString() {
        return process.toString();
    }

    public int waitFor() throws InterruptedException {
        return process.waitFor();
    }

    public boolean isAlive() {
        try {
            process.exitValue();
            return false;
        } catch(IllegalThreadStateException e) {
            return true;
        }
    }

    public int exitValue() {
        return process.exitValue();
    }

    public void destroy() {
        process.destroy();
    }
}
