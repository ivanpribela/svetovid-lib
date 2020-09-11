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

package org.svetovid.demo;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.svetovid.Svetovid;

public class Dialogs {

    public static void main(String[] args) {

        // Set look and feel to Nimbus
        try { UIManager.setLookAndFeel(new NimbusLookAndFeel()); } catch (UnsupportedLookAndFeelException e) { }
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        // Show basic info dialog boxes
        Svetovid.gui.showMessage(null, "This is a message text.");
        Svetovid.gui.showInformation(null, "This is a message text that\nspans multiple lines.");
        Svetovid.gui.showWarning(null, "This is a warning message text!");
        Svetovid.gui.showError(null, "This is an error message text.");

        // Show basic question dialogs
        String answer1 = Svetovid.gui.askQuestion(null, "This is a message that asks a question\nwith a free-form textual answer.");
        Svetovid.gui.showMessage(null, "You answered:\n'" + answer1 + "'");
        Object answer2 = Svetovid.gui.askQuestion(null, "This is a message that asks the user\nto select one of predetermined answers.", new String[]{"Option 1", "Option 2", "Option 3"}, "Option 2");
        Svetovid.gui.showMessage(null, "You answered:\n'" + answer2 + "'");
        boolean answer3 = Svetovid.gui.askConfirmation(null, "This is a message that asks the user\nto answer with 'yes' or 'no'.");
        if (answer3) {
            Svetovid.gui.showMessage(null, "You answered:\n'yes'");
        } else {
            Svetovid.gui.showMessage(null, "You answered:\n'no'");
        }
        Boolean answer4 = Svetovid.gui.askConfirmationWithCancel(null, "This is a message that asks the user\nto answer with 'yes' or 'no'\nand allows him to cancel the question.");
        if (answer4 == null) {
            Svetovid.gui.showMessage(null, "You clicked\n'cancel'");
        } else if (answer3) {
            Svetovid.gui.showMessage(null, "You answered:\n'yes'");
        } else {
            Svetovid.gui.showMessage(null, "You answered:\n'no'");
        }

        // Show basic login and password dialogs
        Svetovid.gui.askLogin(null, "Please login using your user name and passowrd.");
        Svetovid.gui.askLogin(null, "This dialog asks for login details for the user 'john'.", "john");
        Svetovid.gui.askPassword(null, "This dialog asks only for password.");

        // Demonstrate exception reporting
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
            Svetovid.gui.showError(null, "An intentional error occured and this is the description of the error.\nThis dialog will close itself after 20 seconds.\nFor more information click 'details'.", e, 20000);
        }

    }

    // Methods used to illustrate exception message dialog
    private static String method1() {
        try {
            if (method2("x")) {
                return "x";
            }
            return "";
        } catch (Exception e) {
            throw new IllegalArgumentException("b", e);
        }
    }

    private static boolean method2(String b) {
        try {
            return b.equals(method3());
        } catch (Exception e) {
            throw new IllegalArgumentException("b", e);
        }
    }

    private static String method3() {
        return method4();
    }

    private static String method4() {
        Object a = method5();
        return a.toString();
    }

    private static Object method5() {
        Object[] o = new Object[6];
        o.notify();
        return null;
    }
}
