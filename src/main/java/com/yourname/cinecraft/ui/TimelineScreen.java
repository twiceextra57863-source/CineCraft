package com.yourname.cinecraft.ui;

import com.yourname.cinecraft.timeline.Timeline;

public class TimelineScreen {

    private final Timeline timeline;

    public TimelineScreen(Timeline timeline){
        this.timeline = timeline;
        System.out.println("[UI] TimelineScreen loaded for: "+timeline.getName());
    }

    public void render(){
        System.out.println("[UI] Rendering Timeline with "+timeline.getTracks().size()+" tracks");
    }

    public void play(){
        System.out.println("[UI] Playing Timeline");
    }

    public void stop(){
        System.out.println("[UI] Stopped Timeline");
    }
}
