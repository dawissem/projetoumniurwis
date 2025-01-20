package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.entities.Livre;
import com.sesame.projetnourouma.entities.Reservation;
import com.sesame.projetnourouma.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;
    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {

        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/get/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return reservationService.retrieveReservationById(id);
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/update")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.updateReservation(reservation);
    }




    @DeleteMapping("/delete/{id}")
        public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);        }
}

