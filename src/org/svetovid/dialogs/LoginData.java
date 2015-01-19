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
