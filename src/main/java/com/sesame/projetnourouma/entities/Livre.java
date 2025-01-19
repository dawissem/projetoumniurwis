package com.sesame.projetnourouma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Livre   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String isbn;

    @Temporal(TemporalType.DATE)
    private Date dateEdition;

    @Enumerated(EnumType.STRING)
    private Catg categorie;
    @JsonIgnore

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;



}
