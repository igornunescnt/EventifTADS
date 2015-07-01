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

	private JFrame frmEventifGerente;
	private JTextField tfnome;
	private JTextField tfrg;
	private JTextField tfcpf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox cbCidade;
	private JComboBox cbUf;


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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPessoa window = new CadastrarPessoa();
					window.frmEventifGerente.setVisible(true);
					//ControleCadastrar cd = new ControleCadastrar();
					//cd.adicionarEvento( new AlunoDAO() );
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmEventifGerente = new JFrame();
		frmEventifGerente.setResizable(false);
		frmEventifGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarPessoa.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifGerente.setTitle("EventIF - gerente | gerenciar  | cadastrar");
		frmEventifGerente.setBounds(100, 100, 575, 308);
		frmEventifGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifGerente.getContentPane().setLayout(null);
		frmEventifGerente.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 569, 280);
		frmEventifGerente.getContentPane().add(panel);
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
		lblEndereo.setBounds(20, 209, 71, 14);
		panel.add(lblEndereo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(183, 162, 35, 14);
		panel.add(lblEmail);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(292, 209, 46, 14);
		panel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(183, 240, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(20, 240, 46, 14);
		panel.add(lblUf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(25, 128, 46, 14);
		panel.add(lblRg);
		
		cbCidade = new JComboBox();
		cbCidade.setBounds(228, 237, 100, 20);
		panel.add(cbCidade);
		
		
		cbUf = new JComboBox();
		cbUf.setBounds(49, 237, 90, 20);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 159, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 159, 189, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 206, 171, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(336, 206, 183, 20);
		panel.add(textField_3);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(363, 239, 89, 23);
		panel.add(btnVoltar);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.setBounds(455, 239, 95, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastrarPessoa.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 569, 280);
		panel.add(label);
	}

}
