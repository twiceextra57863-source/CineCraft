package com.yourname.cinecraft.replay.storage;

import com.yourname.cinecraft.replay.ReplayData;
import com.yourname.cinecraft.util.FileUtil;

import java.io.*;

/**
 * Saves/Loads replays from disk
 */
public class ReplayStorage {

    private static final String REPLAY_DIR = "./minecraft/cinecraft/replays/";

    public static void saveReplay(String name, ReplayData data){
        try{
            FileUtil.ensureDir(REPLAY_DIR);
            File file = new File(REPLAY_DIR + name + ".cfr"); // CineCraftReplay
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(data);
            oos.close();
            System.out.println("[ReplayStorage] Saved replay: "+file.getAbsolutePath());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ReplayData loadReplay(String name){
        try{
            File file = new File(REPLAY_DIR + name + ".cfr");
            if(!file.exists()) return null;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ReplayData data = (ReplayData) ois.readObject();
            ois.close();
            System.out.println("[ReplayStorage] Loaded replay: "+file.getAbsolutePath());
            return data;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
