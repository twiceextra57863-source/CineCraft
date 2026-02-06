package com.yourname.cinecraft.editor;

/**
 * Represents translation/rotation/scale gizmo
 */
public class Gizmo {

    public enum Mode { MOVE, ROTATE, SCALE }
    private Mode mode = Mode.MOVE;

    public void setMode(Mode mode) { this.mode = mode; }
    public Mode getMode() { return mode; }

    public void manipulate(double dx, double dy, double dz){
        System.out.println("[Gizmo] Applied "+mode+" delta: "+dx+","+dy+","+dz);
    }
}
