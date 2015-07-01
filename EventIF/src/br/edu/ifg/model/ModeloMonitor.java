package br.edu.ifg.model;


public class ModeloMonitor {
	
	ModeloPessoa m = new ModeloPessoa();
	private long matricula;
	
	public ModeloPessoa getM() {
		return m;
	}
	public void setM(ModeloPessoa m) {
		this.m = m;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
}

