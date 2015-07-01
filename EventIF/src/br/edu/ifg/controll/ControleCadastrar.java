package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.CadastrarPessoa;

public class ControleCadastrar {
	
	CadastrarPessoa c = new CadastrarPessoa();

	public ControleCadastrar() {
		AlunoDAO a1 = new AlunoDAO();
		adicionarEvento(a1);
		
		
		c.getCbUf().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(c.getCbUf().getSelectedIndex() != 0){
					c.getCbCidade().setEnabled(true);
				}
			}
		});
	c.getCbCidade().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			c.getCbCidade().getSelectedItem();
			System.out.println(c.getCbCidade().getSelectedIndex());
			
		}
	});
	}

	
	



	public void adicionarEvento(AlunoDAO a){
		
		
		try {
			ResultSet rs = a.Cidade();
			ResultSet r = a.Estado();

			while(rs.next()){
				c.getCbCidade().addItem(rs.getString("nomecidade"));
			}
			while(r.next()){
				c.getCbUf().addItem(r.getString("ufestado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (c.getCbUf().getSelectedIndex()==0){
			c.getCbCidade().setEnabled(false);
		}
		else {
			
		}

	}
	
	
}
