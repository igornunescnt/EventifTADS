package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import br.edu.ifg.modelDAO.AtividadeDAO;
import br.edu.ifg.modelDAO.EventoDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.AtividadeAluno;
import br.edu.ifg.view.Login;

public class ControleAluno {

	private Aluno a;
	private AtividadeAluno aa;

	public ControleAluno(Aluno a,AtividadeAluno aa) {
		this.a = a;
		this.aa = aa;
		carregaTabelaEvt();
		addEventosBotao();
		botaoTabela(aa,a);
		//botaoVoltarAtv(aa);
	}


	public void carregaTabelaEvt(){
		EventoDAO ev = new EventoDAO();
		Vector<Vector<String>> v = ev.buscaEventos();

		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Evento");
		colunas.add("Organizador");
		colunas.add("inicio");
		colunas.add("fim");
		colunas.add("Local");
		colunas.add("Visualizar atividades");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		a.getTable().setModel(modelo);
	}

	public void carregaTabelaAtv(int id, AtividadeAluno aa,Aluno a){
		AtividadeDAO ev = new AtividadeDAO();
		Vector<Vector<String>> v = ev.buscaEventos(id);
		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Atividade");
		colunas.add("Descrição");
		colunas.add("Ministrante");
		colunas.add("Data");
		colunas.add("inicio");
		colunas.add("fim");
		colunas.add("CHH");
		colunas.add("Vagas");
		colunas.add("Cadastrar");
		colunas.add("Cancelar");



		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		//AtividadeAluno aa = new AtividadeAluno();
		aa.getTable().setModel(modelo);


		aa.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aa.getFrmEventifAluno().dispose();
				a.getFrameAluno().setVisible(true);
			}
		});

	}

	public void addEventosBotao(){

		a.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.getFrameAluno().dispose();
				Login n = new Login();
				ControleLogin cl = new ControleLogin(n);
			}
		});

	}

	private void botaoTabela(AtividadeAluno aa, Aluno a){
		a.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = a.getTable().getSelectedRow();
				int coluna = a.getTable().getSelectedColumn();
				int id = Integer.parseInt((String)a.getTable().getValueAt(linha, 0));

				//System.out.println(linha+" "+coluna);
				switch (coluna) {

				case 6:
					a.getFrameAluno().dispose();
					AtividadeAluno aa = new AtividadeAluno();
					carregaTabelaAtv(id,aa,a);
					break;
				}

			}
		});

	}
}
