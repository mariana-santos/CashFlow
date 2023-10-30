package br.com.fiap.CashFlow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Renda {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_renda", nullable = false)
    private Long id;

	@NotNull
    @NotBlank
    @Column(name = "fonte_renda", nullable = false)
    private String fonte;

	@Positive
    @Column(name = "valor_renda", nullable = false)
    private float valor;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
