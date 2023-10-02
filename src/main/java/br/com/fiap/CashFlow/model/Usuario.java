package br.com.fiap.CashFlow.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

	@Id @GeneratedValue
    @Column(name = "id_usuario")
    private Long id;
	
    private String imagem;

    @NotBlank @Size(min = 7, message = "Nome precisa ter no mínimo 7 caracteres!")
    private String nome;

    @Email @NotBlank @Size(min = 7, message = "Email precisa ter no mínimo 7 caracteres!")
    private String email;

    private String telefone;

    @NotBlank @Size(min = 11)
    private String cpf;

    @Past(message = "Data de nascimento inválida!")
    @JsonFormat(pattern = "DD/MM/YYYY")
    private Date dataNascimento;

    @NotBlank @Size(min = 8)
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String localidade;

    @NotBlank
    private String numero;

    @NotBlank
    private String uf;

    @Min(value = 0, message = "Valor não pode ser negativo!")
    private float valorDivida;
}