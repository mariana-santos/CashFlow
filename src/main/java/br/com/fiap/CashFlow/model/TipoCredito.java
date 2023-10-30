package br.com.fiap.CashFlow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class TipoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_credito")
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "nm_tipo_credito", nullable = false)
    private String nome;

    @Positive
    @Column(name = "txjuros_tipo_credito", nullable = false)
    private float taxaJuros;

    @Positive
    @Column(name = "lim_meses_tipo_credito", nullable = false)
    private Long limiteMeses;

    @Positive
    @Column(name = "ren_necess_tipo_credito", nullable = false)
    private float rendaNecessaria;

}
