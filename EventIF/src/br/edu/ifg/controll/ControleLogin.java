package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.AtividadeAluno;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.Gerente;
import br.edu.ifg.view.Login;
import br.edu.ifg.view.Monitor;

public class ControleLogin {
	
	private Login l;
	
	public ControleLogin(Login l){
		this.l = l;
		adicionaEventos();
	}
	
	public void adicionaEventos(){
		l.getButton_1().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(l.getTextField().getText().equals("") || l.getTextField_1().getText().equals("")){
					JOptionPane.showMessageDialog(null, "preencha todos os campos.");
				}else if(l.getRdbtnAluno().isSelected()) {
					// fazer altenticação do  aluno.
					l.getFrmEventifLogin().dispose();
					Aluno a1 = new Aluno();
					ControleAluno c1 = new ControleAluno(a1);
				}else if (l.getRdbtnGerente().isSelected()){
					l.getFrmEventifLogin().dispose();
					Gerente g1 = new Gerente();
					ControleGerente g = new ControleGerente();
				}else if(l.getRdbtnMonitor().isSelected()){
					l.getFrmEventifLogin().dispose();
					Monitor m1 = new Monitor();
				}
			}
		});
		
		l.getBtnCadastrese().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				l.getFrmEventifLogin().dispose();
				CadastrarPessoa c = new CadastrarPessoa();
				ControleCadastrar d = new ControleCadastrar(c); 
			}
		});
	}

}
