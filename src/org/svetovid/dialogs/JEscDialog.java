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

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 * Extends the dialog window as defined by Swing adding the possibility to close
 * the dialog using the ESC key. The ESC key can be associated with an action
 * that disposes the dialog or with an action that just hides the dialog.
 *
 * @author Riccardo Govoni
 * @author Ivan Pribela
 * @version 1.1
 */
public class JEscDialog extends JDialog {

    private static final long serialVersionUID = -1721124925325872793L;

    /**
     * Creates a new dialog window.
     *
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(boolean disposeOnEsc) throws HeadlessException {
        super();
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Dialog owner, boolean disposeOnEsc) throws HeadlessException {
        super(owner);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param modal
     *            {@code true} for a modal dialog, {@code false} for one that
     *            allows other windows to be active at the same time
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Dialog owner, boolean modal, boolean disposeOnEsc) throws HeadlessException {
        super(owner, modal);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Frame owner, boolean disposeOnEsc) throws HeadlessException {
        super(owner);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param modal
     *            {@code true} for a modal dialog, {@code false} for one that
     *            allows other windows to be active at the same time
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Frame owner, boolean modal, boolean disposeOnEsc) throws HeadlessException {
        super(owner, modal);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param title
     *            the dialog title
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Dialog owner, String title, boolean disposeOnEsc) throws HeadlessException {
        super(owner, title);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param title
     *            the dialog title
     * @param modal
     *            {@code true} for a modal dialog, {@code false} for one that
     *            allows other windows to be active at the same time
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Dialog owner, String title, boolean modal, boolean disposeOnEsc) throws HeadlessException {
        super(owner, title, modal);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param title
     *            the dialog title
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Frame owner, String title,boolean disposeOnEsc) throws HeadlessException {
        super(owner, title);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Creates a new dialog window.
     *
     * @param owner
     *            the dialog owner
     * @param title
     *            the dialog title
     * @param modal
     *            {@code true} for a modal dialog, {@code false} for one that
     *            allows other windows to be active at the same time
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     *
     * @throws java.awt.HeadlessException
     *             if {@code GraphicsEnvironment.isHeadless()} returns
     *             {@code true}.
     */
    public JEscDialog(Frame owner, String title, boolean modal, boolean disposeOnEsc) throws HeadlessException {
        super(owner, title, modal);
        addEscSupport(disposeOnEsc);
    }

    /**
     * Attaches the correct action to the dialog, triggered when ESC is pressed.
     *
     * @param disposeOnEsc
     *            {@code true} if the dialog is to be disposed when ESC is
     *            pressed, {@code false} if the dialog should just become
     *            invisible.
     */
    private void addEscSupport(boolean disposeOnEsc) {
        JRootPane rootPane = this.getRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action actionListener = null;
        if (disposeOnEsc) {
            actionListener = new DisposeAction(this);
        } else {
            actionListener = new HideAction(this);
        }
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke,"ESCAPE");
        rootPane.getActionMap().put("ESCAPE",actionListener);
    }

    /**
     * An Action that disposes the dialog when triggered.
     */
    public class DisposeAction extends AbstractAction {

        private static final long serialVersionUID = 2068217109423356542L;

        private JDialog dialog;

        /**
         * Constructs a new {@code DisposeAction}.
         *
         * @param dialog
         *            the dialog to dispose
         */
        public DisposeAction(JDialog dialog) {
            this.dialog = dialog;
        }

        public void actionPerformed(ActionEvent ae) {
            dialog.dispose();
        }
    }

    /**
     * An Action that hides the dialog when triggered.
     */
    public class HideAction extends AbstractAction {

        private static final long serialVersionUID = 8286747232328074129L;

        private JDialog dialog;

        /**
         * Constructs a new {@code HideAction}.
         *
         * @param dialog
         *            the dialog to hide
         */
        public HideAction(JDialog dialog) {
            this.dialog = dialog;
        }

        public void actionPerformed(ActionEvent ae) {
            dialog.setVisible(false);
        }
    }
}
