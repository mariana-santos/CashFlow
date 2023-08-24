package br.com.fiap.CashFlow.model;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private TipoCredito tipoCredito;
    private float valorContratado;
    private float taxaJuros;
    private int numeroParcelas;
    private float valorParcela;
    private float valorTotal;

    public Emprestimo(int id, Usuario usuario, TipoCredito tipoCredito,
                      float valorContratado, float taxaJuros,
                      int numeroParcelas, float valorParcela, float valorTotal) {
        this.id = id;
        this.usuario = usuario;
        this.tipoCredito = tipoCredito;
        this.valorContratado = valorContratado;
        this.taxaJuros = taxaJuros;
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
        this.valorTotal = valorTotal;
    }

    public int getIdEmprestimo() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public TipoCredito getTipoCredito() {
        return tipoCredito;
    }

    public float getValorContratado() {
        return valorContratado;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public float getValorTotal() {
        return valorTotal;
    }
}
