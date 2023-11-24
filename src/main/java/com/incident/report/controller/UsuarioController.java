package com.incident.report.controller;

import com.incident.report.model.Usuario;
import com.incident.report.service.IGenerica;
import com.incident.report.service.IUsuario;
import com.incident.report.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    @Autowired
    private IGenerica<Usuario> genericService;
    @Autowired
    private IUsuario usuarioService;
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario){
        if(usuarioService.existsUser(usuario.getUsuario())){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        genericService.save(usuario);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
    }

    @PostMapping("login")
    public String login(@RequestBody Usuario usuario){
        Usuario user = usuarioService.login(usuario.getUsuario(), usuario.getPassword());
        return user!=null ? "Usuario logueado Correctamente" : "Usuario o Contraseñas incorrectas";
    }

}
