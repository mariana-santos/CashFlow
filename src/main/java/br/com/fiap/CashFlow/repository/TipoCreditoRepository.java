package br.com.fiap.CashFlow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.CashFlow.model.TipoCredito;

public interface TipoCreditoRepository extends JpaRepository<TipoCredito, Long> {
    List<TipoCredito> findByNome(String nome);
    List<TipoCredito> findByNomeStartsWith(String letra);
}