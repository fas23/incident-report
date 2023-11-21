package com.incident.report.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnicos")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
}
