package com.yourname.cinecraft.assetsys;

import com.yourname.cinecraft.animation.*;
import com.yourname.cinecraft.util.JsonUtil;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Loads .anim preset files into AnimationClip objects
 */
public class AnimationLoader {

    /**
     * Load an animation clip from a .anim JSON file
     * @param file - .anim file
     * @return AnimationClip object
     */
    public static AnimationClip load(File file){
        try(FileReader reader = new FileReader(file)){
            JSONObject obj = JsonUtil.parse(reader);
            String name = obj.getString("name");
            int lengthTicks = obj.getInt("lengthTicks");
            AnimationClip clip = new AnimationClip(name, lengthTicks);

            JSONArray keyframes = obj.getJSONArray("keyframes");
            for(int i=0;i<keyframes.length();i++){
                JSONObject kfObj = keyframes.getJSONObject(i);

                int tick = kfObj.getInt("tick");
                JSONObject posObj = kfObj.getJSONObject("position");
                double x = posObj.getDouble("x");
                double y = posObj.getDouble("y");
                double z = posObj.getDouble("z");

                JSONObject rotObj = kfObj.getJSONObject("rotation");
                double yaw = rotObj.getDouble("yaw");
                double pitch = rotObj.getDouble("pitch");

                Rig rig = new Rig();
                JSONObject rigObj = kfObj.getJSONObject("rig").getJSONObject("bones");

                Iterator<String> bonesIter = rigObj.keys();
                while(bonesIter.hasNext()){
                    String boneName = bonesIter.next();
                    JSONObject b = rigObj.getJSONObject(boneName);

                    Bone bone = new Bone(boneName);
                    bone.setPosition(b.getDouble("x"), b.getDouble("y"), b.getDouble("z"));
                    bone.setRotation(b.getDouble("rotX"), b.getDouble("rotY"), b.getDouble("rotZ"));

                    rig.addBone(bone);
                }

                Keyframe keyframe = new Keyframe(tick, x, y, z, yaw, pitch, rig);
                clip.addKeyframe(keyframe);
            }

            return clip;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
