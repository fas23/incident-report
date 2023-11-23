package com.incident.report.controller;

import com.incident.report.model.Especialidad;
import com.incident.report.service.IGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EspecialidadController {
    @Autowired
    private IGenerica<Especialidad> especialidadService;

    @GetMapping("especialidades")
    public List<Especialidad> getAll(){
        return especialidadService.getAll();
    }

    @PostMapping("especialidad")
    public Especialidad saveEspecialidad(@RequestBody Especialidad especialidad){
        return especialidadService.save(especialidad);
    }

    @DeleteMapping("especialidad/{id}")
    public void deleteEspecialidad(@PathVariable("id") Long id){
        especialidadService.delete(id);
    }
}
