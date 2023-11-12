package br.com.fiap.CashFlow.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

=======
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Parcela;
import org.springframework.data.domain.Page;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    Page<Parcela> findByStatusPagamentoContainingIgnoreCase(String statusPagamento, Pageable pageRequest);
>>>>>>> 9f1c0bd1921c02396e0ee2d6e055f32268e66ec9
}
