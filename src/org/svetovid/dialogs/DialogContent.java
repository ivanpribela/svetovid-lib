package org.svetovid.dialogs;

/**
 * This is an interface for objects that can be used as content in dialogs. This
 * interface provides a method for retrieving the content component and a method
 * for retrieving user selected value to return when the dialog is closed.
 * 
 * @author Ivan Pribela
 * @version 1.0
 */
public interface DialogContent<T> {

    public Object getContent();

    public T getValue();

}
