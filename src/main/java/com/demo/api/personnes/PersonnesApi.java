package com.demo.api.personnes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/personnes")
public class PersonnesApi {

    static private AnnuairePersonne annuaire = new AnnuairePersonne();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersonnes(){
        return annuaire.getList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPersonne(Personne personne){
        if(personne.getNom().isBlank()) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Le nom ne peut etre vide").build();
        }
        annuaire.addPersonne(personne);
        return Response
                .status(Response.Status.CREATED)
                .entity(personne).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonne(@PathParam("id") Integer id){
        Personne personne = annuaire.getPersonne(id);
        if(personne == null) {
            //  retourner 404
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Id inexistant").build();
        }else{
            return Response.ok(personne).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void deletePersonne(@PathParam("id") Integer id){
        annuaire.deletePersonne(id);
    }

    @PUT
    @Path("/{id}")
    public Response updatePersonne(Personne personne, @PathParam("id") Integer id){
        if(!id.equals(personne.getId())){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("id différents").build();
        }
        else {
            Personne p = annuaire.getPersonne(id);
            if(p == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Id inexistant").build();
            } else {
                annuaire.updatePersonne(id, personne);
                return Response.ok().build();
            }
        }
    }

    @PATCH
    @Path("/{id}")
    public void patchPersonne(Personne personne, @PathParam("id") Integer id){
        annuaire.patchPersonne(id, personne);
    }
}
