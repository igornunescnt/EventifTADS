package br.edu.ifg.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;


public class CadastrarEvento {

	private JFrame frmEventifCadastrar;
	private JTextField tfNome;
	private JTextField tfDescricao;
	private JTextField tfDataInicio;
	private JTextField tfDataFim;
	private JTextField tfOrganizador;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfLocal;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCep;
	private JButton btnVoltar; 
	private JButton btnCadastrar;

	public JFrame getFrmEventifCadastrar() {
		return frmEventifCadastrar;
	}

	public void setFrmEventifCadastrar(JFrame frmEventifCadastrar) {
		this.frmEventifCadastrar = frmEventifCadastrar;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfDescricao() {
		return tfDescricao;
	}

	public void setTfDescricao(JTextField tfDescricao) {
		this.tfDescricao = tfDescricao;
	}

	public JTextField getTfDataInicio() {
		return tfDataInicio;
	}

	public void setTfDataInicio(JTextField tfDataInicio) {
		this.tfDataInicio = tfDataInicio;
	}

	public JTextField getTfDataFim() {
		return tfDataFim;
	}

	public void setTfDataFim(JTextField tfDataFim) {
		this.tfDataFim = tfDataFim;
	}

	public JTextField getTfOrganizador() {
		return tfOrganizador;
	}

	public void setTfOrganizador(JTextField tfOrganizador) {
		this.tfOrganizador = tfOrganizador;
	}

	public JTextField getTfTelefone() {
		return tfTelefone;
	}

	public void setTfTelefone(JTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
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

	public JTextField getTfLocal() {
		return tfLocal;
	}

	public void setTfLocal(JTextField tfLocal) {
		this.tfLocal = tfLocal;
	}

	public JTextField getTfNumero() {
		return tfNumero;
	}

	public void setTfNumero(JTextField tfNumero) {
		this.tfNumero = tfNumero;
	}

	public JTextField getTfBairro() {
		return tfBairro;
	}

	public void setTfBairro(JTextField tfBairro) {
		this.tfBairro = tfBairro;
	}

	public JTextField getTfCep() {
		return tfCep;
	}

	public void setTfCep(JTextField tfCep) {
		this.tfCep = tfCep;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEvento window = new CadastrarEvento();
					window.frmEventifCadastrar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarEvento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifCadastrar = new JFrame();
		frmEventifCadastrar.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarEvento.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifCadastrar.setTitle("EventIF - cadastrar evento");
		frmEventifCadastrar.setResizable(false);
		frmEventifCadastrar.setBounds(100, 100, 786, 385);
		frmEventifCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifCadastrar.getContentPane().setLayout(null);
		frmEventifCadastrar.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 782, 356);
		panel.setBackground(SystemColor.window);
		
		JLabel lblNewLabel = new JLabel("Cadastrar evento");
		lblNewLabel.setBounds(10, 11, 210, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 84, 47, 14);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(10, 115, 75, 14);
		
		tfNome = new JTextField();
		tfNome.setBounds(64, 84, 284, 20);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data incio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 146, 58, 14);
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(64, 115, 284, 20);
		tfDescricao.setColumns(10);
		
		tfDataInicio = new JTextField();
		tfDataInicio.setBounds(64, 146, 86, 20);
		tfDataInicio.setColumns(10);
		
		tfDataFim = new JTextField();
		tfDataFim.setBounds(64, 177, 86, 20);
		tfDataFim.setColumns(10);
		
		tfOrganizador = new JTextField();
		tfOrganizador.setBounds(74, 208, 274, 20);
		tfOrganizador.setColumns(10);
		
		JLabel lblDataIncio = new JLabel("Data fim");
		lblDataIncio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataIncio.setBounds(10, 177, 65, 14);
		
		JLabel lblOrganizador = new JLabel("Organizador");
		lblOrganizador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrganizador.setBounds(10, 211, 75, 14);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 239, 42, 14);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 270, 42, 14);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(64, 239, 86, 20);
		tfTelefone.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(64, 270, 284, 20);
		tfEmail.setColumns(10);
		
		JLabel lblLocalDoEvento = new JLabel("Local ");
		lblLocalDoEvento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalDoEvento.setBounds(398, 87, 37, 14);
		
		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRua.setBounds(398, 118, 45, 14);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(446, 115, 284, 20);
		tfEndereco.setColumns(10);
		
		tfLocal = new JTextField();
		tfLocal.setBounds(426, 84, 304, 20);
		tfLocal.setColumns(10);
		
		JLabel lblN = new JLabel("Numero");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblN.setBounds(399, 149, 44, 14);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(444, 149, 86, 20);
		tfNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBairro.setBounds(398, 180, 45, 14);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(398, 221, 45, 14);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUf.setBounds(575, 221, 16, 14);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCep.setBounds(398, 252, 30, 14);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(437, 180, 202, 20);
		tfBairro.setColumns(10);
		panel.setLayout(null);
		
		tfCep = new JTextField();
		tfCep.setBounds(426, 249, 86, 20);
		tfCep.setColumns(10);
		panel.add(tfCep);
		panel.add(lblNome);
		panel.add(lblDescrio);
		panel.add(lblNewLabel_1);
		panel.add(lblDataIncio);
		panel.add(lblOrganizador);
		panel.add(lblTelefone);
		panel.add(lblEmail);
		panel.add(tfOrganizador);
		panel.add(tfDataFim);
		panel.add(tfDataInicio);
		panel.add(tfNome);
		panel.add(tfDescricao);
		panel.add(tfTelefone);
		panel.add(tfEmail);
		panel.add(lblRua);
		panel.add(lblLocalDoEvento);
		panel.add(lblBairro);
		panel.add(lblN);
		panel.add(lblCidade);
		panel.add(tfNumero);
		panel.add(tfEndereco);
		panel.add(tfLocal);
		panel.add(tfBairro);
		panel.add(lblUf);
		panel.add(lblCep);
		panel.add(lblNewLabel);
		
		btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(637, 314, 93, 23);
		panel.add(btnCadastrar);
		frmEventifCadastrar.getContentPane().add(panel);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVoltar.setBounds(538, 314, 93, 23);
		panel.add(btnVoltar);
		
		JComboBox cbCidade = new JComboBox();
		cbCidade.setBounds(444, 218, 100, 20);
		panel.add(cbCidade);
		
		JComboBox cbUf = new JComboBox();
		cbUf.setBounds(592, 218, 40, 20);
		panel.add(cbUf);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastrarEvento.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 782, 356);
		panel.add(label);
	}
}
