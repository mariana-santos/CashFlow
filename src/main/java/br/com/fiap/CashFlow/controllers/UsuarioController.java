package br.com.fiap.CashFlow.controllers;

import java.util.List;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.CashFlow.model.Usuario;
import br.com.fiap.CashFlow.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listAll() {
        log.info("Buscando Todos os Usuarios");
        return usuarioRepository.findAll();
<<<<<<< HEAD
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> readUsuario(@PathVariable Long id) {
        log.info("Exibindo o Usuario de ID: " + id);
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid Usuario novo_usuario) {
        log.info("Cadastrando Usuario: " + novo_usuario);
        usuarioRepository.save(novo_usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable @Valid Long id,
            @RequestBody Usuario usuario_atualizar) {
        log.info("Atualizando o Usuario de ID: " + id);
        getUsuarioById(id);
        usuario_atualizar.setId(id);
        usuarioRepository.save(usuario_atualizar);
        return ResponseEntity.ok(usuario_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        log.info("Deletando o Usuario de ID: " + id);
        usuarioRepository.delete(getUsuarioById(id));
        return ResponseEntity.noContent().build();
    }

    private Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado com o ID: " + id));
    }
=======
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> readUsuario(@PathVariable Long id) {
        log.info("Exibindo o Usuario de ID: " + id);
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid Usuario novo_usuario) {
        log.info("Cadastrando Usuario: " + novo_usuario);
        usuarioRepository.save(novo_usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable @Valid Long id,
            @RequestBody Usuario usuario_atualizar) {
        log.info("Atualizando o Usuario de ID: " + id);
        getUsuarioById(id);
        usuario_atualizar.setId(id);
        usuarioRepository.save(usuario_atualizar);
        return ResponseEntity.ok(usuario_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        log.info("Deletando o Usuario de ID: " + id);
        usuarioRepository.delete(getUsuarioById(id));
        return ResponseEntity.noContent().build();
    }

    private Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado com o ID: " + id));
    }

    @PostMapping("/usuario")
    public ResponseEntity<Object> create(@RequestBody @Valid Usuario usuario) {
        log.info("Cadastrando usuário " + usuario);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }   
>>>>>>> 9f1c0bd1921c02396e0ee2d6e055f32268e66ec9
}
