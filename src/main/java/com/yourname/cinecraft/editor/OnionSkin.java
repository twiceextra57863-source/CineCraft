package com.yourname.cinecraft.editor;

import java.util.ArrayList;
import java.util.List;

/**
 * Onion skin preview for animation
 */
public class OnionSkin {

    private final List<Integer> frames = new ArrayList<>();

    public void addFrame(int frameNumber){ frames.add(frameNumber); }
    public List<Integer> getFrames(){ return frames; }

    public void clear(){ frames.clear(); }

    public void renderPreview(){
        System.out.println("[OnionSkin] Rendering frames: "+frames);
    }
}
