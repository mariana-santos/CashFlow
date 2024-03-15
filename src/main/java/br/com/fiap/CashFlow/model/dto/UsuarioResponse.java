package br.com.fiap.CashFlow.model.dto;
import br.com.fiap.CashFlow.model.Usuario;

public record UsuarioResponse(
    Long id,
    String nome,
    String email
) {

    public static UsuarioResponse fromUsuario(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

}