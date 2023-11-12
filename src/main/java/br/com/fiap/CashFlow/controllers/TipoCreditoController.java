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

import br.com.fiap.CashFlow.model.TipoCredito;
import br.com.fiap.CashFlow.repository.TipoCreditoRepository;

@RestController
@RequestMapping("tipoCreditos")
@Slf4j
public class TipoCreditoController {

    @Autowired
    TipoCreditoRepository tipoCreditoRepository;

    @GetMapping
    public List<TipoCredito> listAll() {
        log.info("Buscando Todos os TipoCreditos");
        return tipoCreditoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoCredito> readTipoCredito(@PathVariable Long id) {
        log.info("Exibindo o TipoCredito de ID: " + id);
        return ResponseEntity.ok(getTipoCreditoById(id));
    }

    @PostMapping
    public ResponseEntity<TipoCredito> createTipoCredito(@RequestBody @Valid TipoCredito novo_tipoCredito) {
        log.info("Cadastrando TipoCredito: " + novo_tipoCredito);
        tipoCreditoRepository.save(novo_tipoCredito);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_tipoCredito);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoCredito> updateTipoCredito(@PathVariable @Valid Long id,
            @RequestBody TipoCredito tipoCredito_atualizar) {
        log.info("Atualizando o TipoCredito de ID: " + id);
        getTipoCreditoById(id);
        tipoCredito_atualizar.setId(id);
        tipoCreditoRepository.save(tipoCredito_atualizar);
        return ResponseEntity.ok(tipoCredito_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TipoCredito> deleteTipoCredito(@PathVariable Long id) {
        log.info("Deletando o TipoCredito de ID: " + id);
        tipoCreditoRepository.delete(getTipoCreditoById(id));
        return ResponseEntity.noContent().build();
    }

    private TipoCredito getTipoCreditoById(Long id) {
        return tipoCreditoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoCredito não encontrado com o ID: " + id));
    }
}
