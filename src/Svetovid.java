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
