package com.yourname.cinecraft.assetsys.formats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Wavefront OBJ loader
 */
public class ObjModel {

    public String name;
    public List<float[]> vertices = new ArrayList<>();
    public List<int[]> faces = new ArrayList<>();

    public static ObjModel load(File file){
        ObjModel model = new ObjModel();
        model.name = file.getName();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line=br.readLine())!=null){
                if(line.startsWith("v ")){
                    String[] parts = line.split("\\s+");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    model.vertices.add(new float[]{x,y,z});
                } else if(line.startsWith("f ")){
                    String[] parts = line.split("\\s+");
                    int v1 = Integer.parseInt(parts[1].split("/")[0])-1;
                    int v2 = Integer.parseInt(parts[2].split("/")[0])-1;
                    int v3 = Integer.parseInt(parts[3].split("/")[0])-1;
                    model.faces.add(new int[]{v1,v2,v3});
                }
            }
            System.out.println("[ObjModel] Loaded "+model.name+" with "+model.vertices.size()+" vertices and "+model.faces.size()+" faces");
            return model;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
