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

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * This is a default implementation of a dialog factory used for showing various
 * types of dialog boxes containing messages, information, questions, etc. For
 * documentation see {@link DialogFactory} interface.
 *
 * @see DialogFactory
 *
 * @author Ivan Pribela
 * @version 1.0
 */
public abstract class AbstractDialogFactory implements DialogFactory {

    protected Locale locale;                   // Must not be null
    protected Clipboard clipboard;             // Null clipboard to disable ctrl+c
    protected int defaultAutoCloseTimeout = 0; // 0 means no auto close

    // Bundle
    protected ResourceBundle bundle;

    // Options
    protected String[] okOptions;            // ok
    protected String[] yesNoOptions;         // yes no
    protected String[] yesNoCancelOptions;   // yes no cancel
    protected String[] okCancelOptions;      // ok cancel
    protected String[] loginExitOptions;     // loginok logincancel
    protected String[] okWithDetailsOptions; // ok details

    // Icons
    protected Icon messageIcon;
    protected Icon informationIcon;
    protected Icon warningIcon;
    protected Icon errorIcon;
    protected Icon confirmationIcon;
    protected Icon questionIcon;
    protected Icon passwordIcon;
    protected Icon loginIcon;
    protected Icon exceptionIcon;
    protected Icon timeoutIcon;
    protected Icon findIcon;
    protected Icon replaceIcon;
    protected Icon fontIcon;
    protected Icon colorIcon;
    protected Icon folderIcon;
    protected Icon fileIcon;
    protected Icon dateIcon;
    protected Icon timeIcon;
    protected Icon logoIcon;
    protected Icon logobwIcon;

    protected AbstractDialogFactory(Locale locale, Clipboard clipboard) {
        setLocale(locale);
        setClipboard(clipboard);
    }

    protected Clipboard getClipboard() {
        return clipboard;
    }

    protected void setClipboard(Clipboard newValue) {
        clipboard = newValue;
    }

    protected Locale getLocale() {
        return locale;
    }

    protected void setLocale(Locale newValue) {

        // Locale
        locale = newValue;

        // Bundle
        bundle = ResourceBundle.getBundle("i18n/dialog", locale);

        // Options
        okOptions = new String[] {bundle.getString("ok")};
        yesNoOptions = new String[] {bundle.getString("yes"), bundle.getString("no")};
        yesNoCancelOptions = new String[] {bundle.getString("yes"), bundle.getString("no"), bundle.getString("cancel")};
        okCancelOptions = new String[] {bundle.getString("ok"), bundle.getString("cancel")};
        loginExitOptions = new String[] {bundle.getString("loginok"), bundle.getString("logincancel")};
        okWithDetailsOptions = new String[] {bundle.getString("ok"), bundle.getString("details")};

        // Icons
        messageIcon = Resources.getIcon(bundle.getString("iconmessage"));
        informationIcon = Resources.getIcon(bundle.getString("iconinformation"));
        warningIcon = Resources.getIcon(bundle.getString("iconwarning"));
        errorIcon = Resources.getIcon(bundle.getString("iconerror"));
        confirmationIcon = Resources.getIcon(bundle.getString("iconconfirmation"));
        questionIcon = Resources.getIcon(bundle.getString("iconquestion"));
        passwordIcon = Resources.getIcon(bundle.getString("iconpassword"));
        loginIcon = Resources.getIcon(bundle.getString("iconlogin"));
        exceptionIcon = Resources.getIcon(bundle.getString("iconexception"));
        timeoutIcon = Resources.getIcon(bundle.getString("icontimeout"));
        findIcon = Resources.getIcon(bundle.getString("iconfind"));
        replaceIcon = Resources.getIcon(bundle.getString("iconreplace"));
        fontIcon = Resources.getIcon(bundle.getString("iconfont"));
        colorIcon = Resources.getIcon(bundle.getString("iconcolor"));
        folderIcon = Resources.getIcon(bundle.getString("iconfolder"));
        fileIcon = Resources.getIcon(bundle.getString("iconfile"));
        dateIcon = Resources.getIcon(bundle.getString("icondate"));
        timeIcon = Resources.getIcon(bundle.getString("icontime"));
        logoIcon = Resources.getIcon(bundle.getString("iconlogo"));
        logobwIcon = Resources.getIcon(bundle.getString("iconlogobw"));

    }

    @Override
    public void showMessage(Component component, String text) {
        showMessage(component, text, defaultAutoCloseTimeout);
    }

    protected void showMessage(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, messageIcon);
        pane.setOptions(okOptions);
        pane.setInitialValue(okOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("message"), text, timeout);
        dialog.setVisible(true);
        destroyDialog(dialog, pane);
    }

    @Override
    public void showInformation(Component component, String text) {
        showInformation(component, text, defaultAutoCloseTimeout);
    }

    protected void showInformation(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, informationIcon);
        pane.setOptions(okOptions);
        pane.setInitialValue(okOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("information"), text, timeout);
        dialog.setVisible(true);
        destroyDialog(dialog, pane);
    }

    @Override
    public void showWarning(Component component, String text) {
        showWarning(component, text, defaultAutoCloseTimeout);
    }

    protected void showWarning(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, warningIcon);
        pane.setOptions(okOptions);
        pane.setInitialValue(okOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("warning"), text, timeout);
        dialog.setVisible(true);
        destroyDialog(dialog, pane);
    }

    @Override
    public void showError(Component component, String text) {
        showError(component, text, defaultAutoCloseTimeout);
    }

    protected void showError(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, errorIcon);
        pane.setOptions(okOptions);
        pane.setInitialValue(okOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("error"), text, timeout);
        dialog.setVisible(true);
        destroyDialog(dialog, pane);
    }

    @Override
    public void showError(Component component, String text, Throwable th) {
        showError(component, text, th, defaultAutoCloseTimeout);
    }

    protected void showError(Component component, String text, Throwable th, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, errorIcon);
        pane.setOptions(okWithDetailsOptions);
        pane.setInitialValue(okWithDetailsOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("error"), text, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        destroyDialog(dialog, pane);
        if (okWithDetailsOptions[1].equals(selected)) {
            showException(component, th);
        }
    }

    @Override
    public void showException(Component component, Throwable th) {
        showException(component, th, defaultAutoCloseTimeout);
    }

    protected void showException(Component component, Throwable th, int timeout) {
        String message = constructStackTrace(th);
        JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, exceptionIcon);
        pane.setOptions(okOptions);
        pane.setInitialValue(okOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("exception"), message, timeout);
        dialog.setVisible(true);
        destroyDialog(dialog, pane);
    }

    @Override
    public boolean askConfirmation(Component component, String text) {
        return askConfirmation(component, text, defaultAutoCloseTimeout);
    }

    protected boolean askConfirmation(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, confirmationIcon);
        pane.setOptions(yesNoOptions);
        pane.setInitialValue(yesNoOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("confirmation"), timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        destroyDialog(dialog, pane);
        return yesNoOptions[0].equals(selected);
    }

    @Override
    public Boolean askConfirmationWithCancel(Component component, String text) {
        return askConfirmationWithCancel(component, text, defaultAutoCloseTimeout);
    }

    protected Boolean askConfirmationWithCancel(Component component, String text, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, confirmationIcon);
        pane.setOptions(yesNoCancelOptions);
        pane.setInitialValue(yesNoCancelOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("confirmation"), timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        destroyDialog(dialog, pane);
        if (yesNoCancelOptions[0].equals(selected)) {
            return Boolean.TRUE;
        } else if (yesNoCancelOptions[1].equals(selected)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public String askQuestion(Component component, String text) {
        return askQuestion(component, text, null, defaultAutoCloseTimeout);
    }

    public String askQuestion(Component component, String text, int timeout) {
        return askQuestion(component, text, null, timeout);
    }

    @Override
    public String askQuestion(Component component, String text, String answer) {
        return askQuestion(component, text, answer, defaultAutoCloseTimeout);
    }

    protected String askQuestion(Component component, String text, String answer, int timeout) {
        final JTextField answerField = new JTextField(10);
        if (answer != null) {
            answerField.setText(answer);
        }
        JOptionPane pane = new JOptionPane(new Object[] {text, answerField}, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, questionIcon);
        pane.setOptions(okCancelOptions);
        pane.setInitialValue(okCancelOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("question"), answerField, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        String result = null;
        if (okCancelOptions[0].equals(selected)) {
            result = answerField.getText();
        }
        destroyDialog(dialog, pane);
        return result;
    }

    @Override
    public Object askQuestion(Component component, String text, Object[] options, Object defaultOption) {
        return askQuestion(component, text, options, defaultOption, defaultAutoCloseTimeout);
    }

    protected Object askQuestion(Component component, String text, Object[] options, Object defaultOption, int timeout) {
        JOptionPane pane = new JOptionPane(text, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, questionIcon);
        pane.setOptions(okCancelOptions);
        pane.setInitialValue(okCancelOptions[0]);
        pane.setWantsInput(true);
        pane.setSelectionValues(options);
        pane.setInitialSelectionValue(defaultOption);
        JDialog dialog = createDialog(component, pane, bundle.getString("question"), timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        Object result = null;
        if (okCancelOptions[0].equals(selected)) {
            result = pane.getInputValue();
        }
        destroyDialog(dialog, pane);
        return result;
    }

    @Override
    public char[] askPassword(Component component, String text) {
        return askPassword(component, text, defaultAutoCloseTimeout);
    }

    protected char[] askPassword(Component component, String text, int timeout) {
        final JPasswordField pass = new JPasswordField(10);
        JOptionPane pane = new JOptionPane(new Object[] {text, pass}, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, passwordIcon);
        pane.setOptions(okCancelOptions);
        pane.setInitialValue(okCancelOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("password"), pass, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        char[] result = null;
        if (okCancelOptions[0].equals(selected)) {
            result = pass.getPassword();
        }
        destroyDialog(dialog, pane);
        return result;
    }

    @Override
    public LoginData askLogin(Component component, String text) {
        return askLogin(component, text, null, defaultAutoCloseTimeout);
    }

    protected LoginData askLogin(Component component, String text, int timeout) {
        return askLogin(component, text, null, timeout);
    }

    @Override
    public LoginData askLogin(Component component, String text, String username) {
        return askLogin(component, text, username, defaultAutoCloseTimeout);
    }

    protected LoginData askLogin(Component component, String text, String username, int timeout) {
        final JTextField name = new JTextField(10);
        final JPasswordField pass = new JPasswordField(10);
        JComponent focus = name;
        if (username != null) {
            name.setText(username);
            focus = pass;
        }
        Object[] content = new Object[] {text, bundle.getString("loginUsername"), name, bundle.getString("loginPassword"), pass};
        JOptionPane pane = new JOptionPane(content, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, loginIcon);
        pane.setOptions(loginExitOptions);
        pane.setInitialValue(loginExitOptions[0]);
        JDialog dialog = createDialog(component, pane, bundle.getString("login"), focus, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        LoginData result = null;
        if (loginExitOptions[0].equals(selected)) {
            result = new LoginData(name.getText(), pass.getPassword());
        }
        destroyDialog(dialog, pane);
        return result;
    }

    @Override
    public boolean showDialog(Component component, Component content, String title, Icon icon) {
        return showDialog(component, content, title, icon, defaultAutoCloseTimeout);
    }

    protected boolean showDialog(Component component, Component content, String title, Icon icon, int timeout) {
        JOptionPane pane = new JOptionPane(content, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, icon);
        pane.setOptions(okCancelOptions);
        pane.setInitialValue(okCancelOptions[0]);
        JDialog dialog = createDialog(component, pane, title, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        destroyDialog(dialog, pane);
        return okCancelOptions[0].equals(selected);
    }

    @Override
    public <T> T showDialog(Component component, DialogContent<T> content, String title, Icon icon) {
        return showDialog(component, content, title, icon, defaultAutoCloseTimeout);
    }

    protected <T> T showDialog(Component component, DialogContent<T> content, String title, Icon icon, int timeout) {
        JOptionPane pane = new JOptionPane(content.getContent(), JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, icon);
        pane.setOptions(okCancelOptions);
        pane.setInitialValue(okCancelOptions[0]);
        JDialog dialog = createDialog(component, pane, title, timeout);
        dialog.setVisible(true);
        Object selected = pane.getValue();
        T result = null;
        if (okCancelOptions[0].equals(selected)) {
            result = content.getValue();
        }
        destroyDialog(dialog, pane);
        return result;
    }

    public Icon getIcon(String type) {
        switch (type) {
        case "message":      return messageIcon;
        case "information":  return informationIcon;
        case "warning":      return warningIcon;
        case "error":        return errorIcon;
        case "confirmation": return confirmationIcon;
        case "question":     return questionIcon;
        case "password":     return passwordIcon;
        case "login":        return loginIcon;
        case "exception":    return exceptionIcon;
        default:             return null;
        }
    }

    /////////////////////////////////////
    // Dialog creation and destruction //
    /////////////////////////////////////

    protected JDialog createDialog(Component component, JOptionPane pane, String title, int timeout) {
        return createDialog(component, pane, title, null, null, timeout);
    }

    protected JDialog createDialog(Component component, JOptionPane pane, String title, JComponent focus, int timeout) {
        return createDialog(component, pane, title, focus, null, timeout);
    }

    protected JDialog createDialog(Component component, JOptionPane pane, String title, String text, int timeout) {
        return createDialog(component, pane, title, null, text, timeout);
    }

    protected JDialog createDialog(Component component, JOptionPane pane, String title, JComponent focus, String text, int timeout) {
        JDialog dialog = pane.createDialog(component, title);
        addAutoFocusSupport(dialog, pane, focus);
        addClipboardSupport(dialog, pane, clipboard, text);
        addAutoCloseSupport(dialog, pane, timeout);
        return dialog;
    }

    protected void destroyDialog(JDialog dialog, JOptionPane pane) {
        dialog.dispose();
    }

    protected void addAutoFocusSupport(JDialog dialog, JOptionPane pane, JComponent component) {
        if (component == null) {
            return;
        }
        dialog.addComponentListener(new DialogFocuser(component));
    }

    protected void addClipboardSupport(JDialog dialog, JOptionPane pane, Clipboard clipboard, String text) {
        if ((text == null) || (clipboard == null)) {
            return;
        }
        JRootPane rootPane = dialog.getRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("control C");
        Action actionListener = new CopyAction(clipboard, text);
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "control C");
        rootPane.getActionMap().put("control C", actionListener);
    }

    protected void addAutoCloseSupport(JDialog dialog, JOptionPane pane, int timeout) {
        if (timeout <= 0) {
            return;
        }
        JLabel timeoutLabel = new JLabel(timeoutIcon);
        timeoutLabel.setToolTipText(bundle.getString("timeoutTip"));
        try {
            JPanel buttonPanel = (JPanel) pane.getComponent(pane.getComponentCount() - 1);
            JPanel timeoutPanel = new JPanel(new BorderLayout());
            pane.remove(buttonPanel);
            timeoutPanel.add(timeoutLabel, BorderLayout.WEST);
            timeoutPanel.add(buttonPanel, BorderLayout.EAST);
            pane.add(timeoutPanel);
        } catch (RuntimeException e) {
            // We were unable to insert the label
        }
        dialog.addComponentListener(new DialogCloser(timeoutLabel, timeout));
    }

    ///////////////////////////////////
    // Stack trace formating support //
    ///////////////////////////////////

    protected boolean newStackTraceStyle = true;

    protected String constructStackTrace(Throwable t) {
        StringBuilder text = new StringBuilder();
        appendStackTrace(text, t);
        return text.toString();
    }

    protected void appendStackTrace(StringBuilder b, Throwable t) {
        appendThrowable(b, t, false);
        StackTraceElement[] stack = t.getStackTrace();
        for (StackTraceElement e : stack) {
            appendStackTraceElement(b, e);
        }
        Throwable cause = t.getCause();
        if (cause != null) {
            appendStackTraceAsCause(b, cause, stack);
        }
    }

    protected void appendStackTraceAsCause(StringBuilder b, Throwable t, StackTraceElement[] originalStack) {
        StackTraceElement[] stack = t.getStackTrace();
        int m = stack.length - 1;
        int n = originalStack.length - 1;
        while (m >= 0 && n >=0 && stack[m].equals(originalStack[n])) {
            m--;
            n--;
        }
        int common = stack.length - 1 - m;
        if (newStackTraceStyle) {
            b.append("\n");
        }
        appendThrowable(b, t, true);
        for (int i = 0; i <= m; i++) {
            appendStackTraceElement(b, stack[i]);
        }
        if (!newStackTraceStyle && (common != 0)) {
            b.append("    ");
            MessageFormat formatter = new MessageFormat(bundle.getString("stackTraceMore"), locale);
            b.append(formatter.format(new Object[]{new Integer(common)}));
            b.append('\n');
        }
        Throwable cause = t.getCause();
        if (cause != null) {
            appendStackTraceAsCause(b, cause, stack);
        }
    }

    protected void appendThrowable(StringBuilder b, Throwable t, boolean isCause) {
        if (!newStackTraceStyle && isCause) {
            b.append(bundle.getString("stackTraceCause"));
            b.append(' ');
        }
        b.append(t.getClass().getName());
        String message = t.getLocalizedMessage();
        if (message != null) {
            b.append(": ");
            b.append(message);
        }
        b.append('\n');
    }

    protected void appendStackTraceElement(StringBuilder b, StackTraceElement e) {
        b.append("    ");
        b.append(e.getClassName());
        b.append('.');
        b.append(e.getMethodName());
        b.append(' ');
        b.append('(');
        if (e.isNativeMethod()) {
            b.append(bundle.getString("stackTraceNative"));
        } else if (e.getFileName() == null) {
            b.append(bundle.getString("stackTraceUnknown"));
        } else {
            b.append(e.getFileName());
            if (e.getLineNumber() >= 0) {
                b.append(":");
                b.append(e.getLineNumber());

            }
        }
        b.append(')');
        b.append('\n');
    }

    ////////////////////////
    // Auto focus support //
    ////////////////////////

    protected class DialogFocuser extends ComponentAdapter {

        private JComponent component;

        /**
         * Creates a new {@code DialogFocuser}.
         *
         * @param component
         *            the component to focus
         */
        public DialogFocuser(JComponent component) {
            this.component = component;
        }

        @Override
        public void componentShown(ComponentEvent e){
            component.requestFocusInWindow();
        }
    }

    ///////////////////////
    // Clipboard support //
    ///////////////////////

    protected static class CopyAction extends AbstractAction {

        private static final long serialVersionUID = -4801750428972294229L;

        private Clipboard clipboard;
        private String text;

        public CopyAction(Clipboard clipboard, String text) {
            this.clipboard = clipboard;
            this.text = text;
        }

        public void actionPerformed(ActionEvent e) {
            copyStringToClipboard(clipboard, text);
        }
    }

    protected static void copyStringToClipboard(Clipboard clipboard, String text) {
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
    }

    protected static String copyStringFromClipboard(Clipboard clipboard) {

        // Try to copy content from clipboard
        try {
            Transferable t = clipboard.getContents(null);
            return (String) t.getTransferData(DataFlavor.stringFlavor);

        // Clipboard is empty
        } catch (NullPointerException ex) {
            return null;

        // Clipboard is not currently available
        } catch (IllegalStateException ex) {
            return null;

        // It is not a string
        } catch (UnsupportedFlavorException ex) {
            return null;

        // Contents is not accessible anymore
        } catch (IOException ex) {
            return null;
        }

    }

    ////////////////////////
    // Auto close support //
    ////////////////////////

    protected class DialogCloser extends ComponentAdapter implements ActionListener, AWTEventListener {

        private static final int resolution = 500;

        private MessageFormat formatter;

        private JLabel label;
        private long timeout;
        private Component component;
        private Timer timer;

        /**
         * Creates a new {@code DialogCloser}.
         *
         * @param label
         *            the label used to show the remaining time
         * @param timeout
         *            the closing timeout in milliseconds
         */
        public DialogCloser(JLabel label, long timeout) {
            this.label = label;
            this.timeout = timeout;
            formatter = new MessageFormat(bundle.getString("timeout"), locale);
        }

        @Override
        public void componentShown(ComponentEvent e){
            timeout = timeout + System.currentTimeMillis();
            component = e.getComponent();
            timer = new Timer(resolution, this);
            timer.setInitialDelay(0);
            long eventMask = AWTEvent.MOUSE_EVENT_MASK + AWTEvent.KEY_EVENT_MASK;
            Toolkit.getDefaultToolkit().addAWTEventListener(this, eventMask);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long time = timeout - System.currentTimeMillis();
            if (time > resolution) {
                label.setText(formatter.format(new Object[]{new Long(time / 1000)}));
            } else {
                component.setVisible(false);
            }
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            abort();
        }

        @Override
        public void eventDispatched(AWTEvent event) {
            switch (event.getID()) {
            case MouseEvent.MOUSE_PRESSED:
            // case MouseEvent.MOUSE_RELEASED:
            case KeyEvent.KEY_PRESSED:
            // case KeyEvent.KEY_RELEASED:
                Component c = event.getSource() instanceof Component ? ((Component) event.getSource()) : null;
                if (component == SwingUtilities.getRoot(c)) {
                    abort();
                }
                break;
            default:
            }
        }

        private void abort() {
            timer.stop();
            label.setVisible(false);
            Toolkit.getDefaultToolkit().removeAWTEventListener(this);
        }
    }
}
