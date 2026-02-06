package com.yourname.cinecraft.editor.tools;

import com.yourname.cinecraft.editor.Gizmo;

public class RotateTool {

    private final Gizmo gizmo;

    public RotateTool(Gizmo gizmo) { this.gizmo = gizmo; }

    public void rotate(float pitch, float yaw, float roll){
        gizmo.setMode(Gizmo.Mode.ROTATE);
        gizmo.manipulate(pitch, yaw, roll);
    }
}
