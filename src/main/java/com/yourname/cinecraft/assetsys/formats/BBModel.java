package com.yourname.cinecraft.assetsys.formats;

import com.yourname.cinecraft.util.JsonUtil;
import java.io.File;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * BBModel loader (Blockbench format)
 */
public class BBModel {

    public String name;
    public JSONArray cubes;

    public static BBModel load(File file){
        try(FileReader reader = new FileReader(file)){
            JSONObject obj = JsonUtil.parse(reader);
            BBModel model = new BBModel();
            model.name = obj.getString("name");
            model.cubes = obj.getJSONArray("cubes");
            System.out.println("[BBModel] Loaded "+model.name+" with "+model.cubes.length()+" cubes");
            return model;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
