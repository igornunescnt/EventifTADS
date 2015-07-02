package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifg.model.ModeloAluno;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.Gerente;
import br.edu.ifg.view.Login;

public class ControleCadastrar {
	
	CadastrarPessoa c = null;
	AlunoDAO a1 = new AlunoDAO();


	public ControleCadastrar(CadastrarPessoa c) {
		this.c = c;
		carregaEstados(a1);
		EventoBotao(c);

		
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
	
	public void EventoBotao(CadastrarPessoa p){
		//CadastrarPessoa p = new CadastrarPessoa();
		p.getBtnVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.getFrmEventifCadastrarPessoa().dispose();
				Login a = new Login();
				ControleLogin c = new ControleLogin(a);
			}
		});
		
		p.getBtnCadastrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				p.getFrmEventifCadastrarPessoa().dispose();
				EventoTf(p);
			
			}
		});
	}
	
	public void EventoTf(CadastrarPessoa p){
		
		ModeloAluno a = new ModeloAluno();
		
		if(p.getTfnome().getText().equals("")||p.getTfcpf().getText().equals("")||p.getTfrg().getText().equals("")||p.getTfFone().getText().equals("")
		||p.getTfEmail().getText().equals("")||p.getTfEndereco().getText().equals("")||p.getTfNumero().getText().equals("")||p.getTfBairro().getText().equals("")
		||p.getTfComplemento().getText().equals("")||p.getCbCidade().getSelectedItem().equals("")||p.getCbUf().getSelectedItem().equals("")){
		a.getA().setNomePessoa(p.getTfnome().getText());
		a.getA().setCpfPessoa(p.getTfcpf().getText());
		a.getA().setSenhaPessoa("123");
		a.getA().setRgPessoa(p.getTfrg().getText());
		a.getA().setTelefonePessoa(p.getTfFone().getText());
		a.getA().setEmailPessoa(p.getTfEmail().getText());
		a.getA().getEndereco().setRua(p.getTfEndereco().getText());
		a.getA().getEndereco().setBairro(p.getTfBairro().getText());
		a.getA().getEndereco().setNumero(Integer.parseInt(p.getTfNumero().getText()));
		a.getA().getEndereco().setComplemento(p.getTfComplemento().getText());
		a.getA().getEndereco().setCidade(p.getCbCidade().getSelectedIndex()+1);
		a.getA().getEndereco().setUf(p.getCbUf().getSelectedIndex());
		
		a1.inserir(a);
		}else {
			JOptionPane.showMessageDialog(null, "preencha todos campos!");
			CadastrarPessoa cp = new CadastrarPessoa();
			ControleCadastrar cc = new ControleCadastrar(cp);
		}

	}
}
