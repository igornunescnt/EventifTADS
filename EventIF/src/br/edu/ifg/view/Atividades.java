package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Atividades extends JInternalFrame {
	private JTable table;
	private JButton btnCadastrar;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
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
					Atividades frame = new Atividades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Atividades() {
		try {
			setFrameIcon(new ImageIcon(Atividades.class.getResource("/br/edu/ifg/view/icon.png")));
			setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Atividades");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 640, 402);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 67, 581, 259);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtividades.setBounds(21, 28, 110, 28);
		getContentPane().add(lblAtividades);
		
		btnCadastrar = new JButton("Cadastrar ");
		btnCadastrar.setBounds(514, 339, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Atividades.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 624, 373);
		getContentPane().add(label);

	}
}
