package br.com.fiap.CashFlow.model;

import java.util.Date;

public class Pagamento {
    private int id;
    private Emprestimo emprestimo;
    private Date data;
    private float valor;

    public Pagamento(int id, Emprestimo emprestimo, Date data, float valor) {
        this.id = id;
        this.emprestimo = emprestimo;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}