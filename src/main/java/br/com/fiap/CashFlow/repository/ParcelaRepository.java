package br.com.fiap.CashFlow.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Parcela;
import org.springframework.data.domain.Page;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    Page<Parcela> findByStatusPagamentoContainingIgnoreCase(String statusPagamento, Pageable pageRequest);
}
