package com.incident.report.service;

import com.incident.report.model.Empresa;
import com.incident.report.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServiceImpl implements IGenerica<Empresa>{
    @Autowired
    private EmpresaRepository empresaRepository;
    @Override
    public Empresa save(Empresa objeto) {
        return empresaRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
    @Override
    public Empresa update(Empresa objeto) {
        return null;
    }

    @Override
    public List<Empresa> getAll() {
        List<Empresa> empresas= new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresas.add(empresa));
        return empresas;
    }
}
