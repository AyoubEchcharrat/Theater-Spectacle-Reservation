package com.demo.api.tigres;

import java.util.ArrayList;
import java.util.List;

public class Tigres {

    private static int cpmt = 0;
    private ArrayList<Tigre> tigres = new ArrayList<>();

    public List<Tigre> getTigres(){
        return tigres;
    }

    public String addTigre(Tigre tigre){
        tigre.setId(cpmt++);
        tigres.add(tigre);
        return "Ajout réussi.";
    }

    public Tigre getOneTigre(int id){
        Tigre selectedtigre = null;
        for(Tigre t : tigres){
            if(t.getId() == id){
                selectedtigre = t;
                break;
            }
        }
        return selectedtigre;
    }

    public String deleteTigre(int id){
        for(Tigre t : tigres){
            if(t.getId() == id){
                tigres.remove(t);
                return "Suppression d'une entrée.";
            }
        }
        return "Aucune entrée n'a été supprimé.";
    }

    public String updateTigre(int id,Tigre tigre){
        for(Tigre t : tigres){
            if(t.getId() == id){
                tigres.remove(t);
                Tigre newTigre = tigre;
                newTigre.setModifyedId(id);
                tigres.add(tigre);
                return "Modification d'une entrée.";
            }
        }
        return "Aucune entrée n'a été modifié.";
    }

    public String patchTigre(int id, Tigre tigreClient){
        Tigre tigreServer = null;
        for(Tigre t : tigres){
            if(t.getId() == id){
                tigreServer = t;
            }
        }
        tigreServer.patchValues(tigreClient);
        updateTigre(id,tigreServer);
        return "Modification effectuée.";
    }
}
