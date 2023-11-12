package br.com.fiap.CashFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.TipoCredito;

public interface TipoCreditoRepository extends JpaRepository<TipoCredito, Long> {
<<<<<<< HEAD

=======
    List<TipoCredito> findByNome(String nome);
    List<TipoCredito> findByNomeStartsWith(String letra);
>>>>>>> 9f1c0bd1921c02396e0ee2d6e055f32268e66ec9
}
