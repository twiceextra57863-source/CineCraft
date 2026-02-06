package com.yourname.cinecraft.rendering;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Loads shader files
 */
public class ShaderLoader {

    public static String loadShader(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
