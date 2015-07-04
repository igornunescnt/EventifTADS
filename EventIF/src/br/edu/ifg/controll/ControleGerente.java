package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import br.edu.ifg.modelDAO.AtividadeDAO;
import br.edu.ifg.view.CadastrarEvento;
import br.edu.ifg.view.GerenciarAluno;
import br.edu.ifg.view.GerenciarCertificados;
import br.edu.ifg.view.GerenciarEvento;
import br.edu.ifg.view.GerenciarMonitor;
import br.edu.ifg.view.Gerente;

public class ControleGerente {


	//Gerente g = new Gerente();

	public ControleGerente(Gerente g) {
		g.getBtnGerenciarEvento().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				GerenciarEvento ge = new GerenciarEvento();
				g.getFrmEventifGerente().dispose();
				ge.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ge.getFrmEventifGerente().dispose();
						Gerente g1 = new Gerente();
						ControleGerente c1 = new ControleGerente(g1);
					}
				});
				ge.getBtnCadastrar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ge.getFrmEventifGerente().dispose();
						CadastrarEvento ce = new CadastrarEvento();
						ce.getBtnVoltar().addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								ce.getFrmEventifCadastrar().dispose();
								GerenciarEvento ge = new GerenciarEvento();
							}
						});
					}
				});
			}
		});





		g.getBtnGerenciarParticipante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GerenciarAluno ga = new GerenciarAluno();
				g.getFrmEventifGerente().dispose();
				ga.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ga.getFrmEventifAluno().dispose();
						Gerente g1 = new Gerente();
						ControleGerente c1 = new ControleGerente(g1);						
					}
				});
			}
		});

		g.getBtnNewButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GerenciarMonitor gm = new GerenciarMonitor();
				g.getFrmEventifGerente().dispose();
				gm.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						gm.getFrmEventifMonitor().dispose();
						Gerente g1 = new Gerente();
						ControleGerente c1 = new ControleGerente(g1);						
					}
				});
			}
		});
		
		g.getBtnGerenciarCertificado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				g.getFrmEventifGerente().dispose();
				GerenciarCertificados gc = new GerenciarCertificados();
				gc.getBtnGerarCertificado().addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				gc.getBtnVoltar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						gc.getFrmEventifGcertif().dispose();
						Gerente g1 = new Gerente();
						ControleGerente c1 = new ControleGerente(g1);
					}
				});
				
				CarregaTabelaAluno(gc);
				
			}
		});
		

	}

	public void CarregaTabelaAluno(GerenciarCertificados g){
		
			AtividadeDAO a = new AtividadeDAO();
			Vector<Vector<String>> v = a.carregarTabelaAluno();
			
			Vector<String> colunas = new Vector<String>();
			colunas.add("Matricula");
			colunas.add("Nome do aluno");
			colunas.add("Frequencia");
			
			DefaultTableModel modelo = new DefaultTableModel(v,colunas);
			g.getTable().setModel(modelo);
		
	}
}
