package com.yourname.cinecraft.assetsys.formats;

import java.io.File;

/**
 * Minimal GLTF loader placeholder
 * You can extend with a full GLTF parsing library if needed
 */
public class GltfModel {

    public String name;

    public static GltfModel load(File file){
        GltfModel model = new GltfModel();
        model.name = file.getName();
        System.out.println("[GltfModel] Loaded GLTF: "+model.name);
        // TODO: integrate with tinygltf / custom parser
        return model;
    }
}
