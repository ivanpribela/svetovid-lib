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
