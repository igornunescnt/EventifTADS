package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Aluno {

	private JFrame frameAluno;
	private JTextField textField;
	private JTable table;
	private JButton btnVoltar;
	
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JFrame getFrameAluno() {
		return frameAluno;
	}

	public void setFrameAluno(JFrame frameAluno) {
		this.frameAluno = frameAluno;
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
					Aluno window = new Aluno();
					window.frameAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAluno = new JFrame();
		frameAluno.setTitle("EventIF - Aluno");
		frameAluno.setResizable(false);
		frameAluno.setIconImage(Toolkit.getDefaultToolkit().getImage(Aluno.class.getResource("/br/edu/ifg/view/icon.png")));
		frameAluno.setBounds(100, 100, 790, 500);
		frameAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAluno.getContentPane().setLayout(null);
		frameAluno.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 472);
		frameAluno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBemVindoAluno = new JLabel("Bem vindo, Aluno.");
		lblBemVindoAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindoAluno.setBounds(36, 35, 170, 43);
		panel.add(lblBemVindoAluno);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisar.setBounds(36, 103, 58, 14);
		panel.add(lblPesquisar);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos.setBounds(36, 162, 58, 14);
		panel.add(lblEventos);
		
		textField = new JTextField();
		textField.setBounds(94, 100, 539, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(643, 99, 52, 23);
		panel.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 163, 541, 253);
		panel.add(scrollPane);
		
		table = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		table.setBackground(Color.WHITE);
		
		btnVoltar = new JButton("Sair");
		btnVoltar.setBounds(606, 438, 89, 23);
		panel.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Aluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
	}
}
