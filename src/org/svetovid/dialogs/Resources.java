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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This is helper class which contains methods to easily access resources.
 *
 * @author Ivan Pribela
 * @version 1.0
 */
public class Resources {

    //----------------------//
    // Icon cache subsystem //
    //----------------------//

    /**
     * Map used to cache icons in application.
     */
    private static Map<String, Icon> icons = new HashMap<String, Icon>();

    /**
     * Returns icon from the resource named {@code name}. Icon is cached in
     * internal map for faster access.
     *
     * @param name
     *            name of the icon to be retrieved
     * @return icon associated with specified name
     */
    public static Icon getIcon(String name) {
        Icon icon = icons.get(name);
        if (icon == null) {
            URL url = Resources.class.getClassLoader().getResource("images/" + name + ".png");
            icon = new ImageIcon(url);
            icons.put(name, icon);
        }
        return icon;
    }
}
