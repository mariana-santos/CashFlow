package br.com.fiap.CashFlow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.CashFlow.model.Usuario;
import br.com.fiap.CashFlow.model.dto.Credenciais;
import br.com.fiap.CashFlow.model.dto.Token;
import br.com.fiap.CashFlow.model.dto.UsuarioResponse;
import br.com.fiap.CashFlow.repository.UsuarioRepository;
import br.com.fiap.CashFlow.service.TokenService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService service;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Credenciais credenciais){
        log.info(credenciais);
        authManager.authenticate(credenciais.toAuthentication());
        return ResponseEntity.ok( service.generateToken(credenciais.email()) );
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> create(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(UsuarioResponse.fromUsuario(usuario));
    }
}
