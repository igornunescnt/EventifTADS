package br.edu.ifg.modelDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import br.edu.ifg.controll.ControleLogin;
import br.edu.ifg.model.ModeloEvento;
import br.edu.ifg.view.CadastrarEvento;
import br.edu.ifg.view.Login;

public class ControleEvento {

	 EventoDAO dao = new EventoDAO();
	private CadastrarEvento ce = null;
	
	public ControleEvento(CadastrarEvento ce) {
		this.ce = ce;
		carregaEstados(dao);
		EventoBotao(ce);


		ce.getCbUf().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(ce.getCbUf().getSelectedIndex() != 0){
					ce.getCbCidade().removeAllItems();
					ce.getCbCidade().setEnabled(true);
					int idEstado = ce.getCbUf().getSelectedIndex();
					carregaCidades(dao.Cidade(idEstado));
				}
				else{
					ce.getCbCidade().setEnabled(false);
				}

			}
		});

		ce.getCbCidade().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ce.getCbCidade().getSelectedItem();
				System.out.println(ce.getCbCidade().getSelectedIndex());

			}
		});

	}

	public void carregaEstados(EventoDAO a){
		try {
			ResultSet r = a.Estado();

			while(r.next()){
				ce.getCbUf().addItem(r.getString("ufestado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ce.getCbUf().getSelectedIndex()==0){
			ce.getCbCidade().setEnabled(false);
		}
	}

	public void carregaCidades(ResultSet rs){


		try {

			while(rs.next()){
				ce.getCbCidade().addItem(rs.getString("nomecidade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ce.getCbUf().getSelectedIndex()==0){
			ce.getCbCidade().setEnabled(false);
		}
		else {

		}
	}

	public void EventoBotao(CadastrarEvento ce){
		//CadastrarPessoa p = new CadastrarPessoa();
		ce.getBtnVoltar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ce.getFrmEventifCadastrar().dispose();
				Login a = new Login();
				ControleLogin c = new ControleLogin(a);
			}
		});

		ce.getBtnCadastrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ce.getFrmEventifCadastrar().dispose();
				EventoTf(ce);

			}
		});
	}

	public void EventoTf( CadastrarEvento ce){
		try{
			if(ce.getTfNome().getText().equals("")||ce.getTfOrganizador().getText().equals("")||
					ce.getTfDataInicio().getText().equals("")||ce.getTfDataFim().getText().equals("")||
					ce.getTfLocal().getText().equals("")|| ce.getTfEndereco().getText().equals("")||
					ce.getTfNumero().getText().equals("")|| ce.getTfBairro().getText().equals("")||
					ce.getTfCep().getText().equals("")|| ce.getTfDescricao().getText().equals("")||
					ce.getTfEmail().getText().equals("")|| ce.getTfTelefone().getText().equals("")||
					ce.getCbUf().getSelectedIndex() == 0 || ce.getTfComplemento().getText().equals("")){

				JOptionPane.showMessageDialog(null," deu errado!");
				ce.getFrmEventifCadastrar();
			}else {

				ModeloEvento me = new ModeloEvento();

				me.setNomeEvento(ce.getTfNome().getText());
				me.setOrganizadorEvento(ce.getTfOrganizador().getText());
				Calendar ca = Calendar.getInstance();
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				ca.setTime(sd.parse(ce.getTfDataFim().getText()));
				me.setDatafim(ca);
				ca.setTime(sd.parse(ce.getTfDataInicio().getText()));
				me.setDataInicio(ca);
				me.setLocal(ce.getTfLocal().getText());
				me.getEndereco().setRua(ce.getTfEndereco().getText());
				me.getEndereco().setNumero(ce.getTfNumero().getText());
				me.getEndereco().setComplemento(ce.getTfComplemento().getText());
				me.getEndereco().setBairro(ce.getTfBairro().getText());
				me.getEndereco().setCep(ce.getTfCep().getText());
				//me.getEndereco().setUf(ce.getCbUf().getSelectedIndex());
				me.getEndereco().setCidade(ce.getCbCidade().getSelectedIndex()+1);
				
				dao.inserir(me);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Não foi possivel o cadastro, tente novamente! "+e.getMessage());
		}
	}
}
