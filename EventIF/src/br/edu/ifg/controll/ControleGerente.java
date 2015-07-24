package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.edu.ifg.model.ModeloEvento;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.modelDAO.EventoDAO;
import br.edu.ifg.modelDAO.MonitorDAO;
import br.edu.ifg.modelDAO.PresencaDAO;
import br.edu.ifg.view.AtividadeAluno;
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
	private GerenciarEvento ge = null;
	private ModeloEvento e = null;
	private CadastrarEvento ce = null;
	private AtividadeAluno aa = null;
	private ControleEvento c;
	private GerenciarCertificados gc = null;

	public ControleGerente(Gerente g,GerenciarEvento ge) {
		this.g = g;
		eventoBotao();
	}

	public void eventoBotao() {
		g.getBtnGerenciarEvento().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				GerenciarEvento ge = new GerenciarEvento();
				carregaTabelaEvt(ge);
				botaoTabela(ge);

				g.getFrmEventifGerente().dispose();
				ge.getBtnPesquisar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ModeloEvento e = new ModeloEvento();
						e.setNomeEvento(ge.getTextField().getText());
						Vector<Vector<String>> v = ev.pesquisarEvento(e);
						carregaTabelaPesquisar(v);
					}
				} );
				ge.getBtnVoltar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Gerente g = new Gerente();
						ControleGerente cg = new ControleGerente(g, ge);
						ge.getFrmEventifGerente().dispose();
					}
				});
				ge.getBtnCadastrar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ge.getFrmEventifGerente().dispose();
						CadastrarEvento ce = new CadastrarEvento();
						ControleEvento c1 = new ControleEvento(ce,g,ge);

					}
				});
			}
		});


		g.getBtnGerenciarParticipante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				g.getFrmEventifGerente().dispose();
				GerenciarAluno ga = new GerenciarAluno();
				CarregaTabelaAluno(ga);
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
				CarregaTabelaMonitor(gm);
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
				CarregaTabelaAluno(c);
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

	public void CarregaTabelaMonitor(GerenciarMonitor gm){
		MonitorDAO m = new MonitorDAO();
		Vector<Vector<String>> rs = m.buscar();

		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Monitor");
		colunas.add("CPF");
		colunas.add("RG");
		colunas.add("Matricula");

		DefaultTableModel modelo = new DefaultTableModel(rs,colunas);
		gm.getTable().setModel(modelo);
	}

	public void CarregaTabelaAluno(GerenciarAluno ga){
		AlunoDAO a = new AlunoDAO();
		Vector<Vector<String>> v = a.buscar();

		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Aluno");
		colunas.add("CPF");
		colunas.add("RG");
		colunas.add("Matricula");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		ga.getTable().setModel(modelo);
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

	public void CarregaTabelaAluno(GerenciarCrachas g){

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
		colunas.add("Evento");
		colunas.add("Organizador");
		colunas.add("inicio");
		colunas.add("fim");
		colunas.add("Local");
		colunas.add("Atividades");
		colunas.add("Alterar");
		colunas.add("Excluir");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		ge.getTable().setModel(modelo);
		ge.getTable().getColumnModel().getColumn(0).setPreferredWidth(30);
	}


	public void carregaTabelaPesquisar(Vector<Vector<String>> v){
		ge.getTable().clearSelection();

		Vector<String> colunas = new Vector<String>();
		colunas.add("Id");
		colunas.add("Evento");
		colunas.add("Organizador");
		colunas.add("inicio");
		colunas.add("encerramento");
		colunas.add("Local");
		colunas.add("Alterar");
		colunas.add("Excluir");

		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		ge.getTable().setModel(modelo);
	}


	private void botaoTabela(GerenciarEvento ge){
		ge.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = ge.getTable().getSelectedRow();
				int coluna = ge.getTable().getSelectedColumn();
				int id = Integer.parseInt((String)ge.getTable().getValueAt(linha, 0));
				System.out.println(linha+" "+coluna);
				switch (coluna) {

				case 6:
					System.out.println(ge.getTable().getValueAt(linha, coluna));

					break;

				case 7:
				    TableModel model = (TableModel)e.getSource();
					String columnName = model.getColumnName(coluna);
				    Object data = model.getValueAt(linha, coluna);
				    ev.atualiza(data, columnName);
					break;
					}

				}
			});

		}


	}
