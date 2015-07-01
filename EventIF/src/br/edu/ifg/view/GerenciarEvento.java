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

public class GerenciarEvento {

	private JFrame frmEventifGerente;
	private JTextField textField;
	private JTable table;
	private JButton btnPesquisar;
	
	

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JFrame getFrmEventifGerente() {
		return frmEventifGerente;
	}

	public void setFrmEventifGerente(JFrame frmEventif1) {
		this.frmEventifGerente = frmEventif1;
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
					GerenciarEvento window = new GerenciarEvento();
					window.frmEventifGerente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GerenciarEvento() {
		initialize();
		frmEventifGerente.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifGerente = new JFrame();
		frmEventifGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(Aluno.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifGerente.setTitle("EventIF - Gerente | Gerenciar evento");
		frmEventifGerente.setResizable(false);
		frmEventifGerente.setBounds(100, 100, 790, 500);
		frmEventifGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifGerente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 472);
		frmEventifGerente.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 64, 576, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnPesquisar = new JButton("OK");
		btnPesquisar.setBounds(669, 63, 53, 23);
		panel.add(btnPesquisar);
		
		JLabel lblBemVindoAluno = new JLabel("Gerenciar Evento");
		lblBemVindoAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindoAluno.setBounds(27, 21, 187, 20);
		panel.add(lblBemVindoAluno);
		
		JLabel lblEventos = new JLabel("Pesquisar");
		lblEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos.setBounds(27, 65, 62, 14);
		panel.add(lblEventos);
		
		JLabel lblEventos_1 = new JLabel("Eventos");
		lblEventos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos_1.setBounds(27, 105, 63, 14);
		panel.add(lblEventos_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 107, 576, 301);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setBounds(578, 438, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(479, 438, 89, 23);
		panel.add(btnVoltar);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Aluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
	}
}