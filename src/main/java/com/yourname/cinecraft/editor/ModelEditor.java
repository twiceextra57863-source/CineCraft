package com.yourname.cinecraft.editor;

import com.yourname.cinecraft.animation.ActorEntity;
import com.yourname.cinecraft.assetsys.AssetManager;
import java.util.List;

/**
 * Model Editor for adjusting bones, position, rotation
 */
public class ModelEditor {

    private ActorEntity currentActor;

    public void loadActor(ActorEntity actor) {
        this.currentActor = actor;
        System.out.println("[Editor] Loaded actor: "+actor.getName());
    }

    public void selectBone(String boneName) {
        System.out.println("[Editor] Selected bone: "+boneName);
    }

    public void applyTransform(String boneName, double x, double y, double z, float pitch, float yaw, float roll){
        System.out.println("[Editor] Applied transform to bone "+boneName);
        // TODO: Apply transform to actor's bone
    }

    public void importModel(String modelName){
        List<String> models = AssetManager.getModels();
        if(models.contains(modelName)) System.out.println("[Editor] Imported model: "+modelName);
        else System.out.println("[Editor] Model not found: "+modelName);
    }

    public void saveActor(String path){
        System.out.println("[Editor] Saved actor to: "+path);
    }
}
