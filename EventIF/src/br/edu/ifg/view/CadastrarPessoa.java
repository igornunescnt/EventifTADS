package br.edu.ifg.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifg.controll.ControleAluno;
import br.edu.ifg.controll.ControleCadastrar;
import br.edu.ifg.model.ModeloPessoa;
import br.edu.ifg.modelDAO.AlunoDAO;

public class CadastrarPessoa {

	private JFrame frmEventifCadastrarPessoa;
	private JTextField tfnome;
	private JTextField tfrg;
	private JTextField tfcpf;
	private JTextField tfFone;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JComboBox cbCidade;
	private JComboBox cbUf;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private JTextField tfBairro;
	private JTextField tfComplemento;
	

	public JTextField getTfNumero() {
		return tfNumero;
	}

	public void setTfNumero(JTextField tfNumero) {
		this.tfNumero = tfNumero;
	}

	public JTextField getTfComplemento() {
		return tfComplemento;
	}

	public void setTfComplemento(JTextField tfComplemento) {
		this.tfComplemento = tfComplemento;
	}

	public JFrame getFrmEventifCadastrarPessoa() {
		return frmEventifCadastrarPessoa;
	}

	public void setFrmEventifCadastrarPessoa(JFrame frmEventifCadastrarPessoa) {
		this.frmEventifCadastrarPessoa = frmEventifCadastrarPessoa;
	}

	public JTextField getTfnome() {
		return tfnome;
	}

	public void setTfnome(JTextField tfnome) {
		this.tfnome = tfnome;
	}

	public JTextField getTfrg() {
		return tfrg;
	}

	public void setTfrg(JTextField tfrg) {
		this.tfrg = tfrg;
	}

	public JTextField getTfcpf() {
		return tfcpf;
	}

	public void setTfcpf(JTextField tfcpf) {
		this.tfcpf = tfcpf;
	}

	public JTextField getTfFone() {
		return tfFone;
	}

	public void setTfFone(JTextField tfFone) {
		this.tfFone = tfFone;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfEndereco() {
		return tfEndereco;
	}

	public void setTfEndereco(JTextField tfEndereco) {
		this.tfEndereco = tfEndereco;
	}

	public JTextField getTfBairro() {
		return tfNumero;
	}

	public void setTfBairro(JTextField tfBairro) {
		this.tfNumero = tfBairro;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JComboBox getCbCidade() {
		return cbCidade;
	}

	public void setCbCidade(JComboBox cbCidade) {
		this.cbCidade = cbCidade;
	}

	public JComboBox getCbUf() {
		return cbUf;
	}

	public void setCbUf(JComboBox cbUf) {
		this.cbUf = cbUf;
	}


	/**
	 * Create the application.
	 */
	public CadastrarPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifCadastrarPessoa = new JFrame();
		frmEventifCadastrarPessoa.setResizable(false);
		frmEventifCadastrarPessoa.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarPessoa.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifCadastrarPessoa.setTitle("EventIF - Cadastro");
		frmEventifCadastrarPessoa.setBounds(100, 100, 575, 343);
		frmEventifCadastrarPessoa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifCadastrarPessoa.getContentPane().setLayout(null);
		frmEventifCadastrarPessoa.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 569, 315);
		frmEventifCadastrarPessoa.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar");
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarAluno.setBounds(20, 24, 153, 34);
		panel.add(lblCadastrarAluno);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 92, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(244, 125, 46, 14);
		panel.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(25, 162, 71, 14);
		panel.add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(20, 209, 59, 14);
		panel.add(lblEndereo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(183, 162, 35, 14);
		panel.add(lblEmail);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(282, 209, 46, 14);
		panel.add(lblNumero);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(183, 282, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(20, 282, 46, 14);
		panel.add(lblUf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(25, 128, 46, 14);
		panel.add(lblRg);
		
		cbCidade = new JComboBox();
		cbCidade.setBounds(228, 279, 100, 20);
		panel.add(cbCidade);
		
		
		cbUf = new JComboBox();
		cbUf.setBounds(49, 279, 90, 20);
		cbUf.addItem("Selecione");
		cbCidade.addItem("Selecione");
	
	
		cbUf.setSelectedIndex(0);
		cbCidade.setSelectedIndex(0);
		panel.add(cbUf);
		panel.add(cbCidade);
		
		tfnome = new JTextField();
		tfnome.setBounds(63, 89, 432, 20);
		panel.add(tfnome);
		tfnome.setColumns(10);
		
		tfrg = new JTextField();
		tfrg.setBounds(63, 124, 142, 20);
		panel.add(tfrg);
		tfrg.setColumns(10);
		
		tfcpf = new JTextField();
		tfcpf.setColumns(10);
		tfcpf.setBounds(279, 122, 132, 20);
		panel.add(tfcpf);
		
		tfFone = new JTextField();
		tfFone.setColumns(10);
		tfFone.setBounds(88, 159, 86, 20);
		panel.add(tfFone);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(228, 159, 189, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(83, 206, 189, 20);
		panel.add(tfEndereco);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(336, 206, 183, 20);
		panel.add(tfNumero);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(352, 278, 89, 23);
		panel.add(btnVoltar);
		
		btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setBounds(451, 278, 95, 23);
		panel.add(btnCadastrar);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(25, 245, 46, 14);
		panel.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(73, 242, 171, 20);
		panel.add(tfBairro);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(277, 245, 86, 14);
		panel.add(lblComplemento);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(363, 242, 183, 20);
		panel.add(tfComplemento);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastrarPessoa.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 569, 315);
		panel.add(label);
		
	}
}
