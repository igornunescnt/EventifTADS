package br.edu.ifg.model;

public class ModeloEnderecoEvento {
	
	private long id;
	private String rua;
	private String numero;
	private String bairro;
	private long cidade;
	private String complemento;
	private long uf;
	private String cep;
	
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public long getCidade() {
		return cidade;
	}
	public void setCidade(long cidade) {
		this.cidade = cidade;
	}
	public long getUf() {
		return uf;
	}
	public void setUf(long uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
		
}
