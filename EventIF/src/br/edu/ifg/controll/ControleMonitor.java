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
		botaoTabela(am);
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
		
		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		m.getTable().setModel(modelo);
	}
	
	public void carregaTabelaAtv(int id){
		
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
		colunas.add("Visualizar atividades");


		DefaultTableModel modelo = new DefaultTableModel(v,colunas);
		AtividadeMonitor am = new AtividadeMonitor();
		am.getTable().setModel(modelo);
		
		am.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				am.getFrmEventifMonitor().dispose();
				m.getFrmEventifMonitor();
			}
		});
		
	}
	
	private void botaoTabela(AtividadeMonitor am){
		m.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = m.getTable().getSelectedRow();
				int coluna = m.getTable().getSelectedColumn();
				int id = Integer.parseInt((String)m.getTable().getValueAt(linha, 0));
				
				System.out.println(linha+" "+coluna);
				switch (coluna) {
				
				case 6:
					//am.getFrmEventifMonitor();
					carregaTabelaAtv(id);
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
