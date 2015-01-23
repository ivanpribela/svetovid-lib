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

import javax.swing.Icon;

/**
 * This is an interface for factory classes used for creating and showing
 * various types of dialog boxes containing messages, information, questions,
 * etc.
 *
 * @author Ivan Pribela
 * @version 1.0
 */
public interface DialogFactory {

    /**
     * Displays message box containing desired message.
     *
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public void showMessage(Component component, String text);

    /**
     * Displays informational message box containing desired message.
     *
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public void showInformation(Component component, String text);

    /**
     * Displays warning message box containing desired message.
     *
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public void showWarning(Component component, String text);

    /**
     * Displays error message box containing desired message.
     *
     * @param component
     *            determines the frame in which the dialog is displayed; if the
     *            parentComponent has no Frame, a default Frame is used.
     * @param text
     *            text which will be displayed in the message box.
     */
    public void showError(Component component, String text);

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
    public void showError(Component component, String text, Throwable ex);

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
    public void showException(Component component, Throwable ex);

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
    public boolean askConfirmation(Component component, String text);

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
     * @return {@code true} if user answered {@code yes}; {@code false}
     *         if user answered {@code no}; and {@code null} otherwise.
     */
    public Boolean askConfirmationWithCancel(Component component, String text);

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
     * @return {@code String} containing text that user entered; {@code null} if
     *         user has chosen not to answer.
     */
    public String askQuestion(Component component, String text);

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
     * @return {@code String} containing text that user entered; {@code null} if
     *         user has chosen not to answer.
     */
    public String askQuestion(Component component, String text, String answer);

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
    public Object askQuestion(Component component, String text, Object[] options, Object defaultOption);

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
    public char[] askPassword(Component component, String text);

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
    public LoginData askLogin(Component component, String text);

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
    public LoginData askLogin(Component component, String text, String username);

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
    public boolean showDialog(Component component, Component content, String title, Icon icon);

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
    public <T> T showDialog(Component component, DialogContent<T> content, String title, Icon icon);

    /**
     * Returns a dialog icon of the desired type.
     *
     * @param type
     *            determines which icon to return: "question", "warning",
     *            "error", or other
     *
     * @return Returns a dialog icon of the given type.
     */
    public Icon getIcon(String type);

}
