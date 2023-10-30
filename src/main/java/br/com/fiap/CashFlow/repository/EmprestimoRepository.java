package br.com.fiap.CashFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
