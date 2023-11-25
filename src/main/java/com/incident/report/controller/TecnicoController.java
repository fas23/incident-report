package com.incident.report.controller;

import com.incident.report.model.Tecnico;
import com.incident.report.service.IGenerica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TecnicoController {
    @Autowired
    private IGenerica<Tecnico> tecnicoService;

    @GetMapping("tecnicos")
    public List<Tecnico> getAll(){
        return tecnicoService.getAll();
    }

    @PostMapping("tecnico")
    public Tecnico saveTecnico(@RequestBody Tecnico tecnico){
        return tecnicoService.save(tecnico);
    }

    @PutMapping("tecnico/{id}")
    public Tecnico updateTecnico(@RequestBody Tecnico tecnico, @PathVariable("id") Long id){
        return tecnicoService.update(tecnico, id);
    }

    @DeleteMapping("tecnico/{id}")
    public void deleteTecnico(@PathVariable("id") Long id){
        tecnicoService.delete(id);
    }

}
