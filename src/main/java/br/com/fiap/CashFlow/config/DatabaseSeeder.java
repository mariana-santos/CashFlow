package br.com.fiap.CashFlow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fiap.CashFlow.model.*;
import br.com.fiap.CashFlow.repository.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    ParcelaRepository parcelaRepository;

    @Autowired
    TipoCreditoRepository tipoCreditoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        TipoCredito tipoCredito = new TipoCredito(null, "Credito Pessoal", 10f, 12L, 1000.0f);
        tipoCreditoRepository.save(tipoCredito);

        Usuario usuario = new Usuario(null, null, "Mariana Santos", "mariana@gmail.com", "707070", "000.000.000-00", new Date(), "00000000", "rua exemplo", "São Paulo", "123", "SP", 700.0f);
        
        usuarioRepository.save(usuario);        

        List<Parcela> parcelas = new ArrayList<>();

        Emprestimo emprestimo = new Emprestimo(null, usuario, tipoCredito, 500.0f, 10L, 60.0f, 600.0f, null);

        for (int i = 1; i <= emprestimo.getNumeroParcelas(); i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, i * 30);

            Date dataVencimento = calendar.getTime();

            if (dataVencimento.before(new Date())) {
                throw new RuntimeException("Data de vencimento inválida!");
            }

            Parcela parcela = new Parcela(null, Long.valueOf(i), dataVencimento, emprestimo.getValorParcela(), "pendente", emprestimo);
            parcelas.add(parcela);
        }

        emprestimo.setParcelas(parcelas);
        emprestimoRepository.save(emprestimo);
    }
}
