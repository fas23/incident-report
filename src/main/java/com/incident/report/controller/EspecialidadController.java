package com.incident.report.controller;

import com.incident.report.model.Especialidad;
import com.incident.report.service.IGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
