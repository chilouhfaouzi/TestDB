package com.example.testbd.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tach_user")
public class TachUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "tashe_id")
    private Tache tache;

}
