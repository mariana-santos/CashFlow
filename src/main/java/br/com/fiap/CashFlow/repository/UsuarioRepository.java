package br.com.fiap.CashFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.CashFlow.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
