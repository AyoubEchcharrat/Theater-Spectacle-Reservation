package com.demo.api.theater;

public class Reservation {
    private Integer id;
    private String username;
    private ReservationStatus status;
    private Integer spectacleKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSpectacleKey() {
        return spectacleKey;
    }

    public void setSpectacleKey(Integer spectacleKey) {
        this.spectacleKey = spectacleKey;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", spectacleKey=" + spectacleKey +
                '}';
    }
}
