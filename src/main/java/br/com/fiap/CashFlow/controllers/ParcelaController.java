package br.com.fiap.CashFlow.controllers;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;
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

import br.com.fiap.CashFlow.model.Parcela;
import br.com.fiap.CashFlow.repository.ParcelaRepository;

@RestController
@RequestMapping("parcelas")
@Slf4j
public class ParcelaController {

    @Autowired
    ParcelaRepository parcelaRepository;

    @GetMapping
    public Page<Parcela> listAll(
        @PageableDefault(size = 5, sort = "numero") Pageable pageRequest, 
        @RequestParam(required = false) String status_pagamento) {
        log.info("Buscando Todas as Parcelas");
        return parcelaRepository.findByStatusPagamentoContainingIgnoreCase(status_pagamento, pageRequest);
    }

    @GetMapping("{id}")
    public ResponseEntity<Parcela> readParcela(@PathVariable Long id) {
        log.info("Exibindo a Parcela de ID: " + id);
        return ResponseEntity.ok(getParcelaById(id));
    }

    @PostMapping
    public ResponseEntity<Parcela> createParcela(@RequestBody @Valid Parcela novo_parcela) {
        log.info("Cadastrando Parcela: " + novo_parcela);
        parcelaRepository.save(novo_parcela);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_parcela);
    }

    @PutMapping("{id}")
    public ResponseEntity<Parcela> updateParcela(@PathVariable @Valid Long id,
            @RequestBody Parcela parcela_atualizar) {
        log.info("Atualizando a Parcela de ID: " + id);
        getParcelaById(id);
        parcela_atualizar.setId(id);
        parcelaRepository.save(parcela_atualizar);
        return ResponseEntity.ok(parcela_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Parcela> deleteParcela(@PathVariable Long id) {
        log.info("Deletando a Parcela de ID: " + id);
        parcelaRepository.delete(getParcelaById(id));
        return ResponseEntity.noContent().build();
    }

    private Parcela getParcelaById(Long id) {
        return parcelaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parcela não encontrada com o ID: " + id));
    }
}
