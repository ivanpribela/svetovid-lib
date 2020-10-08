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

import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import java.util.Locale;

import javax.swing.Icon;

public class AutoCloseDialogFactory extends DefaultDialogFactory {

    public AutoCloseDialogFactory() {
        super();
    }

    public AutoCloseDialogFactory(Locale locale) {
        super(locale);
    }

    public AutoCloseDialogFactory(Clipboard clipboard) {
        super(clipboard);
    }

    public AutoCloseDialogFactory(Locale locale, Clipboard clipboard) {
        super(locale, clipboard);
    }

    public int getDefaultAutoCloseTimeout() {
        return defaultAutoCloseTimeout;
    }

    public void setDefaultAutoCloseTimeout(int defaultAutoCloseTimeout) {
        this.defaultAutoCloseTimeout = defaultAutoCloseTimeout;
    }

    @Override
    public void showMessage(Component component, String text, int timeout) {
        super.showMessage(component, text, timeout);
    }

    @Override
    public void showInformation(Component component, String text, int timeout) {
        super.showInformation(component, text, timeout);
    }

    @Override
    public void showWarning(Component component, String text, int timeout) {
        super.showWarning(component, text, timeout);
    }

    @Override
    public void showError(Component component, String text, int timeout) {
        super.showError(component, text, timeout);
    }

    @Override
    public void showError(Component component, String text, Throwable th, int timeout) {
        super.showError(component, text, th, timeout);
    }

    @Override
    public void showException(Component component, Throwable th, int timeout) {
        super.showException(component, th, timeout);
    }

    @Override
    public boolean askConfirmation(Component component, String text, int timeout) {
        return super.askConfirmation(component, text, timeout);
    }

    @Override
    public Boolean askConfirmationWithCancel(Component component, String text, int timeout) {
        return super.askConfirmationWithCancel(component, text, timeout);
    }

    @Override
    public String askQuestion(Component component, String text, int timeout) {
        return super.askQuestion(component, text, timeout);
    }

    @Override
    public String askQuestion(Component component, String text, String answer, int timeout) {
        return super.askQuestion(component, text, answer, timeout);
    }

    @Override
    public Object askQuestion(Component component, String text, Object[] options, Object defaultOption, int timeout) {
        return super.askQuestion(component, text, options, defaultOption, timeout);
    }

    @Override
    public char[] askPassword(Component component, String text, int timeout) {
        return super.askPassword(component, text, timeout);
    }

    @Override
    public LoginData askLogin(Component component, String text, int timeout) {
        return super.askLogin(component, text, timeout);
    }

    @Override
    public LoginData askLogin(Component component, String text, String username, int timeout) {
        return super.askLogin(component, text, username, timeout);
    }

    @Override
    public boolean showDialog(Component component, Component content, String title, Icon icon, int timeout) {
        return super.showDialog(component, content, title, icon, timeout);
    }

    @Override
    public <T> T showDialog(Component component, DialogContent<T> content, String title, Icon icon, int timeout) {
        return super.showDialog(component, content, title, icon, timeout);
    }
}
