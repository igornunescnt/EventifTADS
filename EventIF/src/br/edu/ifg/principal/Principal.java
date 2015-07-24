package br.edu.ifg.principal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.edu.ifg.controll.ControleAluno;
import br.edu.ifg.controll.ControleCadastrar;
import br.edu.ifg.controll.ControleLogin;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.GerenciarEvento;
import br.edu.ifg.view.Login;

public class Principal {


	public static void main(String[] args) {

		Login l = new Login();
		ControleLogin cl = new ControleLogin(l);
	}

}
