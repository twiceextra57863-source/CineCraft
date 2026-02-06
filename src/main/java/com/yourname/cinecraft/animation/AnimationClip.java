package com.yourname.cinecraft.animation;

import java.util.ArrayList;
import java.util.List;

public class AnimationClip {
    private final String name;
    private final List<Keyframe> keyframes = new ArrayList<>();

    public AnimationClip(String name) { this.name = name; }

    public void addKeyframe(Keyframe kf) { keyframes.add(kf); }
    public List<Keyframe> getKeyframes() { return keyframes; }
    public String getName() { return name; }
}
