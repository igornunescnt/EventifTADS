package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.model.ModeloPessoa;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.modelDAO.LoginDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.AtividadeAluno;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.Gerente;
import br.edu.ifg.view.Login;
import br.edu.ifg.view.Monitor;

public class ControleLogin {

	private Login l;
	ModeloPessoa p = new ModeloPessoa();
	AlunoDAO ad = new AlunoDAO();
	public ControleLogin(Login l){
		this.l = l;
		adicionaEventos();

	}

	public void adicionaEventos(){
		l.getButton_1().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				LoginDAO dao = new LoginDAO();

				boolean resposta = dao.consultar(l.getTextField().getText(),l.getPasswordField().getText()); 

				if(l.getTextField().getText().equals("") || p.validarCpf(l.getTextField().getText()) == false  ||
						l.getPasswordField().getText().equals("") ){
					JOptionPane.showMessageDialog(null, "Acesso não permitido.");
				
				}else if(resposta == true){

					if(l.getRdbtnAluno().isSelected()) {
						// fazer altenticação do  aluno.
						l.getFrmEventifLogin().dispose();
						Aluno a1 = new Aluno();
						ControleAluno c1 = new ControleAluno(a1);
					}else if (l.getRdbtnGerente().isSelected()){						
						l.getFrmEventifLogin().dispose();
						Gerente g1 = new Gerente();
						ControleGerente g = new ControleGerente(g1);					

					}else if(l.getRdbtnMonitor().isSelected()){
						l.getFrmEventifLogin().dispose();
						Monitor m1 = new Monitor();
						ControleMonitor cm = new ControleMonitor(m1);
					} 
				}else {
					JOptionPane.showMessageDialog(null, "Dados incorretos, tente novamente!");
					l.getPasswordField().setText("");
				}
			}
		});

		l.getBtnCadastrese().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(l.getRdbtnGerente().isSelected() || l.getRdbtnMonitor().isSelected()){
					l.getBtnCadastrese().setSelected(false);
				}else  {
					l.getFrmEventifLogin().dispose();
					CadastrarPessoa c = new CadastrarPessoa();
					ControleCadastrar d = new ControleCadastrar(c); 
				}}
		});
	}



}
