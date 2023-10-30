package br.com.fiap.CashFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
