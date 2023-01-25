package com.example.testbd.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private LocalDate dateCreation;
    private LocalDate dateLivraison;
    private LocalDate dateComplet;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "userCreate_id")
    private User userCreated;


    @OneToMany(mappedBy = "tache")
    private List<TachUser> tachUsers;

    @OneToMany(mappedBy = "tache")
    private List<Commentaire> comments;

    @ManyToMany
    @JoinTable(name = "task_reference",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "reference_id"))
    private List<Tache> tachesLinked;

    public Tache() {
    }

}
