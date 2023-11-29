package com.incident.report.repository;

import com.incident.report.model.Incidente;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IncidenteRepository extends CrudRepository<Incidente, Long> {
    public List<Incidente> findByFecha(LocalDate date);
}
