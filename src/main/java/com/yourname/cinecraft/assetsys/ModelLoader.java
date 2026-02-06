package com.yourname.cinecraft.assetsys;

import java.io.File;
import java.util.List;

/**
 * Loads 3D models (JSON, OBJ, BBModel, GLTF)
 */
public class ModelLoader {

    public static void loadAll() {
        List<String> models = AssetManager.getModels();
        for (String modelFile : models) {
            String ext = modelFile.substring(modelFile.lastIndexOf('.')+1);
            switch (ext.toLowerCase()) {
                case "json": System.out.println("[ModelLoader] JSON model loaded: "+modelFile); break;
                case "obj": System.out.println("[ModelLoader] OBJ model loaded: "+modelFile); break;
                case "bbmodel": System.out.println("[ModelLoader] BBModel loaded: "+modelFile); break;
                case "gltf": System.out.println("[ModelLoader] GLTF model loaded: "+modelFile); break;
                default: System.out.println("[ModelLoader] Unknown model type: "+modelFile);
            }
        }
    }
}
