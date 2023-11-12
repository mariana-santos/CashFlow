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

import br.com.fiap.CashFlow.model.Pagamento;
import br.com.fiap.CashFlow.repository.PagamentoRepository;

@RestController
@RequestMapping("pagamentos")
@Slf4j
public class PagamentoController {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listAll() {
        log.info("Buscando Todos os Pagamentos");
        return pagamentoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pagamento> readPagamento(@PathVariable Long id) {
        log.info("Exibindo o Pagamento de ID: " + id);
        return ResponseEntity.ok(getPagamentoById(id));
    }

    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@RequestBody @Valid Pagamento novo_pagamento) {
        log.info("Cadastrando Pagamento: " + novo_pagamento);
        pagamentoRepository.save(novo_pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_pagamento);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable @Valid Long id,
            @RequestBody Pagamento pagamento_atualizar) {
        log.info("Atualizando o Pagamento de ID: " + id);
        getPagamentoById(id);
        pagamento_atualizar.setId(id);
        pagamentoRepository.save(pagamento_atualizar);
        return ResponseEntity.ok(pagamento_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pagamento> deletePagamento(@PathVariable Long id) {
        log.info("Deletando o Pagamento de ID: " + id);
        pagamentoRepository.delete(getPagamentoById(id));
        return ResponseEntity.noContent().build();
    }

    private Pagamento getPagamentoById(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado com o ID: " + id));
    }
}
