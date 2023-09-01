package br.com.fiap.CashFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float taxaJuros;
    private int limiteMeses;
    private float rendaNecessaria;

    public TipoCredito(){ }

    public TipoCredito(String nome, float taxaJuros, int limiteMeses, float rendaNecessaria) {
        this.nome = nome;
        this.taxaJuros = taxaJuros;
        this.limiteMeses = limiteMeses;
        this.rendaNecessaria = rendaNecessaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getlimiteMeses() {
        return limiteMeses;
    }

    public void setLimiteMeses(int limiteMeses) {
        this.limiteMeses = limiteMeses;
    }

    public float getRendaNecessaria() {
        return rendaNecessaria;
    }

    public void setRendaNecessaria(float rendaNecessaria) {
        this.rendaNecessaria = rendaNecessaria;
    }

    @Override
    public String toString() {
        return "TipoCredito [nome=" + nome + ", taxaJuros=" + taxaJuros + ", limiteMeses=" + limiteMeses
                + ", rendaNecessaria=" + rendaNecessaria + "]";
    }
}
