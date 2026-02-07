package com.yourname.cinecraft.assetsys;

import com.yourname.cinecraft.util.FileUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads textures for CineCraft
 * Supports:
 * - PNG / JPG / BMP
 * - Caching for fast reuse
 * - Integration with ModelRenderer / CineCamera
 */
public class TextureLoader {

    // Cache of loaded textures
    private static Map<String, BufferedImage> textureCache = new HashMap<>();

    /**
     * Load texture by file
     * @param file - texture file
     * @return BufferedImage object
     */
    public static BufferedImage load(File file){
        String fileName = file.getName();

        // Return from cache if already loaded
        if(textureCache.containsKey(fileName)) return textureCache.get(fileName);

        try {
            BufferedImage img = ImageIO.read(file);
            if(img == null){
                System.err.println("[TextureLoader] Failed to load texture: "+fileName);
                return null;
            }

            // Cache texture
            textureCache.put(fileName, img);
            System.out.println("[TextureLoader] Loaded texture: "+fileName);
            return img;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get cached texture by name
     * @param name - file name
     */
    public static BufferedImage get(String name){
        return textureCache.get(name);
    }

    /**
     * Clear texture cache
     */
    public static void clearCache(){
        textureCache.clear();
    }
}
