package com.incident.report.repository;

import com.incident.report.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Boolean existsByUsuario(String usuario);
    Usuario findByUsuario(String usuario);

}
