package com.incident.report.service;

import com.incident.report.model.Usuario;
import com.incident.report.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsuarioServiceImpl implements IGenerica<Usuario>, IUsuario{
    @Autowired
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Usuario save(Usuario objeto) {
        String encodedPassword = this.passwordEncoder.encode(objeto.getPassword());
        objeto.setPassword(encodedPassword);
        return usuarioRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario update(Usuario objeto, Long id) {
        //TODO
        return null;
    }

    @Override
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioRepository.findAll();

    }

    @Override
    public boolean existsUser(String usuario) {
        return usuarioRepository.existsByUsuario(usuario);
    }

    @Override
    public Usuario login(String usuario, String password) {
        boolean checKPassword = false;
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if(user != null){
            checKPassword = BCrypt.checkpw(password, user.getPassword());
        }
        return checKPassword ? user : null;
    }
}
