package com.incident.report.controller;

import com.incident.report.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EnviarCorreoController {
    @Autowired
    private JavaMailSender mail;
    @PostMapping("email")
    public ResponseEntity<?> sendEmail(@RequestBody Email correo){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(correo.getSetTo());
        email.setFrom(correo.getSetFrom());
        email.setSubject(correo.getSetSubject());
        email.setText(correo.getSetText());
        mail.send(email);
        return new ResponseEntity<>("Envio Exitoso", HttpStatus.OK);
    }
}

