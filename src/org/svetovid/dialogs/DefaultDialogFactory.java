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

package org.svetovid.dialogs;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Locale;

public class DefaultDialogFactory extends AbstractDialogFactory {

    public DefaultDialogFactory() {
        this(Locale.getDefault());
    }

    public DefaultDialogFactory(Clipboard clipboard) {
        this(Locale.getDefault(), clipboard);
    }

    public DefaultDialogFactory(Locale locale) {
        this(locale, Toolkit.getDefaultToolkit().getSystemClipboard());
    }

    public DefaultDialogFactory(Locale locale, Clipboard clipboard) {
        super(locale, clipboard);
    }

    @Override
    public Locale getLocale() {
        return super.getLocale();
    }

    @Override
    public void setLocale(Locale newValue) {
        super.setLocale(newValue);
    }

    @Override
    public Clipboard getClipboard() {
        return super.getClipboard();
    }

    @Override
    public void setClipboard(Clipboard newValue) {
        super.setClipboard(newValue);
    }

    public boolean isNewStackTraceStyle() {
        return newStackTraceStyle;
    }

    public void setNewStackTraceStyle(boolean newValue) {
        newStackTraceStyle = newValue;
    }
}
