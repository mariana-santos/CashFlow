package br.com.fiap.CashFlow.model;

public class Renda {
    private int id;
    private String fonte;
    private float valor;
    private Usuario usuario;

    public Renda() {
	}

	public Renda(int id, String fonte, float valor, Usuario usuario) {
		this.id = id;
		this.fonte = fonte;
		this.valor = valor;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public float getValor() {
        return valor;
	}

	public void getValor(float valor){
        this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
