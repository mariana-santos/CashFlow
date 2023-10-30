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

import br.com.fiap.CashFlow.model.Emprestimo;
import br.com.fiap.CashFlow.repository.EmprestimoRepository;

@RestController
@RequestMapping("emprestimos")
@Slf4j
public class EmprestimoController {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<Emprestimo> listAll() {
        log.info("Buscando Todos os Emprestimos");
        return emprestimoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Emprestimo> readEmprestimo(@PathVariable Long id) {
        log.info("Exibindo o Emprestimo de ID: " + id);
        return ResponseEntity.ok(getEmprestimoById(id));
    }

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody @Valid Emprestimo novo_emprestimo) {
        log.info("Cadastrando Emprestimo: " + novo_emprestimo);
        emprestimoRepository.save(novo_emprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_emprestimo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Emprestimo> updateEmprestimo(@PathVariable @Valid Long id,
            @RequestBody Emprestimo emprestimo_atualizar) {
        log.info("Atualizando o Emprestimo de ID: " + id);
        getEmprestimoById(id);
        emprestimo_atualizar.setId(id);
        emprestimoRepository.save(emprestimo_atualizar);
        return ResponseEntity.ok(emprestimo_atualizar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Emprestimo> deleteEmprestimo(@PathVariable Long id) {
        log.info("Deletando o Emprestimo de ID: " + id);
        emprestimoRepository.delete(getEmprestimoById(id));
        return ResponseEntity.noContent().build();
    }

    private Emprestimo getEmprestimoById(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo não encontrado com o ID: " + id));
    }
}
