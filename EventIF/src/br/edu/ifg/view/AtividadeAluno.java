package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class AtividadeAluno {

	private JFrame frmEventifAluno;
	private JTable table;
	private JButton btnVoltar;
	

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtividadeAluno window = new AtividadeAluno();
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
	public AtividadeAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifAluno = new JFrame();
		frmEventifAluno.setIconImage(Toolkit.getDefaultToolkit().getImage(AtividadeAluno.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifAluno.setTitle("EventIF - Aluno | atividades");
		frmEventifAluno.setResizable(false);
		frmEventifAluno.setBounds(100, 100, 687, 456);
		frmEventifAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifAluno.getContentPane().setLayout(null);
		frmEventifAluno.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 683, 428);
		frmEventifAluno.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtividades.setBounds(29, 28, 132, 35);
		panel.add(lblAtividades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 85, 623, 282);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(563, 394, 89, 23);
		panel.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AtividadeAluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 683, 428);
		panel.add(label);
	}

	public JFrame getFrmEventifAluno() {
		return frmEventifAluno;
	}

	public void setFrmEventifAluno(JFrame frmEventifAluno) {
		this.frmEventifAluno = frmEventifAluno;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
