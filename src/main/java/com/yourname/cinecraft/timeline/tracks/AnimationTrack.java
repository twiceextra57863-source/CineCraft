package com.cinecraft.animation.timeline;

import com.cinecraft.animation.Keyframe;
import com.cinecraft.animation.Clip;
import com.cinecraft.animation.Animator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * AnimationTrack represents a single animation layer on a timeline.
 * It can control one Clip, evaluate keyframes, and apply animation
 * data to an Animator.
 *
 * Java 21 compatible – no deprecated APIs.
 */
public class AnimationTrack {

    /* =========================
       Core Track Properties
       ========================= */

    private final String name;
    private Clip clip;

    private double startTime;      // seconds
    private double duration;       // seconds
    private double speed = 1.0;

    private boolean loop;
    private boolean enabled = true;

    /* =========================
       Playback State
       ========================= */

    private double localTime;
    private boolean finished;

    /* =========================
       Keyframes
       ========================= */

    private final List<Keyframe> keyframes = new CopyOnWriteArrayList<>();

    /* =========================
       Blending & Weight
       ========================= */

    private float weight = 1.0f;
    private float blendIn = 0.0f;
    private float blendOut = 0.0f;

    /* =========================
       Constructors
       ========================= */

    public AnimationTrack(String name) {
        this.name = name;
    }

    public AnimationTrack(String name, Clip clip) {
        this.name = name;
        setClip(clip);
    }

    /* =========================
       Clip Handling
       ========================= */

    public void setClip(Clip clip) {
        this.clip = clip;
        this.duration = clip != null ? clip.getDuration() : 0.0;
        this.localTime = 0.0;
        this.finished = false;

        keyframes.clear();
        if (clip != null) {
            keyframes.addAll(clip.getKeyframes());
            keyframes.sort(Comparator.comparingDouble(Keyframe::time));
        }
    }

    public Clip getClip() {
        return clip;
    }

    /* =========================
       Update Logic
       ========================= */

    public void update(double deltaTime, Animator animator, double globalTime) {
        if (!enabled || clip == null || finished) return;

        if (globalTime < startTime) return;

        localTime += deltaTime * speed;

        if (localTime > duration) {
            if (loop) {
                localTime %= duration;
            } else {
                localTime = duration;
                finished = true;
            }
        }

        applyAnimation(animator);
    }

    /* =========================
       Animation Evaluation
       ========================= */

    private void applyAnimation(Animator animator) {
        if (keyframes.isEmpty()) return;

        Keyframe prev = null;
        Keyframe next = null;

        for (Keyframe kf : keyframes) {
            if (kf.time() <= localTime) {
                prev = kf;
            } else {
                next = kf;
                break;
            }
        }

        if (prev == null) return;

        if (next == null) {
            animator.applyPose(prev.pose(), computeWeight());
            return;
        }

        double t = (localTime - prev.time()) / (next.time() - prev.time());
        t = Math.clamp(t, 0.0, 1.0);

        animator.applyBlendedPose(
                prev.pose(),
                next.pose(),
                (float) t,
                computeWeight()
        );
    }

    /* =========================
       Weight & Blending
       ========================= */

    private float computeWeight() {
        float w = weight;

        if (blendIn > 0 && localTime < blendIn) {
            w *= (float) (localTime / blendIn);
        }

        if (blendOut > 0 && localTime > duration - blendOut) {
            w *= (float) ((duration - localTime) / blendOut);
        }

        return Math.clamp(w, 0f, 1f);
    }

    /* =========================
       Keyframe Management
       ========================= */

    public void addKeyframe(Keyframe keyframe) {
        keyframes.add(keyframe);
        keyframes.sort(Comparator.comparingDouble(Keyframe::time));
        duration = Math.max(duration, keyframe.time());
    }

    public void removeKeyframe(Keyframe keyframe) {
        keyframes.remove(keyframe);
    }

    public List<Keyframe> getKeyframes() {
        return Collections.unmodifiableList(keyframes);
    }

    /* =========================
       Playback Controls
       ========================= */

    public void reset() {
        localTime = 0.0;
        finished = false;
    }

    public void stop() {
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    /* =========================
       Getters & Setters
       ========================= */

    public String getName() {
        return name;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = Math.max(0, startTime);
    }

    public double getDuration() {
        return duration;
    }

    public void setSpeed(double speed) {
        this.speed = Math.max(0.01, speed);
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isLooping() {
        return loop;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setWeight(float weight) {
        this.weight = Math.clamp(weight, 0f, 1f);
    }

    public void setBlendIn(float seconds) {
        this.blendIn = Math.max(0, seconds);
    }

    public void setBlendOut(float seconds) {
        this.blendOut = Math.max(0, seconds);
    }

    /* =========================
       Debug
       ========================= */

    @Override
    public String toString() {
        return "AnimationTrack{" +
                "name='" + name + '\'' +
                ", clip=" + (clip != null ? clip.getName() : "null") +
                ", duration=" + duration +
                ", loop=" + loop +
                ", weight=" + weight +
                '}';
    }
}
