package br.edu.ifg.model;


public class ModeloGerente  {

	ModeloPessoa g = new ModeloPessoa();
	private int siape;
	
	public ModeloPessoa getG() {
		return g;
	}
	public void setG(ModeloPessoa g) {
		this.g = g;
	}
	public int getCiape() {
		return siape;
	}
	public void setCiape(int ciape) {
		this.siape = ciape;
	}
	
	

}