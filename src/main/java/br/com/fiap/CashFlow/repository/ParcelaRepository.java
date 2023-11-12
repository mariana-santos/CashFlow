package br.com.fiap.CashFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

}
