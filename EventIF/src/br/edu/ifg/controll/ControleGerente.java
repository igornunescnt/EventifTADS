package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import QrCode.ExNativeAccessWebcam;
import br.edu.ifg.model.ModeloEvento;
import br.edu.ifg.modelDAO.AtividadeDAO;
import br.edu.ifg.modelDAO.ControleEvento;
import br.edu.ifg.modelDAO.EventoDAO;
import br.edu.ifg.modelDAO.PresencaDAO;
import br.edu.ifg.view.CadastrarEvento;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.GerenciarAluno;
import br.edu.ifg.view.GerenciarCertificados;
import br.edu.ifg.view.GerenciarCrachas;
import br.edu.ifg.view.GerenciarEvento;
import br.edu.ifg.view.GerenciarMonitor;
import br.edu.ifg.view.Gerente;
import br.edu.ifg.view.Login;

public class ControleGerente {
	
	private CadastrarPessoa cp = null;
	private GerenciarMonitor gm = null;
	private Gerente g = null;
	private EventoDAO ev =null;
	GerenciarEvento ge = null;
	ModeloEvento e = new ModeloEvento();


	public ControleGerente(Gerente g) {
		this.g = g;
		
		
		g.getBtnGerenciarEvento().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ge = new GerenciarEvento();
				carregaTabelaEvt(ge);
				g.getFrmEventifGerente().dispose();
				ge.getBtnPesquisar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Vector<Vector<String>> v = ev.pesquisarEvento(e);
						carregaTabelaPesquisar(v);
					}
				} );
				ge.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						g.getFrmEventifGerente().setVisible(true);
						ge.getFrmEventifGerente().dispose();
					}
				});
				ge.getBtnCadastrar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ge.getFrmEventifGerente().dispose();
						CadastrarEvento ce = new CadastrarEvento();
						ControleEvento c1 = new ControleEvento(ce);
						ce.getBtnVoltar().addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								ce.getFrmEventifCadastrar().dispose();
								ge.getFrmEventifGerente().setVisible(true);
							}
						});
					}
				});
			}
		});





		g.getBtnGerenciarParticipante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				g.getFrmEventifGerente().dispose();
				GerenciarAluno ga = new GerenciarAluno();
				//ControleGerente cg = new ControleGerente(g);
				ga.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						g.getFrmEventifGerente().setVisible(true);
						ga.getFrmEventifAluno().dispose();
						
					}
				});
				ga.getBtnCadastrar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ga.getFrmEventifAluno().dispose();
						CadastrarPessoa cp = new CadastrarPessoa();
						ControleCadastrarAluno cc = new ControleCadastrarAluno(cp, ga);
					}
				});
			}
		});

		g.getBtnNewButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm = new GerenciarMonitor();
				g.getFrmEventifGerente().dispose();
				gm.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						gm.getFrmEventifMonitor().dispose();
						g.getFrmEventifGerente().setVisible(true);
					}
				});
				
				gm.getBtnCadastrar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						gm.getFrmEventifMonitor().dispose();
						cp = new CadastrarPessoa();
						ControleCadastrarMonitor cm = new ControleCadastrarMonitor(cp, gm);
					}
				});

			}
		});
		
		g.getBtnGerenciarCrach().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.getFrmEventifGerente().dispose();
				GerenciarCrachas c = new GerenciarCrachas();
				c.getBtnVoltar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						c.getFrmEventifGerente().dispose();
						g.getFrmEventifGerente().setVisible(true);
					}
				});
			}
		});

		g.getBtnGerenciarCertificado().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				g.getFrmEventifGerente().dispose();
				GerenciarCertificados gc = new GerenciarCertificados();
				CarregaTabelaAluno(gc);
				gc.getBtnGerarCertificado().addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {

					}
				});
				gc.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gc.getFrmEventifGcertif().dispose();
						g.getFrmEventifGerente().setVisible(true);
		
					}
				});
			}
		});
		g.getBtnSair().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				ControleLogin cl = new ControleLogin(l);
				g.getFrmEventifGerente().dispose();

			}
		});
		
	}

	public void CarregaTabelaAluno(GerenciarCertificados g){

		PresencaDAO a = new PresencaDAO();
		Vector<Vector<String>> v = a.carregarTabelaAluno();

		Vector<String> colunas = new Vector<String>();
		colunas.add("Matricula");
		colunas.add("Nome do aluno");
		colunas.add("Frequencia");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		g.getTable().setModel(modelo);

	}
	
	public void carregaTabelaEvt(GerenciarEvento ge){
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

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		ge.getTable().setModel(modelo);
	}
	
	public void carregaTabelaPesquisar(Vector<Vector<String>> v){
		
		e.setNomeEvento(ge.getTextField().getText());
		
		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Nome do evento");
		colunas.add("Organizador");
		colunas.add("Data de inicio");
		colunas.add("Data de encerramento");
		colunas.add("Local");
		colunas.add("");
		
		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		ge.getTable().setModel(modelo);
	}
	
	

}
