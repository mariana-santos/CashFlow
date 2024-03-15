package br.com.fiap.CashFlow.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
	
    @Column(name = "img_usuario")
    private String imagem;

    @NotNull
    @NotBlank @Size(min = 7, message = "Nome precisa ter no mínimo 7 caracteres!")
    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Email
    @NotNull
    @NotBlank @Size(min = 7, message = "Email precisa ter no mínimo 7 caracteres!")
    @Column(name = "email_usuario", nullable = false)
    private String email;

    @NotNull
    @NotBlank @Size(min = 7, message = "Senha precisa ter no mínimo 7 caracteres!")
    @Column(name = "senha_usuario", nullable = false)
    private String senha;

    @NotNull
    @NotBlank
    @Column(name = "tel_usuario", nullable = false)
    private String telefone;

    @NotNull
    @NotBlank @Size(min = 11)
    @Column(name = "cpf_usuario", nullable = false)
    private String cpf;

    @Past(message = "Data de nascimento inválida!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dtnasc_usuario", nullable = false)
    private Date dataNascimento;

    @NotNull
    @NotBlank @Size(min = 8)
    @Column(name = "cep_usuario", nullable = false)
    private String cep;

    @NotNull
    @NotBlank
    @Column(name = "logradouro_usuario", nullable = false)
    private String logradouro;

    @NotNull
    @NotBlank
    @Column(name = "localidade_usuario", nullable = false)
    private String localidade;

    @NotNull
    @NotBlank
    @Column(name = "num_end_usuario", nullable = false)
    private String numero;

    @NotNull
    @NotBlank
    @Column(name = "uf_usuario", nullable = false)
    private String uf;

    @NotNull
    @Positive
    @Column(name = "divida_usuario", nullable = false)
    private float valorDivida;

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}