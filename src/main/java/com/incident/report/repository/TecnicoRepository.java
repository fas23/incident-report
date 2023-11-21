package com.incident.report.repository;

import com.incident.report.model.Tecnico;
import org.springframework.data.repository.CrudRepository;

public interface TecnicoRepository extends CrudRepository<Tecnico, Long> {
}
