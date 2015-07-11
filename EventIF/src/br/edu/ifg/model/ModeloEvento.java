package br.edu.ifg.model;

import java.util.Calendar;


public class ModeloEvento {
	private long id;
	private String nomeEvento;
	private String organizadorEvento;
	private Calendar dataInicio;
	private Calendar datafim;
	private String local;
	private ModeloEnderecoEvento endereco = new ModeloEnderecoEvento();
	
	public ModeloEnderecoEvento getEndereco() {
		return endereco;
	}
	public void setEndereco(ModeloEnderecoEvento endereco) {
		this.endereco = endereco;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getOrganizadorEvento() {
		return organizadorEvento;
	}
	public void setOrganizadorEvento(String organizadorEvento) {
		this.organizadorEvento = organizadorEvento;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDatafim() {
		return datafim;
	}
	public void setDatafim(Calendar datafim) {
		this.datafim = datafim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
}
