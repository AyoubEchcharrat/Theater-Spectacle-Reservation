package com.demo.api.personnes;

import java.util.HashMap;
import java.util.List;

public class AnnuairePersonne {

    private int id;
    private HashMap<Integer,Personne> list = new HashMap<>();

    public void addPersonne(Personne personne){
        id++;
        personne.setId(id);
        list.put(id,personne);
    }

    public List<Personne> getList() {
        return list.values().stream().toList();
    }

    public Personne getPersonne(int id){
        return list.get(id);
    }

    public void deletePersonne(int id){
        list.remove(id);
    }

    public void updatePersonne(Integer id, Personne personne) {
        list.replace(id, personne);
    }

    public void patchPersonne(Integer id, Personne personneRequeteHttp) {

        Personne personneToPatch = list.get(id);
        if(personneRequeteHttp.getPrenom() != null)
            personneToPatch.setPrenom(personneRequeteHttp.getPrenom());
        if(personneRequeteHttp.getNom() != null)
            personneToPatch.setNom(personneRequeteHttp.getNom());

        list.replace(id, personneToPatch);
    }
}
