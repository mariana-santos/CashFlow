package br.com.fiap.CashFlow.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeStartsWith(String letra);
}