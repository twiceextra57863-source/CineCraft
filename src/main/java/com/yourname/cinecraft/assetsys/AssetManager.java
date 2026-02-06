package com.yourname.cinecraft.assetsys;

import java.io.File;

public class AssetManager {

    public static void init() {
        System.out.println("[CineCraft] Asset Manager initialized!");
        loadAssets();
    }

    private static void loadAssets() {
        File assetFolder = new File("./minecraft/cinecraft/");
        if (!assetFolder.exists()) {
            assetFolder.mkdirs();
            System.out.println("[CineCraft] Created user asset folder at ./minecraft/cinecraft/");
        } else {
            System.out.println("[CineCraft] User asset folder found.");
        }

        // TODO: Scan models, textures, particles, animations
    }
}
