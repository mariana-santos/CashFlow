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

import br.com.fiap.CashFlow.model.Renda;
import br.com.fiap.CashFlow.repository.RendaRepository;

@RestController
@RequestMapping("rendas")
@Slf4j
public class RendaController {

    @Autowired
    RendaRepository rendaRepository;

    @GetMapping
    public List<Renda> listAll() {
        log.info("Buscando Todas as Rendas");
        return rendaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Renda> readRenda(@PathVariable Long id) {
        log.info("Exibindo a Renda de ID: " + id);
        return ResponseEntity.ok(getRendaById(id));
    }

    @PostMapping
    public ResponseEntity<Renda> createRenda(@RequestBody @Valid Renda novo_renda) {
        log.info("Cadastrando Renda: " + novo_renda);
        rendaRepository.save(novo_renda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_renda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Renda> updateRenda(@PathVariable @Valid Long id,
            @RequestBody Renda renda_atualizar) {
        log.info("Atualizando a Renda de ID: " + id);
        getRendaById(id);
        renda_atualizar.setId(id);
        rendaRepository.save(renda_atualizar);
        return ResponseEntity.ok(renda_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Renda> deleteRenda(@PathVariable Long id) {
        log.info("Deletando a Renda de ID: " + id);
        rendaRepository.delete(getRendaById(id));
        return ResponseEntity.noContent().build();
    }

    private Renda getRendaById(Long id) {
        return rendaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Renda não encontrada com o ID: " + id));
    }
}
