package org.svetovid.dialogs;

/**
 * Class that holds user name and password.
 * 
 * @author Ivan Pribela
 * @version 1.3
 */
public class LoginData {

    /**
     * User name.
     */
    public final String name;

    /**
     * User password.
     */
    public final char [] password;

    /**
     * Creates a new object that holds specified user name and password.
     * 
     * @param name user name.
     * @param password password.
     */
    public LoginData(String name, char [] password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Utility method that wipes the stored password.
     */
    public void clearPassword() {
        if (password != null){
            for (int i = 0; i < password.length; i++) {
                password[i] = 0;
            }
        }
    }
}
