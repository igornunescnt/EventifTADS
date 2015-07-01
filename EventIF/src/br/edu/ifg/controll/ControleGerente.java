package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.view.GerenciarAluno;
import br.edu.ifg.view.GerenciarEvento;
import br.edu.ifg.view.GerenciarMonitor;
import br.edu.ifg.view.Gerente;

public class ControleGerente {
	
	
	Gerente g = new Gerente();
	
	public ControleGerente() {
		g.getBtnGerenciarEvento().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				GerenciarEvento ge = new GerenciarEvento();
				//ge.getFrmEventifGerente().setVisible(true);
			}
		});
		
		g.getBtnGerenciarParticipante().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GerenciarAluno ga = new GerenciarAluno();
			}
		});
		
		g.getBtnNewButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GerenciarMonitor gm = new GerenciarMonitor();
			}
		});
	}
	

}
