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
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import javax.swing.Icon;

/**
 * This is helper class which contains static methods for showing various types
 * of dialog boxes containing messages, information, questions, etc.
 * 
 * @author Ivan Pribela
 * @version 1.5
 */
public final class Dialogs {

    private static AutoCloseDialogFactory factory = new AutoCloseDialogFactory();

    /**
     * Sets locale which will be used to display messages.
     * 
     * @param newValue
     *            locale which will be used to display messages.
     */
    public static void setLocale(Locale newValue) {
        factory.setLocale(newValue);
    }

    /**
     * Sets clipboard which will be used by displayed messages.
     * 
     * @param newValue
     *            clipboard which will be used by displayed messages.
     */
    public static void setClipboard(Clipboard newValue) {
        factory.setClipboard(newValue);
    }

    /**
     * Sets the stack trace style which will be used by displayed messages.
     * 
     * @param newValue
     *            stack trace style which will be used by displayed messages.
     */
    public void setNewStackTraceStyle(boolean newValue) {
        factory.setNewStackTraceStyle(newValue);
    }


    /**
     * Sets default time before automatically closing dialogs.
     * 
     * @param newValue
     *            the auto close timeout; zero means don't auto close dialogs.
     */
    public static void setTimeout(int newValue) {
        factory.setDefaultAutoCloseTimeout(newValue);
    }

    /**
     * Displays message box containing desired message.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public static void showMessage(Component component, String text) {
        factory.showMessage(component, text);
    }

    /**
     * Displays informational message box containing desired message.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public static void showInformation(Component component, String text) {
        factory.showInformation(component, text);
    }

    /**
     * Displays warning message box containing desired message.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public static void showWarning(Component component, String text) {
        factory.showWarning(component, text);
    }

    /**
     * Displays error message box containing desired message.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public static void showError(Component component, String text) {
        factory.showError(component, text);
    }

    /**
     * Displays error message box containing desired message and optionally
     * stack-trace of the supplied exception.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * @param th
     *            exception which is used to build up the stack-trace
     *            information.
     */
    public static void showError(Component component, String text, Throwable ex) {
        factory.showError(component, text, ex);
    }

    /**
     * Displays error message box containing stack-trace of the supplied
     * exception.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param th
     *            exception which is used to build up the stack-trace
     *            information.
     */
    public static void showException(Component component, Throwable ex) {
        factory.showException(component, ex);
    }

    /**
     * Displays confirmation message box containing desired message, and asking
     * from the user to answer {code Yes} or {@code No}.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * 
     * @return {@code true} if user answered {@code yes}; {@code false}
     *         otherwise.
     */
    public static boolean askConfirmation(Component component, String text) {
        return factory.askConfirmation(component, text);
    }

    /**
     * Displays confirmation message box containing desired message, and asking
     * from the user to answer Yes, No or Cancel.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * 
     * @return {@code True} if user answered {@code yes}; {@code False}
     *         if user answered {@code no}; and {@code null} otherwise.
     */
    public static Boolean askConfirmationWithCancel(Component component, String text) {
        return factory.askConfirmationWithCancel(component, text);
    }

    /**
     * Displays question message box containing desired question, and asking the
     * user to enter the answer.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * 
     * @return {@code String} object containing text that user entered;
     *         {@code null} if user has chosen not to answer.
     */
    public static String askQuestion(Component component, String text) {
        return factory.askQuestion(component, text);
    }

    /**
     * Displays question message box containing desired question, and asking the
     * user to enter the answer.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * @param answer
     *            the initial answer for user to modify.
     * 
     * @return {@code String} object containing text that user entered;
     *         {@code null} if user has chosen not to answer.
     */
    public static String askQuestion(Component component, String text, String answer) {
        return factory.askQuestion(component, text, answer);
    }

    /**
     * Displays question message box containing desired question, and asking the
     * user to choose one of the provided options.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     * @param options
     *            list of available options for the user to choose from.
     * @param defaultOption
     *            initial option that is to be selected.
     * 
     * @return one of the options provided or {@code null} if user has chosen
     *         not to answer.
     */
    public static Object askQuestion(Component component, String text, Object [] options, Object defaultOption) {
        return factory.askQuestion(component, text, options, defaultOption);
    }

    /**
     * Displays password dialog box containing desired message, and asking from
     * the user to enter password.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the dialog box.
     * 
     * @return password entered by the user as an array of {@code char};
     *         {@code null} if user has chosen not to enter the password.
     */
    public static char[] askPassword(Component component, String text) {
        return factory.askPassword(component, text);
    }

    /**
     * Displays login dialog box containing desired message, and asking for user
     * name and password.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the dialog box.
     * 
     * @return user data (user name and password) stored in {@code LoginData}
     *         object; {@code null} if user has chosen not to enter login data.
     */
    public static LoginData askLogin(Component component, String text) {
        return factory.askLogin(component, text);
    }

    /**
     * Displays login dialog box containing desired message, and asking for user
     * name and password.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the dialog box.
     * @param username
     *            default user name.
     * 
     * @return user data (user name and password) stored in {@code LoginData}
     *         object; {@code null} if user has chosen not to enter login
     *         information.
     */
    public static LoginData askLogin(Component component, String text, String username) {
        return factory.askLogin(component, text, username);
    }

    /**
     * Displays a dialog with the given icon and title containing the supplied component.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param content
     *            the component to display on the dialog
     * @param title
     *            title of the dialog
     * @param icon
     *            icon to display on the dialog
     * 
     * @return {@code true} if user answered {@code ok}; {@code false}
     *         otherwise.
     */
    public static boolean showDialog(Component component, Component content, String title, Icon icon) {
        return factory.showDialog(component, content, title, icon);
    }

    /**
     * Displays a dialog with the given icon and title containing the supplied
     * content.
     * 
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param content
     *            the component to display on the dialog
     * @param title
     *            title of the dialog
     * @param icon
     *            icon to display on the dialog
     * 
     * @return The object retrieved from the content component if user answered
     *         {@code ok}; {@code null} otherwise.
     */
    public static <T> T showDialog(Component component, DialogContent<T> content, String title, Icon icon) {
        return factory.showDialog(component, content, title, icon);
    }

    private static class Key {

        private Locale locale;
        private Clipboard clipboard;
        private int timeout;

        public Key(Locale locale, Clipboard clipboard, int timeout) {
            this.locale = locale;
            this.clipboard = clipboard;
            this.timeout = timeout;
        }

        @Override
        public int hashCode() {
            return locale.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Objects.equals(locale, key.locale) && Objects.equals(clipboard, key.clipboard) && (timeout == key.timeout);
        }
    }

    private static Map<Key, AutoCloseDialogFactory> cache = new WeakHashMap<Key, AutoCloseDialogFactory>();

    public static AutoCloseDialogFactory getFactory(Locale locale) {
        return getFactory(locale, null);
    }

    public static AutoCloseDialogFactory getFactory(Locale locale, Clipboard clipboard) {
        return getFactory(locale, clipboard, 0);
    }

    public static AutoCloseDialogFactory getFactory(Locale locale, Clipboard clipboard, int timeout) {
        Key key = new Key(locale, clipboard, timeout);
        AutoCloseDialogFactory factory = cache.get(key);
        if (factory == null) {
            factory = new AutoCloseDialogFactory(locale, clipboard);
            factory.setDefaultAutoCloseTimeout(timeout);
            cache.put(key, factory);
        }
        return factory;
    }
}
