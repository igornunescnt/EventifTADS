package br.edu.ifg.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class ModeloAtividade {
	
	private long id;
	private String nome;
	private long idEvento;
	private String descricao;
	private String ministrante;
	private Timestamp horaInicio;
	private Timestamp horaFim;
	private Calendar data;
	private long idTipoAtividade;
	private int chh;
	private int vagas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMinistrante() {
		return ministrante;
	}
	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}
	public Timestamp getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Timestamp getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Timestamp horaFim) {
		this.horaFim = horaFim;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public long getIdTipoAtividade() {
		return idTipoAtividade;
	}
	public void setIdTipoAtividade(long idTipoAtividade) {
		this.idTipoAtividade = idTipoAtividade;
	}
	public int getChh() {
		return chh;
	}
	public void setChh(int chh) {
		this.chh = chh;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	


}
