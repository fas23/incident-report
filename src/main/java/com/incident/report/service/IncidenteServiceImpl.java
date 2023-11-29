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
public class IncidenteServiceImpl implements IGenerica<Incidente>, IIncidenteService{
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
        Empresa empresa = empresaRepository.findById(objeto.getEmpresa().getId()).get();
        Tecnico tecnico = tecnicoRepository.findById(objeto.getTecnico().getId()).get();
        Usuario usuario = usuarioRepository.findById(objeto.getUsuario().getId()).get();
        objeto.setEmpresa(empresa);
        objeto.setTecnico(tecnico);
        objeto.setUsuario(usuario);
        objeto.setFecha(LocalDate.now());
        objeto.setEstado(false);
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
        Incidente updateIncidente = incidenteRepository.findById(id).get();
        updateIncidente.setDescripcion(objeto.getDescripcion());
        updateIncidente.setTipo(objeto.getTipo());
        updateIncidente.setFecha(objeto.getFecha());
        updateIncidente.setFechaPosibleSolucion(objeto.getFechaPosibleSolucion());
        updateIncidente.setTiempoEstimadoResolucion(objeto.getTiempoEstimadoResolucion());
        updateIncidente.setEstado(objeto.getEstado());
        updateIncidente.setEmpresa(objeto.getEmpresa());
        updateIncidente.setTecnico(objeto.getTecnico());
        updateIncidente.setUsuario(objeto.getUsuario());
        return incidenteRepository.save(updateIncidente);
    }

    @Override
    public List<Incidente> getAll() {
        return (List<Incidente>) incidenteRepository.findAll();
    }

    @Override
    public List<Incidente> findByFecha(LocalDate date) {
        return incidenteRepository.findByFecha(date);
    }
}
