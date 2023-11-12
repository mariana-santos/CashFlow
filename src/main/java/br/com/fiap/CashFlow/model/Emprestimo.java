package br.com.fiap.CashFlow.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "id_emprestimo", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "id_usuario",
            referencedColumnName = "id_usuario"
    )
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "id_tipo_credito",
            referencedColumnName = "id_tipo_credito"
    )
    private TipoCredito tipoCredito;

    @Positive(message = "Valor de empréstimo deve ser positivo!")
    @Column(name = "valor_contratado", nullable = false)
    private float valorContratado;

    @Positive
    @Column(name = "nm_parcelas", nullable = false)
    private Long numeroParcelas;

    @Positive
    @Column(name = "valor_parcela", nullable = false)
    private float valorParcela;

    @Positive
    @Column(name = "valor_total", nullable = false)
    private float valorTotal;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private List<Parcela> parcelas;
}
