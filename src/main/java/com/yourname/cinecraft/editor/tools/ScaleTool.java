package com.yourname.cinecraft.editor.tools;

import com.yourname.cinecraft.editor.Gizmo;

public class ScaleTool {

    private final Gizmo gizmo;

    public ScaleTool(Gizmo gizmo) { this.gizmo = gizmo; }

    public void scale(double sx, double sy, double sz){
        gizmo.setMode(Gizmo.Mode.SCALE);
        gizmo.manipulate(sx, sy, sz);
    }
}
