package com.demo.api.theater;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/spectacles")
public class SpectacleApi {
    static private SpectacleManager spectacleManager = SpectacleManager.getSpectacleManager();
    static private ReservationManager reservationManager = ReservationManager.getReservationManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpectacles(){
        return Response.ok(spectacleManager.getSpectacles()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSpectacle(Spectacle spectacle){
        if(spectacle.getName().isBlank() || spectacle.getDescription().isBlank()){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Veuillez remplir tous les champs.")
                    .build();
        }
        spectacleManager.addSpectacle(spectacle);
        return Response.ok(spectacle).build();
    }

    @GET
    @Path("/{id}/all-reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpectacleReservations(@PathParam("id") Integer id){
        if(spectacleManager.getSpectacle(id)==null){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Spectacle non trouvé.")
                    .build();
        }
        return Response.ok(reservationManager.getReservations(id)).build();
    }

    @GET
    @Path("/{id}/confirmed-reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpectacleConfirmedReservations(@PathParam("id") Integer id){
        if(spectacleManager.getSpectacle(id)==null){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Spectacle non trouvé.")
                    .build();
        }
        return Response.ok(reservationManager.getConfirmedReservations(id)).build();
    }
}
