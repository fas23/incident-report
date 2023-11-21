package com.incident.report.model;

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
    @Column(name = "tiempo_estimado_resolucion")
    private LocalTime tiempoEstimadoResolucion;
    @Column(name = "fecha_posible_solucion")
    private LocalDate fechaPosibleSolucion;
    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name="tecnico_id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
