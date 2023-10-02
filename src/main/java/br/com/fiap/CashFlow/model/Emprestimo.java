package br.com.fiap.CashFlow.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_usuario",
            referencedColumnName = "id_usuario"
    )
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "id_tipo_credito",
            referencedColumnName = "id_tipo_credito"
    )
    private TipoCredito tipoCredito;

    @Positive(message = "Valor de empréstimo deve ser positivo!")
    private float valorContratado;

    @Positive
    private float taxaJuros;

    @Positive
    private int numeroParcelas;

    @Positive
    private float valorParcela;

    @Positive
    private float valorTotal;
}
