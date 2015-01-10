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
