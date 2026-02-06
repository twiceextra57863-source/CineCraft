package com.yourname.cinecraft.ui.widgets;

public class TimelineBar {

    private int position = 0;
    private int length = 1000;

    public void setPosition(int pos){ position = Math.max(0, Math.min(pos, length)); }
    public int getPosition(){ return position; }

    public void render(){
        System.out.println("[Widget] TimelineBar at "+position+"/"+length);
    }
}
