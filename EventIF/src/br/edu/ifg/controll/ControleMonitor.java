package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.view.Login;
import br.edu.ifg.view.Monitor;

public class ControleMonitor {
	
	private Monitor m;
	
	public ControleMonitor(Monitor m) {
		this.m = m;
		addEventoBotao();
	}
	
	public void addEventoBotao(){
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
