package com.yourname.cinecraft.ui;

import com.yourname.cinecraft.assetsys.AssetManager;

public class AssetBrowserScreen {

    public void render(){
        System.out.println("[UI] Asset Browser Models: "+AssetManager.getModels());
        System.out.println("[UI] Asset Browser Textures: "+AssetManager.getTextures());
        System.out.println("[UI] Asset Browser Particles: "+AssetManager.getParticles());
        System.out.println("[UI] Asset Browser Animations: "+AssetManager.getAnimations());
    }
}
