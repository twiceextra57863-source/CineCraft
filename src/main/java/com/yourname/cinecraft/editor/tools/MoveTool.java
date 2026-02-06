package com.yourname.cinecraft.editor.tools;

import com.yourname.cinecraft.editor.Gizmo;

public class MoveTool {

    private final Gizmo gizmo;

    public MoveTool(Gizmo gizmo) { this.gizmo = gizmo; }

    public void move(double dx, double dy, double dz){
        gizmo.setMode(Gizmo.Mode.MOVE);
        gizmo.manipulate(dx, dy, dz);
    }
}
