package com.demo.api.tigres;

import com.demo.api.personnes.Personne;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tigres")
public class TigresApi {
    static private Tigres tigres = new Tigres();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tigre> getTigres(){
        return tigres.getTigres();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTigres(Tigre tigre){
        return Response.status(Response.Status.CREATED).entity("created.").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tigre getTigre(@PathParam("id") int id){
        return tigres.getOneTigre(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTigre(@PathParam("id") int id){
        return tigres.deleteTigre(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateTigre(@PathParam("id") int id,Tigre tigre){
        return tigres.updateTigre(id,tigre);
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String patchTigre(@PathParam("id") int id,Tigre tigre){
        return tigres.patchTigre(id,tigre);
    }
}
