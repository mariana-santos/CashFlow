package br.com.fiap.CashFlow.model;

import java.util.Date;

public class Usuario {
    private int id;
    private String imagem;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Date dataNascimento;
    private String cep;
    private String logradouro;
    private String localidade;
    private String numero;
    private String uf;
    private float valor_divida;

    	public Usuario() {
	}

	public Usuario(int id, String imagem, String nome, String email, String telefone, String cpf, 
                        Date dataNascimento, String cep, String logradouro, String localidade, String numero, String uf, float valor_divida) {
		this.id = id;
		this.imagem = imagem;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.numero = numero;
		this.uf = uf;
		this.valor_divida = valor_divida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}
    	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

    public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUF() {
		return uf;
	}

	public void setUF(String uf) {
		this.uf = uf;
	}

    public float getValorDivida() {
        return valor_divida;
    }

    public void setValorDivida(float valor_divida){
        this.valor_divida = valor_divida;
    }
	
}