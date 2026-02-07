package com.yourname.cinecraft.animation;

import java.util.HashMap;
import java.util.Map;

/**
 * Rig stores all bones of an actor
 */
public class Rig implements Cloneable {

    private Map<String, Bone> bones;

    public Rig(){
        bones = new HashMap<>();
    }

    public void addBone(Bone bone){ bones.put(bone.getName(), bone); }
    public Bone getBone(String name){ return bones.get(name); }

    public Map<String, Bone> getBones(){ return bones; }

    @Override
    public Rig clone(){
        Rig r = new Rig();
        for(String k : bones.keySet()){
            r.addBone(bones.get(k).clone());
        }
        return r;
    }
}
