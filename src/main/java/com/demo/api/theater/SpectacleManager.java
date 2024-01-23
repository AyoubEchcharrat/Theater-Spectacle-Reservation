package com.demo.api.theater;

import java.util.HashMap;
import java.util.List;

public class SpectacleManager {
    private Integer id = 0;
    private HashMap<Integer,Spectacle> listSpectacles = new HashMap<>();

    private static SpectacleManager spectacleManager;

    public static SpectacleManager getSpectacleManager(){
        if(spectacleManager == null){
            spectacleManager = new SpectacleManager();
        }
        return spectacleManager;

    }

    private SpectacleManager(){}

    public void addSpectacle(Spectacle spectacle){
        id++;
        spectacle.setId(id);
        listSpectacles.put(id,spectacle);
    }

    public List<Spectacle> getSpectacles(){
        return listSpectacles.values().stream().toList();
    }

    public Spectacle getSpectacle(Integer id){
        return listSpectacles.get(id);
    }
}
