package com.demo.api.theater;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reservations")
public class ReservationApi {
    static private SpectacleManager spectacleManager = SpectacleManager.getSpectacleManager();
    static private ReservationManager reservationManager = ReservationManager.getReservationManager();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservations(Reservation reservation){
        if(spectacleManager.getSpectacle(reservation.getSpectacleKey())==null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Une erreur s'est produite. (ID spectacle non trouvée.)")
                    .build();
        }
        reservationManager.addReservation(reservation);
        return Response.status(Response.Status.CREATED)
                .entity(reservation)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteReservations(@PathParam("id") Integer id,Reservation username){
        if(reservationManager.getReservation(id)==null)
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Reservation non trouvée.").build();
        if(username == null || !reservationManager.getReservation(id).getUsername().equals(username.getUsername()))
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity("Le nom d'utilisateur n'est pas identique à celui de la reservation").build();
        if(!reservationManager.getReservation(id).getStatus().equals(ReservationStatus.PENDING))
            return Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Le status de cette réservation n'est plus changeable.").build();
        reservationManager.deleteReservation(id);
        return Response
                .status(Response.Status.ACCEPTED)
                .entity("Réservation annulée").build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response confirmReservations(@PathParam("id") Integer id,Reservation username){
        if(reservationManager.getReservation(id)==null)
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Reservation non trouvée.").build();
        if(username == null || !reservationManager.getReservation(id).getUsername().equals(username.getUsername()))
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Le nom d'utilisateur n'est pas identique à celui de la reservation").build();
        if(!reservationManager.getReservation(id).getStatus().equals(ReservationStatus.PENDING))
            return Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Le status de cette réservation n'est plus changeable.").build();
        reservationManager.confirmReservation(id);
        return Response
                .status(Response.Status.ACCEPTED)
                .entity("Réservation confirmée.").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservation(@PathParam("id") Integer id){
         if(reservationManager.getReservation(id)==null)
             return Response
                     .status(Response.Status.NOT_FOUND)
                     .entity("Reservation non trouvée.").build();
         return Response
                 .status(Response.Status.OK)
                 .entity(reservationManager.getReservation(id)).build();
    }
}
