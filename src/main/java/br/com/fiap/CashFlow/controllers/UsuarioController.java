package br.com.fiap.CashFlow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.fiap.CashFlow.model.dto.Token;
import br.com.fiap.CashFlow.repository.UsuarioRepository;
import br.com.fiap.CashFlow.service.TokenService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService service;

    @PostMapping("/login")
    public ResponseEntity<Token> login(){
        return ResponseEntity.ok( service.generateToken("mari@fiap.com.br") );
    }
}
