package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Gerente {

	private JFrame frmEventifGerente;
	
	

	public JFrame getFrmEventifGerente() {
		return frmEventifGerente;
	}

	public void setFrmEventifGerente(JFrame frmEventifGerente) {
		this.frmEventifGerente = frmEventifGerente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerente window = new Gerente();
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
	public Gerente() {
		initialize();
		frmEventifGerente.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifGerente = new JFrame();
		frmEventifGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(Gerente.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifGerente.setTitle("EventIF - gerente");
		frmEventifGerente.setBounds(100, 100, 790, 500);
		frmEventifGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifGerente.setResizable(false);
		
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frmEventifGerente.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JButton btnGerenciarEvento = new JButton("Gerenciar evento");
		btnGerenciarEvento.setBounds(324, 228, 172, 31);
		panel.add(btnGerenciarEvento);
		
		JButton btnGerenciarParticipante = new JButton("Gerenciar aluno");
		btnGerenciarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGerenciarParticipante.setBounds(324, 270, 172, 31);
		panel.add(btnGerenciarParticipante);
		
		JButton btnNewButton = new JButton("Gerenciar monitor");
		btnNewButton.setBounds(324, 312, 172, 31);
		panel.add(btnNewButton);
		
		JButton btnGerenciarCrach = new JButton("Gerenciar crach\u00E1");
		btnGerenciarCrach.setBounds(324, 354, 172, 31);
		panel.add(btnGerenciarCrach);
		
		JButton btnGerenciarCertificado = new JButton("Gerenciar certificado");
		btnGerenciarCertificado.setBounds(324, 396, 172, 31);
		panel.add(btnGerenciarCertificado);
		
		JLabel lblBemVindoGerente = new JLabel("Bem vindo, Gerente.");
		lblBemVindoGerente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindoGerente.setBounds(22, 23, 201, 31);
		panel.add(lblBemVindoGerente);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Gerente.class.getResource("/br/edu/ifg/view/Logo1.png")));
		lblNewLabel_1.setBounds(314, 129, 214, 88);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Gerente.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 472);
		panel.add(lblNewLabel);
		frmEventifGerente.getContentPane().setLayout(groupLayout);
	}
}
