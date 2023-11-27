package com.incident.report.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "tiempo_estimado_resolucion")
    private LocalTime tiempoEstimadoResolucion;
    @Column(name = "fecha_posible_solucion")
    private LocalDate fechaPosibleSolucion;
    @ManyToOne
    @JoinColumn(name="empresa_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name="tecnico_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    public Incidente() {
    }

    public Incidente(Long id, String descripcion, String tipo, LocalTime tiempoEstimadoResolucion, LocalDate fechaPosibleSolucion, Empresa empresa, Tecnico tecnico, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
        this.fechaPosibleSolucion = fechaPosibleSolucion;
        this.empresa = empresa;
        this.tecnico = tecnico;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalTime getTiempoEstimadoResolucion() {
        return tiempoEstimadoResolucion;
    }

    public void setTiempoEstimadoResolucion(LocalTime tiempoEstimadoResolucion) {
        this.tiempoEstimadoResolucion = tiempoEstimadoResolucion;
    }

    public LocalDate getFechaPosibleSolucion() {
        return fechaPosibleSolucion;
    }

    public void setFechaPosibleSolucion(LocalDate fechaPosibleSolucion) {
        this.fechaPosibleSolucion = fechaPosibleSolucion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
