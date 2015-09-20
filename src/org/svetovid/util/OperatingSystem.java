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

package org.svetovid.util;

public enum OperatingSystem {

    WINDOWS_3_1       (OperatingSystemFamily.WINDOWS, "Windows 3.1"),
    WINDOWS_NT_3_51   (OperatingSystemFamily.WINDOWS, "Windows 3.5"),
    WINDOWS_NT_4_0    (OperatingSystemFamily.WINDOWS, "Windows NT 4.0"),
    WINDOWS_95        (OperatingSystemFamily.WINDOWS, "Windows 95"),
    WINDOWS_98        (OperatingSystemFamily.WINDOWS, "Windows 98"),
    WINDOWS_ME        (OperatingSystemFamily.WINDOWS, "Windows Me"),
    WINDOWS_9X        (OperatingSystemFamily.WINDOWS, "Windows 9X (unknown)"),
    WINDOWS_NT        (OperatingSystemFamily.WINDOWS, "Windows NT", "Windows NT (unknown)"),
    WINDOWS_2000      (OperatingSystemFamily.WINDOWS, "Windows 2000"),
    WINDOWS_XP        (OperatingSystemFamily.WINDOWS, "Windows XP"),
    WINDOWS_2003      (OperatingSystemFamily.WINDOWS, "Windows 2003"),
    WINDOWS_VISTA     (OperatingSystemFamily.WINDOWS, "Windows Vista"),
    WINDOWS_7         (OperatingSystemFamily.WINDOWS, "Windows 7"),
    WINDOWS_2008      (OperatingSystemFamily.WINDOWS, "Windows Server 2008", "Windows Server 2008 R2"),
    WINDOWS_8         (OperatingSystemFamily.WINDOWS, "Windows 8", "Windows 8.1"),
    WINDOWS_2012      (OperatingSystemFamily.WINDOWS, "Windows Server 2012", "Windows Server 2012 R2"),
    WINDOWS_10        (OperatingSystemFamily.WINDOWS, "Windows 10"),
    WINDOWS           (OperatingSystemFamily.WINDOWS, "Windows", "Windows (unknown)"),
    MAC_OS_X          (OperatingSystemFamily.MAC,     "Mac OS X"),
    MAC               (OperatingSystemFamily.MAC,     "Mac OS"),
    SUN_OS            (OperatingSystemFamily.UNIX,    "SunOS"),
    SOLARIS           (OperatingSystemFamily.UNIX,    "Solaris"),
    LINUX             (OperatingSystemFamily.UNIX,    "Linux"),
    FREE_BSD          (OperatingSystemFamily.UNIX,    "FreeBSD"),
    HP_UX             (OperatingSystemFamily.UNIX,    "HP-UX"),
    HP_MPE_IX         (OperatingSystemFamily.UNIX,    "MPE/iX"),
    HP_TRU64_UNIX     (OperatingSystemFamily.UNIX,    "Digital UNIX", "Tru64 Uni"),
    IBM_AIX           (OperatingSystemFamily.UNIX,    "AIX"),
    IBM_OS390         (OperatingSystemFamily.UNIX,    "OS/390"),
    OSF1              (OperatingSystemFamily.UNIX,    "OSF1", "OSF/1"),
    SGI_IRIX          (OperatingSystemFamily.UNIX,    "Irix"),
    UNIX              (OperatingSystemFamily.UNIX,    "Unix"),
    NETWARE_4_11      (OperatingSystemFamily.OTHER,   "NetWare 4.11"),
    NETWARE           (OperatingSystemFamily.OTHER,   "NetWare"),
    HP_OPEN_VMS       (OperatingSystemFamily.OTHER,   "OpenVMS"),
    IBM_OS2           (OperatingSystemFamily.OTHER,   "OS/2"),
    UNKNOWN           (OperatingSystemFamily.OTHER,   "Unknown");

    public static final OperatingSystem CURRENT = forName(System.getProperty("os.name"));

    private final OperatingSystemFamily family;
    private final String names[];

    private OperatingSystem(OperatingSystemFamily family, String... names){
        this.family = family;
        this.names = names;
    }

    public String getName() {
        return names[0];
    }

    public OperatingSystemFamily getFamily() {
        return family;
    }

    public static OperatingSystem forName(String name){
        name = name.toLowerCase();
        for (OperatingSystem os : values()) {
            for (String n : os.names) {
                if (name.contains(n.toLowerCase()))
                    return os;
            }
        }
        return UNKNOWN;
    }
}
