package com.incident.report.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "cuit")
    private String cuit;
    @OneToMany(mappedBy = "empresa")
    private List<Incidente> incidentes;
    public Empresa() {
        incidentes = new ArrayList<>();
    }
    public Empresa(Long id, String razonSocial, String cuit, List<Incidente> incidentes) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.incidentes = incidentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
}
