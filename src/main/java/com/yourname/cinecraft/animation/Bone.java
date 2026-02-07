package com.yourname.cinecraft.animation;

/**
 * Represents a single bone of an actor
 */
public class Bone implements Cloneable {
    private String name;
    private double x, y, z;
    private double rotX, rotY, rotZ; // Euler angles
    private Bone parent;

    public Bone(String name){
        this.name = name;
        this.x = 0; this.y = 0; this.z = 0;
        this.rotX = 0; this.rotY = 0; this.rotZ = 0;
        this.parent = null;
    }

    public void setPosition(double x, double y, double z){ this.x = x; this.y = y; this.z = z; }
    public void setRotation(double rx, double ry, double rz){ this.rotX = rx; this.rotY = ry; this.rotZ = rz; }
    public void setParent(Bone parent){ this.parent = parent; }

    public double getX(){ return x; }
    public double getY(){ return y; }
    public double getZ(){ return z; }
    public double getRotX(){ return rotX; }
    public double getRotY(){ return rotY; }
    public double getRotZ(){ return rotZ; }
    public Bone getParent(){ return parent; }

    @Override
    public Bone clone(){
        try{
            Bone b = (Bone) super.clone();
            b.parent = this.parent; // shallow clone parent
            return b;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }
}
