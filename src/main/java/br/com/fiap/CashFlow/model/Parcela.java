package br.com.fiap.CashFlow.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
>>>>>>> 9f1c0bd1921c02396e0ee2d6e055f32268e66ec9
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
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
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parcela", nullable = false)
    private Long id;

    @NotNull
    @Positive
    @Column(name = "num_parcela", nullable = false)
    private Long numero;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_vencimento", nullable = false)
    private Date dataVencimento;

    @Positive
    @Column(name = "valor_parcela", nullable = false)
    private float valor;

    @NotNull
    @NotBlank
    @Column(name = "status_pagamento", nullable = false)
    private String statusPagamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_emprestimo", referencedColumnName = "id_emprestimo")
    private Emprestimo emprestimo;
}
