package com.incident.report.controller;

import com.incident.report.model.Incidente;
import com.incident.report.service.IIncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ReporteController {
    @Autowired
    private IIncidenteService incidenteService;
    @GetMapping("reporte-diario")
    public List<Incidente> getReporteDiario(){
        return incidenteService.findByFecha(LocalDate.now());
    }
}
