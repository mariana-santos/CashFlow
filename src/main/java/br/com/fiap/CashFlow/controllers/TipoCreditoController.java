package br.com.fiap.CashFlow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.CashFlow.model.TipoCredito;

@RestController
public class TipoCreditoController {
    
    @GetMapping("/tiposCredito")

    public TipoCredito index(){

        return new TipoCredito("Empréstimo Pessoal", 3, 30, 12000);
        
    }
}
