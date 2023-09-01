package br.com.fiap.CashFlow.controllers;

import java.util.ArrayList;
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

import br.com.fiap.CashFlow.model.TipoCredito;
import br.com.fiap.CashFlow.repository.TipoCreditoRepository;

@RestController
public class TipoCreditoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<TipoCredito> tiposCredito = new ArrayList<>();

    @Autowired
    TipoCreditoRepository repository;

    @GetMapping("/tiposCredito")
    public List<TipoCredito> index(){
        return repository.findAll();
    }

    @PostMapping("/tiposCredito")
    public ResponseEntity<TipoCredito> create(@RequestBody TipoCredito tipoCredito){

        log.info("Cadastrando tipo de credito " + tipoCredito);
        repository.save(tipoCredito);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCredito);

    }

    @GetMapping("/tiposCredito/{id}")
    public ResponseEntity<TipoCredito> show(@PathVariable Long id){

        log.info("Mostrar tipo de crédito com id "+ id);
        return ResponseEntity.ok(getTipoCreditoById(id));

    }

    @DeleteMapping("/tiposCredito/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        log.info("Deletando tipo de crédito com id "+ id);

        getTipoCreditoById(id);

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tiposCredito/{id}")
    public ResponseEntity<TipoCredito> update(@PathVariable Long id, @RequestBody TipoCredito tipoCredito){

        log.info("Atualizando dados do tipo de crédito com id " + id);

        getTipoCreditoById(id);

        tipoCredito.setId(id);
        repository.save(tipoCredito);

        return ResponseEntity.ok(tipoCredito);

    }

    private TipoCredito getTipoCreditoById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            return new RuntimeException(); 
        });
    }
}
