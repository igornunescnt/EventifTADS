package br.edu.ifg.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;


public class Login {

	private JFrame frmEventifLogin;
	private JTextField textField;
	private Button button_1;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnMonitor;
	private JRadioButton rdbtnGerente;
	private JButton btnCadastrese; 
	private JPasswordField passwordField;
	private String cpf ;
	private String senha;
	

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnCadastrese() {
		return btnCadastrese;
	}

	public void setBtnCadastrese(JButton btnCadastrese) {
		this.btnCadastrese = btnCadastrese;
	}

	public JFrame getFrmEventifLogin() {
		return frmEventifLogin;
	}

	public void setFrmEventifLogin(JFrame frmEventifLogin) {
		this.frmEventifLogin = frmEventifLogin;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	

	public JRadioButton getRdbtnAluno() {
		return rdbtnAluno;
	}

	public void setRdbtnAluno(JRadioButton rdbtnAluno) {
		this.rdbtnAluno = rdbtnAluno;
	}

	public JRadioButton getRdbtnMonitor() {
		return rdbtnMonitor;
	}

	public void setRdbtnMonitor(JRadioButton rdbtnMonitor) {
		this.rdbtnMonitor = rdbtnMonitor;
	}

	public JRadioButton getRdbtnGerente() {
		return rdbtnGerente;
	}

	public void setRdbtnGerente(JRadioButton rdbtnGerente) {
		this.rdbtnGerente = rdbtnGerente;
	}

	public Button getButton_1() {
		return button_1;
	}

	public void setButton_1(Button button_1) {
		this.button_1 = button_1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmEventifLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		frmEventifLogin.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifLogin = new JFrame();
		frmEventifLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifLogin.setTitle("EventIF - login");
		frmEventifLogin.setResizable(false);
		frmEventifLogin.getContentPane().setBackground(SystemColor.text);
		frmEventifLogin.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(550, 0, 232, 472);
		frmEventifLogin.getContentPane().add(panel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(39, 172, 29, 14);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setBounds(39, 186, 149, 20);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(39, 224, 40, 14);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setLayout(null);
		
		JLabel lblEsqueciASenha = new JLabel("esqueci a senha");
		lblEsqueciASenha.setBounds(39, 270, 82, 14);
		lblEsqueciASenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblEsqueciASenha);
		panel.add(lblSenha);
		panel.add(lblCpf);
		panel.add(textField);
		
		button_1 = new Button("Login");
		button_1.setBounds(42, 289, 70, 22);
		panel.add(button_1);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(39, 42, 109, 23);
		panel.add(rdbtnAluno);
		rdbtnAluno.setSelected(true);
		
		rdbtnMonitor = new JRadioButton("Monitor");
		rdbtnMonitor.setBounds(39, 73, 109, 23);
		panel.add(rdbtnMonitor);
		
		rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(39, 105, 109, 23);
		panel.add(rdbtnGerente);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnAluno);
		bg.add(rdbtnGerente);
		bg.add(rdbtnMonitor);
		
		btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(44, 367, 104, 23);
		panel.add(btnCadastrese);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(39, 238, 149, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/br/edu/ifg/view/Logo1.png")));
		lblNewLabel.setBounds(177, 174, 185, 103);
		frmEventifLogin.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 782, 472);
		frmEventifLogin.getContentPane().add(label);
		frmEventifLogin.setBounds(100, 100, 788, 500);
		frmEventifLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
