package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import QrCode.ExNativeAccessWebcam;
import br.edu.ifg.modelDAO.AtividadeDAO;
import br.edu.ifg.modelDAO.EventoDAO;
import br.edu.ifg.view.AtividadeMonitor;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.Login;
import br.edu.ifg.view.Monitor;

public class ControleMonitor {
	
	private Monitor m;
	private AtividadeMonitor am;
	private CadastrarPessoa cp;
	
	public ControleMonitor(Monitor m, AtividadeMonitor am ) {
		this.am = am;
		this.m = m;	
		addEventoBotao(am);
		carregaTabelaEvt();
		botaoTabela(am,m);
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
		colunas.add("Visualizar Ativ.");
		
		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		m.getTable().setModel(modelo);
		m.getTable().getColumnModel().getColumn(0).setPreferredWidth(30);
		m.getTable().getColumnModel().getColumn(1).setPreferredWidth(60);
		m.getTable().getColumnModel().getColumn(5).setPreferredWidth(60);
	}
	
	public void carregaTabelaAtv(int id,AtividadeMonitor am){
		
		AtividadeDAO ev = new AtividadeDAO();
		Vector<Vector<String>> v = ev.buscaEventos(id);
		
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
		colunas.add("Registrar presença");


		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		//AtividadeMonitor am = new AtividadeMonitor();
		am.getTable().setModel(modelo);
		am.getTable().getColumnModel().getColumn(0).setPreferredWidth(30);
		am.getTable().getColumnModel().getColumn(1).setPreferredWidth(60);
		am.getTable().getColumnModel().getColumn(5).setPreferredWidth(60);

		am.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				am.getFrmEventifMonitor().dispose();
				m.getFrmEventifMonitor();
			}
		});
		
	}
	
	private void botaoTabela(AtividadeMonitor am, Monitor m){
		m.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = m.getTable().getSelectedRow();
				int coluna = m.getTable().getSelectedColumn();
				int id = Integer.parseInt((String)m.getTable().getValueAt(linha, 0));
				
				//System.out.println(linha+" "+coluna);
				switch (coluna) {
				
				case 6:
					AtividadeMonitor am = new AtividadeMonitor();
					carregaTabelaAtv(id,am);
					break;
				}
				
			}
		});
	}
	
	public void addEventoBotao(AtividadeMonitor am){
		m.getBtnSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				m.getFrmEventifMonitor().dispose();
				Login l = new Login();
				ControleLogin cl = new ControleLogin(l);
			}
		});
	
	}

}
