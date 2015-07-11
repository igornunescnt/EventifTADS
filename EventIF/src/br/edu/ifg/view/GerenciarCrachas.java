package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JButton;

public class GerenciarCrachas {

	private JFrame frmEventifGerente;
	private JTable table;
	private JButton btnGerarCrach;
	private JButton btnVoltar;

	public JFrame getFrmEventifGerente() {
		return frmEventifGerente;
	}

	public void setFrmEventifGerente(JFrame frmEventifGerente) {
		this.frmEventifGerente = frmEventifGerente;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnGerarCrach() {
		return btnGerarCrach;
	}

	public void setBtnGerarCrach(JButton btnGerarCrach) {
		this.btnGerarCrach = btnGerarCrach;
	}

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
					GerenciarCrachas window = new GerenciarCrachas();
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
	public GerenciarCrachas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifGerente = new JFrame();
		frmEventifGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarCrachas.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifGerente.setTitle("EventIF - Gerente | Gerenciar crachas");
		frmEventifGerente.setResizable(false);
		frmEventifGerente.setBounds(100, 100, 790, 500);
		frmEventifGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifGerente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 472);
		frmEventifGerente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGerenciarCrachs = new JLabel("Gerenciar Crach\u00E1s");
		lblGerenciarCrachs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGerenciarCrachs.setBounds(37, 40, 166, 39);
		panel.add(lblGerenciarCrachs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 123, 707, 282);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(541, 438, 89, 23);
		panel.add(btnVoltar);
		
		btnGerarCrach = new JButton("gerar crach\u00E1");
		btnGerarCrach.setBounds(635, 438, 112, 23);
		panel.add(btnGerarCrach);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GerenciarCrachas.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
		frmEventifGerente.setVisible(true);
	}
}
