package br.edu.ifg.controll;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import br.edu.ifg.model.ModeloEvento;
import br.edu.ifg.modelDAO.EventoDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.AtividadeAluno;

public class ControleAluno {
	
	private Aluno a;
	private AtividadeAluno b;
	
	public ControleAluno(Aluno a) {
		this.a = a;
		carregaTabelaEvt();
	}

	
	public void carregaTabelaEvt(){
		EventoDAO ev = new EventoDAO();
		Vector<Vector<String>> v = ev.buscaEventos();
		
		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Nome do evento");
		colunas.add("Organizador");
		colunas.add("Data de inicio");
		colunas.add("Data de encerramento");
		colunas.add("Local");
		colunas.add("");
		colunas.add("");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		a.getTable().setModel(modelo);
	}
	
	public void carregaTabelaAtv(){
		EventoDAO ev = new EventoDAO();
		Vector<Vector<String>> v = ev.buscaEventos();
		
		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Nome atv.");
		colunas.add("Descrição");
		colunas.add("Ministrante");
		colunas.add("Data");
		colunas.add("Hora inicio");
		colunas.add("Hora fim");
		colunas.add("CHH");
		colunas.add("Vagas");
		colunas.add("");
		colunas.add("");


		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		b.getTable().setModel(modelo);
		
	}
	
}
