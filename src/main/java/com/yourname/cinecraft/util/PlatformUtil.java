package com.yourname.cinecraft.util;

public class PlatformUtil {

    private static final String OS =
            System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isLinux() {
        return OS.contains("nux") || OS.contains("linux");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isAndroid() {
        // PojavLauncher detection
        return System.getProperty("java.vendor", "")
                .toLowerCase()
                .contains("android");
    }
}
