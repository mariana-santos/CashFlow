package br.com.fiap.CashFlow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.CashFlow.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // List<Emprestimo> findByNome(String nome);
    // List<Emprestimo> findByNomeStartsWith(String letra);
}