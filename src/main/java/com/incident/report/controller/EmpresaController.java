package com.incident.report.controller;

import com.incident.report.model.Empresa;
import com.incident.report.service.IGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmpresaController {
    @Autowired
    private IGenerica<Empresa> empresaService;

    @PostMapping("empresa")
    public Empresa saveEspecialidad(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }

    @DeleteMapping("empresa/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id){
        empresaService.delete(id);
    }
}
