package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.model.ModeloPessoa;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.modelDAO.LoginDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.AtividadeAluno;
import br.edu.ifg.view.AtividadeMonitor;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.GerenciarEvento;
import br.edu.ifg.view.Gerente;
import br.edu.ifg.view.Login;
import br.edu.ifg.view.Monitor;

public class ControleLogin {

	private Login l;
	private AtividadeMonitor am;
	private GerenciarEvento ge;
	private AtividadeAluno aa = null;
	ModeloPessoa p = new ModeloPessoa();
	AlunoDAO ad = new AlunoDAO();
	
	
	public ControleLogin(Login l){
		this.l = l;
		adicionaEventos();

	}

	public void verificaResposta(boolean resposta){
		if(resposta == true){

			if(l.getRdbtnAluno().isSelected()) {
				l.getFrmEventifLogin().dispose();
				Aluno a1 = new Aluno();
				ControleAluno c1 = new ControleAluno(a1,aa);
			}else if (l.getRdbtnGerente().isSelected()){
				l.getFrmEventifLogin().dispose();
				Gerente g1 = new Gerente();
				ControleGerente g = new ControleGerente(g1,ge);					

			}else if(l.getRdbtnMonitor().isSelected()){
				l.getFrmEventifLogin().dispose();
				Monitor m1 = new Monitor();
				ControleMonitor cm = new ControleMonitor(m1,am);
			} 
		}else {
			JOptionPane.showMessageDialog(null, "Dados incorretos, tente novamente!");
			l.getPasswordField().setText("");
		}
	}

	public void adicionaEventos(){
		l.getButton_1().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				LoginDAO dao = new LoginDAO();

				if(l.getTextField().getText().equals("") || p.validarCpf(l.getTextField().getText()) == false  ||
						l.getPasswordField().getText().equals("") ){
					JOptionPane.showMessageDialog(null, "Acesso não permitido.");

				}else{
					if(l.getRdbtnAluno().isSelected()){
						verificaResposta(dao.consultar(l.getTextField().getText(),l.getPasswordField().getText(), ModeloPessoa.pessoaaluno));
					}else if(l.getRdbtnGerente().isSelected()){
						verificaResposta(dao.consultar(l.getTextField().getText(),l.getPasswordField().getText(), ModeloPessoa.pessoagerente));
					}else if (l.getRdbtnMonitor().isSelected()){
						verificaResposta(dao.consultar(l.getTextField().getText(),l.getPasswordField().getText(), ModeloPessoa.pessoamonitor));
					}
				}
			}
		});

		if(l.getRdbtnAluno().isSelected()){

			l.getBtnCadastrese().addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if(l.getRdbtnGerente().isSelected() || l.getRdbtnMonitor().isSelected()){
						l.getBtnCadastrese().disable();
					}else  {
						l.getFrmEventifLogin().dispose();
						CadastrarPessoa c = new CadastrarPessoa();
						ControleCadastrar d = new ControleCadastrar(c); 
					}}
			});
		}}



}
