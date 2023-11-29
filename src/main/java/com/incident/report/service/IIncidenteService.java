package com.incident.report.service;

import com.incident.report.model.Incidente;

import java.time.LocalDate;
import java.util.List;

public interface IIncidenteService {
    List<Incidente> findByFecha(LocalDate date);
}
