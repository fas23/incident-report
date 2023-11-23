package com.incident.report.service;

import com.incident.report.model.Especialidad;
import com.incident.report.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EspecialidadServiceImpl implements IGenerica<Especialidad>{
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad save(Especialidad objeto) {
        return especialidadRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        especialidadRepository.deleteById(id);
    }

    @Override
    public Especialidad update(Especialidad objeto) {
        return null;
    }

    @Override
    public List<Especialidad> getAll() {
        List<Especialidad> lista = new ArrayList<>();
        especialidadRepository.findAll().forEach(especialidad -> lista.add(especialidad));
        return lista;
    }
}
