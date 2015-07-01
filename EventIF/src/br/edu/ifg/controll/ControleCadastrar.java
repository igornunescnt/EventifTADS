package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.CadastrarPessoa;

public class ControleCadastrar {
	
	CadastrarPessoa c = null;

	public ControleCadastrar(CadastrarPessoa c) {
		this.c = c;
		AlunoDAO a1 = new AlunoDAO();
		carregaEstados(a1);
		
		
		c.getCbUf().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(c.getCbUf().getSelectedIndex() != 0){
					c.getCbCidade().removeAllItems();
					c.getCbCidade().setEnabled(true);
					int idEstado = c.getCbUf().getSelectedIndex();
					carregaCidades(a1.Cidade(idEstado));
				}
				else{
					c.getCbCidade().setEnabled(false);
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
	
	public void carregaEstados(AlunoDAO a){
		try {
			ResultSet r = a.Estado();

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
	}

	public void carregaCidades(ResultSet rs){
		
		
		try {

			while(rs.next()){
				c.getCbCidade().addItem(rs.getString("nomecidade"));
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
	
	public void addEventoBotao(){
		
	}
}
