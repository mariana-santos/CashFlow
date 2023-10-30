package br.com.fiap.CashFlow.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.CashFlow.model.*;
import br.com.fiap.CashFlow.repository.*;


@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    ParcelaRepository parcelaRepository;

    @Autowired
    RendaRepository rendaRepository;

    @Autowired
    TipoCreditoRepository tipoCreditoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private Emprestimo emprestimo1 = new Emprestimo(
        // Criar um emprestimo aqui com os atributos e fazer o restante das classes
    );

    @Override
    public void run(String... args) throws Exception {

        //EmprestimoRepository.saveAll(
                //List.of(emprestimo1)); // colocar os objetos criados de emprestimo aqui e fazer para outras classes

    }
}