package com.yourname.cinecraft.ui;

import com.yourname.cinecraft.editor.ModelEditor;
import com.yourname.cinecraft.editor.Gizmo;
import com.yourname.cinecraft.editor.tools.MoveTool;
import com.yourname.cinecraft.editor.tools.RotateTool;
import com.yourname.cinecraft.editor.tools.ScaleTool;

import java.awt.image.BufferedImage;

/**
 * Full Model Editor UI
 */
public class ModelEditorScreen {

    private final ModelEditor editor;
    private final Gizmo gizmo;
    private final MoveTool moveTool;
    private final RotateTool rotateTool;
    private final ScaleTool scaleTool;

    public ModelEditorScreen(){
        this.editor = new ModelEditor();
        this.gizmo = new Gizmo();
        this.moveTool = new MoveTool(gizmo);
        this.rotateTool = new RotateTool(gizmo);
        this.scaleTool = new ScaleTool(gizmo);
    }

    public void render(){
        System.out.println("[UI] Rendering Model Editor");
    }

    public void move(double dx,double dy,double dz){ moveTool.move(dx,dy,dz);}
    public void rotate(float pitch,float yaw,float roll){ rotateTool.rotate(pitch,yaw,roll);}
    public void scale(double sx,double sy,double sz){ scaleTool.scale(sx,sy,sz);}

    public void importModel(String name){ editor.importModel(name);}
    public void saveActor(String path){ editor.saveActor(path);}
    public void captureFrame(BufferedImage img){
        // TODO: send frame to FrameCapture for export
    }
}
