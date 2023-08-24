package br.com.fiap.CashFlow.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.CashFlow.model.Usuario;

@RestController
public class UsuarioController {
    
    @GetMapping("/usuario")
    public Usuario index() {
        return new Usuario(1, null, "João de Lima", "joao@email.com", "(11) 9 9999-9999", "999.999.999-99", new Date(), "99999-999", "Av. Paulista", "São Paulo", "1100", "SP", 0);
    }
}
