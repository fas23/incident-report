package com.incident.report.service;

import com.incident.report.model.Especialidad;
import com.incident.report.model.Tecnico;
import com.incident.report.repository.EspecialidadRepository;
import com.incident.report.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoServiceImpl implements IGenerica<Tecnico>{
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Tecnico save(Tecnico objeto) {
        Especialidad especialidad = especialidadRepository.findById(objeto.getEspecialidad().getId()).orElse(null);
        objeto.setEstado(false);
        objeto.setEspecialidad(especialidad);
        return tecnicoRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        tecnicoRepository.deleteById(id);
    }

    @Override
    public Tecnico update(Tecnico objeto, Long id) {
        Tecnico updateTechnical = tecnicoRepository.findById(id).get();
        updateTechnical.setNombre(objeto.getNombre());
        updateTechnical.setApellido(objeto.getApellido());
        updateTechnical.setEstado(objeto.getEstado());
        updateTechnical.setEspecialidad(objeto.getEspecialidad());
        tecnicoRepository.save(updateTechnical);
        return updateTechnical;
    }

    @Override
    public List<Tecnico> getAll() {
        return (List<Tecnico>) tecnicoRepository.findAll();
    }
}
