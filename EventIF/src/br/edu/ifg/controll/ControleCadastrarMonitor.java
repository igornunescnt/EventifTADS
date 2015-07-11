package br.edu.ifg.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifg.model.ModeloMonitor;
import br.edu.ifg.modelDAO.MonitorDAO;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.GerenciarMonitor;

public class ControleCadastrarMonitor {
	

	CadastrarPessoa c = null;
	MonitorDAO a1 = new MonitorDAO();
	private GerenciarMonitor ga;


	public ControleCadastrarMonitor(CadastrarPessoa c, GerenciarMonitor ge) {
		this.ga = ge;
		this.c = c;
		carregaEstados(a1);
		EventoBotao();


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

	public void carregaEstados(MonitorDAO a){
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

	public void EventoBotao(){
				
		 c.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ga.getFrmEventifMonitor().setVisible(true);
				c.getFrmEventifCadastrarPessoa().dispose();
			}
		});

		c.getBtnCadastrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				c.getFrmEventifCadastrarPessoa().dispose();
				EventoTf();

			}
		});
	}

	public void EventoTf(){
		try{
			if(c.getTfnome().getText().equals("")||c.getTfcpf().getText().equals("")||c.getTfrg().getText().equals("")||
					c.getTfFone().getText().equals("")||c.getTfEmail().getText().equals("")||c.getTfEndereco().getText().equals("")||
					c.getTfBairro().getText().equals("")||c.getTfNumero().getText().equals("")||c.getTfComplemento().getText().equals("")){

				JOptionPane.showMessageDialog(null,"preencha todos os campos!");
				CadastrarPessoa cp = new CadastrarPessoa();
				ControleCadastrarMonitor cm = new ControleCadastrarMonitor(cp, ga);

			}else {

				ModeloMonitor a = new ModeloMonitor();

				a.getM().setNomePessoa(c.getTfnome().getText());
				a.getM().setCpfPessoa(c.getTfcpf().getText());
				a.getM().setSenhaPessoa("123");
				a.getM().setRgPessoa(c.getTfrg().getText());
				a.getM().setTelefonePessoa(c.getTfFone().getText());
				a.getM().setEmailPessoa(c.getTfEmail().getText());
				a.getM().getEndereco().setRua(c.getTfEndereco().getText());
				a.getM().getEndereco().setBairro(c.getTfBairro().getText());
				a.getM().getEndereco().setNumero(c.getTfNumero().getText());
				a.getM().getEndereco().setComplemento(c.getTfComplemento().getText());
				a.getM().getEndereco().setCidade(c.getCbCidade().getSelectedIndex()+1);
				a.getM().getEndereco().setUf(c.getCbUf().getSelectedIndex());


				a1.inserir(a);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Não foi possivel o cadastro, tente novamente!");
		}
	}


}
