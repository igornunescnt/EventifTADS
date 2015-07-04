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

public class GerenciarCertificados {

	private JFrame frmEventifGcertif;
	private JTable table;
	private JButton btnGerarCertificado;
	private JButton btnVoltar;

	public JButton getBtnGerarCertificado() {
		return btnGerarCertificado;
	}

	public void setBtnGerarCertificado(JButton btnGerarCertificado) {
		this.btnGerarCertificado = btnGerarCertificado;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JFrame getFrmEventifGcertif() {
		return frmEventifGcertif;
	}

	public void setFrmEventifGcertif(JFrame frmEventifGcertif) {
		this.frmEventifGcertif = frmEventifGcertif;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCertificados window = new GerenciarCertificados();
					window.frmEventifGcertif.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GerenciarCertificados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifGcertif = new JFrame();
		frmEventifGcertif.setIconImage(Toolkit.getDefaultToolkit().getImage(AtividadeAluno.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifGcertif.setTitle("EventIF - Gerente | Gerenciar certificados");
		frmEventifGcertif.setResizable(false);
		frmEventifGcertif.setBounds(100, 100, 687, 440);
		frmEventifGcertif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifGcertif.getContentPane().setLayout(null);
		frmEventifGcertif.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 683, 412);
		frmEventifGcertif.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAtividades = new JLabel("Gerenciar certificados");
		lblAtividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtividades.setBounds(29, 28, 192, 35);
		panel.add(lblAtividades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 73, 620, 285);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnGerarCertificado = new JButton("Gerar certificado");
		btnGerarCertificado.setBounds(508, 378, 141, 23);
		panel.add(btnGerarCertificado);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(394, 378, 104, 23);
		panel.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AtividadeAluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 683, 412);
		panel.add(label);
	}

	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
