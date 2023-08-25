package br.com.fiap.CashFlow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.CashFlow.model.TipoCredito;

@RestController
public class TipoCreditoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<TipoCredito> tiposCredito = new ArrayList<>();
    
    @GetMapping("/tiposCredito")
    public List<TipoCredito> index(){
        return tiposCredito;
    }

    @PostMapping("/tiposCredito")
    public ResponseEntity<TipoCredito> create(@RequestBody TipoCredito tipoCredito){

        log.info("Cadastrando tipo de credito " + tipoCredito);
        tipoCredito.setId(tiposCredito.size() + 1L);

        tiposCredito.add(tipoCredito);

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCredito);

    }

    @GetMapping("/tiposCredito/{id}")
    public ResponseEntity<TipoCredito> show(@PathVariable Long id){

        log.info("Mostrar categoria com id "+ id);

        var tipoEncontrado = tiposCredito
                                .stream()
                                .filter( (tipoCredito) -> tipoCredito.getId().equals(id))
                                .findFirst();

        if(tipoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(tipoEncontrado.get());

    }

    @DeleteMapping("/tiposCredito/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        log.info("Deletando categoria com id "+ id);

        var tipoEncontrado = tiposCredito
                                .stream()
                                .filter( (tipoCredito) -> tipoCredito.getId().equals(id))
                                .findFirst();

        if(tipoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        tiposCredito.remove(tipoEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tiposCredito/{id}")
    public ResponseEntity<TipoCredito> update(@PathVariable Long id, @RequestBody TipoCredito tipoCredito){

        log.info("Atualizando dados do tipo de crédito com id " + id);

        var tipoEncontrado = tiposCredito
                                .stream()
                                .filter( (tc) -> tc.getId().equals(id))
                                .findFirst();

        if(tipoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        tiposCredito.remove(tipoEncontrado.get());
        tipoCredito.setId(id);
        tiposCredito.add(tipoCredito);

        return ResponseEntity.ok(tipoCredito);

    }
}
