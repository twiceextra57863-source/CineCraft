package com.yourname.cinecraft.assetsys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages all user assets (models, textures, particles, animations)
 */
public class AssetManager {

    public static final String ASSET_FOLDER = "./minecraft/cinecraft/";
    private static final List<String> models = new ArrayList<>();
    private static final List<String> textures = new ArrayList<>();
    private static final List<String> particles = new ArrayList<>();
    private static final List<String> animations = new ArrayList<>();

    public static void init() {
        System.out.println("[CineCraft] Asset Manager initialized!");
        loadAssets();
    }

    private static void loadAssets() {
        File folder = new File(ASSET_FOLDER);
        if (!folder.exists()) folder.mkdirs();

        // Scan models
        File modelsDir = new File(folder, "models");
        if (!modelsDir.exists()) modelsDir.mkdirs();
        for (File f : modelsDir.listFiles()) if (f.isFile()) models.add(f.getName());

        // Scan textures
        File texturesDir = new File(folder, "textures");
        if (!texturesDir.exists()) texturesDir.mkdirs();
        for (File f : texturesDir.listFiles()) if (f.isFile()) textures.add(f.getName());

        // Scan particles
        File particlesDir = new File(folder, "particles");
        if (!particlesDir.exists()) particlesDir.mkdirs();
        for (File f : particlesDir.listFiles()) if (f.isFile()) particles.add(f.getName());

        // Scan animations
        File animDir = new File(folder, "animations");
        if (!animDir.exists()) animDir.mkdirs();
        for (File f : animDir.listFiles()) if (f.isFile()) animations.add(f.getName());

        System.out.println("[CineCraft] Models: " + models);
        System.out.println("[CineCraft] Textures: " + textures);
        System.out.println("[CineCraft] Particles: " + particles);
        System.out.println("[CineCraft] Animations: " + animations);
    }

    public static List<String> getModels() { return models; }
    public static List<String> getTextures() { return textures; }
    public static List<String> getParticles() { return particles; }
    public static List<String> getAnimations() { return animations; }
}
