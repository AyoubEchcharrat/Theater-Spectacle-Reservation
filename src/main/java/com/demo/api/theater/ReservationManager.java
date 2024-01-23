package com.demo.api.theater;

import java.util.HashMap;
import java.util.List;

public class ReservationManager {
    private Integer id = 0;
    private HashMap<Integer,Reservation> listReservations = new HashMap<>();

    private static ReservationManager reservationManager;

    public static ReservationManager getReservationManager(){
        if(reservationManager == null){
            reservationManager =  new ReservationManager();
        }
        return reservationManager;

    }

    public void addReservation(Reservation reservation){
        id++;
        reservation.setId(id);
        reservation.setStatus(ReservationStatus.PENDING);
        listReservations.put(id,reservation);
    }

    public List getReservations(Integer idSpec){
        return listReservations.values().stream()
                .filter(r -> r.getSpectacleKey().equals(idSpec))
                .toList();
    }

    public void deleteReservation(Integer id){
        Reservation reservation = listReservations.get(id);
        reservation.setStatus(ReservationStatus.CANCELED);
    }

    public void confirmReservation(Integer id){
        Reservation reservation = listReservations.get(id);
        reservation.setStatus(ReservationStatus.CONFIRMED);
    }

    public List getConfirmedReservations(Integer idSpec){
        return listReservations
                .values().stream()
                .filter(r -> r.getSpectacleKey().equals(idSpec) && r.getStatus().equals(ReservationStatus.CONFIRMED))
                .toList();
    }

    public Reservation getReservation(Integer id){
        return listReservations.get(id);
    }
}
