package br.org.edu.ifrn.LojaCarro.controllers;

import br.org.edu.ifrn.LojaCarro.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String usuario, @RequestParam String senha) {
        if (loginService.autenticar(usuario, senha)) {
            return ResponseEntity.ok("Login efetuado");
        }
        return ResponseEntity.status(401).body("Falha no login");
    }
}