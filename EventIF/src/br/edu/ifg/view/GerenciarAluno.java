package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

public class GerenciarAluno {

	private JFrame frmEventifAluno;
	private JTextField textField;
	private JTable table;
	private JButton btnPesquisar;
	private JButton btnCadastrar;
	private JButton btnVoltar;

	

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JFrame getFrmEventifAluno() {
		return frmEventifAluno;
	}

	public void setFrmEventifAluno(JFrame frmEventifAluno) {
		this.frmEventifAluno = frmEventifAluno;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarAluno window = new GerenciarAluno();
					window.frmEventifAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GerenciarAluno() {
		initialize();
		frmEventifAluno.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifAluno = new JFrame();
		frmEventifAluno.setIconImage(Toolkit.getDefaultToolkit().getImage(Aluno.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifAluno.setTitle("EventIF - Gerente | Gerenciar Aluno");
		frmEventifAluno.setResizable(false);
		frmEventifAluno.setBounds(100, 100, 790, 500);
		frmEventifAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifAluno.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 472);
		frmEventifAluno.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 64, 576, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnPesquisar = new JButton("OK");
		btnPesquisar.setBounds(669, 63, 53, 23);
		panel.add(btnPesquisar);
		
		JLabel lblBemVindoAluno = new JLabel("Gerenciar Aluno");
		lblBemVindoAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindoAluno.setBounds(27, 21, 187, 20);
		panel.add(lblBemVindoAluno);
		
		JLabel lblEventos = new JLabel("Pesquisar");
		lblEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos.setBounds(27, 65, 62, 14);
		panel.add(lblEventos);
		
		JLabel lblEventos_1 = new JLabel("Alunos");
		lblEventos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos_1.setBounds(27, 105, 63, 14);
		panel.add(lblEventos_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 107, 576, 301);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setBounds(569, 438, 98, 23);
		panel.add(btnCadastrar);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(470, 438, 89, 23);
		panel.add(btnVoltar);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Aluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
	}
}
