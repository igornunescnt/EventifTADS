package br.edu.ifg.model;



public class ModeloAluno {
	
	ModeloPessoa a = new ModeloPessoa();
	long matricula;
	
	public ModeloPessoa getA() {
		return a;
	}
	public void setA(ModeloPessoa a) {
		this.a = a;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
}
