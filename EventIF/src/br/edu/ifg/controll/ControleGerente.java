package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.view.GerenciarAluno;
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
				//ge.getFrmEventifGerente().setVisible(true);
				ge.getBtnVoltar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ge.getFrmEventifGerente().dispose();
						Gerente g1 = new Gerente();
						ControleGerente c1 = new ControleGerente(g1);
					}
				});
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
