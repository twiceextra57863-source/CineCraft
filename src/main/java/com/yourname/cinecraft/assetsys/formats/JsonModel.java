package com.yourname.cinecraft.assetsys.formats;

import com.yourname.cinecraft.util.JsonUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileReader;

/**
 * Simple Minecraft JSON model loader
 */
public class JsonModel {

    public String name;
    public JSONArray elements;

    public static JsonModel load(File file){
        try(FileReader reader = new FileReader(file)){
            JSONObject obj = JsonUtil.parse(reader);
            JsonModel model = new JsonModel();
            model.name = file.getName();
            model.elements = obj.optJSONArray("elements");
            System.out.println("[JsonModel] Loaded "+model.name+" with "+(model.elements==null?0:model.elements.length())+" elements");
            return model;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
