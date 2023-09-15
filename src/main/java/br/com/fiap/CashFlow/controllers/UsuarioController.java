package br.com.fiap.CashFlow.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.CashFlow.model.Usuario;
import br.com.fiap.CashFlow.repository.UsuarioRepository;

import br.com.fiap.CashFlow.validation.RestValidationError;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class UsuarioController {
    
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/usuario")
    public List<Usuario> index(){
        log.info("Buscando todos os usuários");
        return repository.findAll();
    }

    @PostMapping("/usuario")
    public ResponseEntity<Object> create(@RequestBody @Valid Usuario usuario) {
        log.info("Cadastrando usuário " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
}
