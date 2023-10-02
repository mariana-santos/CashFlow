package br.com.fiap.CashFlow.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.CashFlow.model.Emprestimo;
import br.com.fiap.CashFlow.model.TipoCredito;
import br.com.fiap.CashFlow.repository.EmprestimoRepository;
import jakarta.validation.Valid;

@RestController
public class EmprestimoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EmprestimoRepository repository;

    @GetMapping("/emprestimo")
    public List<Emprestimo> index(){
        return repository.findAll();
    }

    @PostMapping("/emprestimo")
    public ResponseEntity<Emprestimo> create(@RequestBody @Valid Emprestimo emp){

        log.info("Cadastrando empréstimo " + emp);
        repository.save(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);

    }

    @GetMapping("/emprestimo/{id}")
    public ResponseEntity<Emprestimo> show(@PathVariable Long id){

        log.info("Mostrar empréstimo com id "+ id);
        return ResponseEntity.ok(getEmprestimoById(id));

    }

    @DeleteMapping("/emprestimo/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        log.info("Deletando empréstimo com id "+ id);

        getEmprestimoById(id);

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/emprestimo/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Long id, @RequestBody @Valid Emprestimo emprestimo){

        log.info("Atualizando dados do empréstimo com id " + id);

        getEmprestimoById(id);

        emprestimo.setId(id);
        repository.save(emprestimo);

        return ResponseEntity.ok(emprestimo);

    }

    private Emprestimo getEmprestimoById(Long id){
        return repository.findById(id).orElseThrow(() -> { 
             return new RuntimeException();
         });
     }
}