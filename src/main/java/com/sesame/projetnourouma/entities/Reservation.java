package com.sesame.projetnourouma.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateRetour;

    @Temporal(TemporalType.DATE)
    private Date dateAnnulation;

    @Temporal(TemporalType.DATE)
    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;
}
