package com.incident.report.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    @JsonIgnore
    private List<Tecnico> tecnicos;
    public Especialidad() {
        tecnicos = new ArrayList<>();
    }

    public Especialidad(Long id, String nombre, List<Tecnico> tecnicos) {
        this.id = id;
        this.nombre = nombre;
        this.tecnicos = tecnicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
}
