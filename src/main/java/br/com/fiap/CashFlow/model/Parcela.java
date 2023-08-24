package br.com.fiap.CashFlow.model;

import java.util.Date;

public class Parcela {
    private int id;
    private int numero;
    private Date dataVencimento;
    private float valor;
    private String statusPagamento;
    private Emprestimo emprestimo;

    public Parcela(int id, int numero, Date dataVencimento, float valor, String statusPagamento, Emprestimo emprestimo) {
        this.id = id;
        this.numero = numero;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.emprestimo = emprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
}
