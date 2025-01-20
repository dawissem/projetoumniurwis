package com.sesame.projetnourouma.repository;

import com.sesame.projetnourouma.entities.Livre;
import com.sesame.projetnourouma.entities.Reservation;
import com.sesame.projetnourouma.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public interface IReservationRepository extends CrudRepository<Reservation, Integer> {



}
