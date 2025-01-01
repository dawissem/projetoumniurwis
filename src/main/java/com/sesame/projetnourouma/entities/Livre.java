package com.sesame.projetnourouma.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String isbn;

    @Temporal(TemporalType.DATE)
    private Date dateEdition;

    @Enumerated(EnumType.STRING)
    private Catg categorie;

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
