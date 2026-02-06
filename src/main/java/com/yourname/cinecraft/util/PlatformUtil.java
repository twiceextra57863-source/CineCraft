package com.yourname.cinecraft.util;

public class PlatformUtil {

    public static boolean isAndroid(){
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("android");
    }

    public static boolean isDesktop(){ return !isAndroid(); }
}
