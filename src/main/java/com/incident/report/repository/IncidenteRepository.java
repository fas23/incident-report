package com.incident.report.repository;

import com.incident.report.model.Incidente;
import org.springframework.data.repository.CrudRepository;

public interface IncidenteRepository extends CrudRepository<Incidente, Long> {
}
