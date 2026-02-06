package com.yourname.cinecraft.timeline.tracks;

import com.yourname.cinecraft.animation.ActorEntity;
import com.yourname.cinecraft.timeline.Track;

public class ActorTrack extends Track {

    private final ActorEntity actor;

    public ActorTrack(String name, ActorEntity actor) {
        super(name);
        this.actor = actor;
        // TODO: Set length based on actor animation frames
        this.length = 100;
    }

    @Override
    public void applyFrame(int frame) {
        // TODO: Apply actor animation for this frame
    }
}
