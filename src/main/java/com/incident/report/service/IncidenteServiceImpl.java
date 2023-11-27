package com.incident.report.service;

import com.incident.report.model.Empresa;
import com.incident.report.model.Incidente;
import com.incident.report.model.Tecnico;
import com.incident.report.model.Usuario;
import com.incident.report.repository.EmpresaRepository;
import com.incident.report.repository.IncidenteRepository;
import com.incident.report.repository.TecnicoRepository;
import com.incident.report.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class IncidenteServiceImpl implements IGenerica<Incidente>{
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private IGenerica<Tecnico> tecnicoService;

    @Override
    public Incidente save(Incidente objeto) {
        Empresa empresa = empresaRepository.findById(objeto.getEmpresa().getId()).orElse(null);
        Tecnico tecnico = tecnicoRepository.findById(objeto.getTecnico().getId()).orElse(null);
        Usuario usuario = usuarioRepository.findById(objeto.getUsuario().getId()).orElse(null);
        objeto.setEmpresa(empresa);
        objeto.setTecnico(tecnico);
        objeto.setUsuario(usuario);
        objeto.setFecha(LocalDate.now());
        tecnico.setEstado(true);
        tecnicoService.update(tecnico,tecnico.getId());
        return incidenteRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        incidenteRepository.deleteById(id);
    }

    @Override
    public Incidente update(Incidente objeto, Long id) {
        return null;
    }

    @Override
    public List<Incidente> getAll() {
        return (List<Incidente>) incidenteRepository.findAll();
    }
}
