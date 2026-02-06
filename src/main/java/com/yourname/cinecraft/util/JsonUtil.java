package com.yourname.cinecraft.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonUtil {

    public static String readJson(File file){
        try { return Files.readString(file.toPath()); }
        catch(IOException e){ e.printStackTrace(); return ""; }
    }
}
