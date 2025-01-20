package com.sesame.projetnourouma.service;

import com.sesame.projetnourouma.entities.Livre;
import com.sesame.projetnourouma.entities.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservationById(int id);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(int id);
    public Reservation createReservation(Reservation reservation);


}
