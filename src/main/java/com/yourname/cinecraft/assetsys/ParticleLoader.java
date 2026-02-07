package com.yourname.cinecraft.assetsys;

import com.yourname.cinecraft.util.FileUtil;
import com.yourname.cinecraft.util.JsonUtil;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Loads particle effects for CineCraft
 * Supports:
 * - position / offset
 * - velocity
 * - lifetime
 * - color / size / rotation
 */
public class ParticleLoader {

    // Cache of loaded particle prefabs
    private static Map<String, ParticlePrefab> particleCache = new HashMap<>();

    /**
     * Load particle prefab from JSON file
     * @param file - .particle JSON file
     * @return ParticlePrefab object
     */
    public static ParticlePrefab load(File file){
        try(FileReader reader = new FileReader(file)){
            JSONObject obj = JsonUtil.parse(reader);
            String name = obj.getString("name");
            JSONArray particles = obj.getJSONArray("particles");

            ParticlePrefab prefab = new ParticlePrefab(name);

            for(int i=0;i<particles.length();i++){
                JSONObject p = particles.getJSONObject(i);
                ParticleData data = new ParticleData();

                data.offsetX = p.optDouble("offsetX",0);
                data.offsetY = p.optDouble("offsetY",0);
                data.offsetZ = p.optDouble("offsetZ",0);

                data.velX = p.optDouble("velX",0);
                data.velY = p.optDouble("velY",0);
                data.velZ = p.optDouble("velZ",0);

                data.life = p.optInt("life",20);
                data.size = p.optDouble("size",1.0);
                data.color = p.optString("color","#ffffff");
                data.rotation = p.optDouble("rotation",0);

                prefab.addParticle(data);
            }

            // Cache prefab
            particleCache.put(name, prefab);
            System.out.println("[ParticleLoader] Loaded particle prefab: "+name);
            return prefab;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get cached particle prefab
     */
    public static ParticlePrefab get(String name){
        return particleCache.get(name);
    }

    /**
     * Clear cache
     */
    public static void clearCache(){
        particleCache.clear();
    }

    // =======================
    // Inner Classes for Particle Data
    // =======================
    public static class ParticlePrefab {
        private String name;
        private java.util.List<ParticleData> particles;

        public ParticlePrefab(String name){
            this.name = name;
            this.particles = new java.util.ArrayList<>();
        }

        public void addParticle(ParticleData p){ particles.add(p); }
        public java.util.List<ParticleData> getParticles(){ return particles; }
        public String getName(){ return name; }
    }

    public static class ParticleData {
        public double offsetX, offsetY, offsetZ;
        public double velX, velY, velZ;
        public int life;
        public double size;
        public String color;
        public double rotation;
    }
}
