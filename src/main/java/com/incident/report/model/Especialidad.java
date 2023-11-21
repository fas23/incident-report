package com.incident.report.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "especialidad")
    private List<Tecnico> tecnicos;
}
