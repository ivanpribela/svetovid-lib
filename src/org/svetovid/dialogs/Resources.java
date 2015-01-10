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
