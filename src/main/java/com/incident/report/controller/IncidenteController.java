package com.incident.report.controller;

import com.incident.report.model.Incidente;
import com.incident.report.service.IGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class IncidenteController {
    @Autowired
    private IGenerica<Incidente> incidenteService;
    @GetMapping("incidentes")
    public List<Incidente> getAll(){
        return incidenteService.getAll();
    }
    @PostMapping("incidente")
    public Incidente saveIncidente(@RequestBody Incidente incidente) {
        return incidenteService.save(incidente);

    }
}
