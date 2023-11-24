package com.incident.report.service;

import com.incident.report.model.Usuario;

import java.util.Optional;

public interface IUsuario {
    boolean existsUser(String usuario);
    Usuario login(String usuario, String password);
}
