package com.yourname.cinecraft.util;

import java.io.File;

public class FileUtil {

    public static boolean ensureDir(String path){
        File f = new File(path);
        if(!f.exists()) return f.mkdirs();
        return true;
    }

    public static String getExtension(String filename){
        int idx = filename.lastIndexOf('.');
        return idx >= 0 ? filename.substring(idx+1) : "";
    }
}
