package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.Toolkit;
import java.awt.ScrollPane;

public class Monitor {

	private JFrame frmEventifMonitor;
	private JTextField tfPesquisar;
	private JTable table;
	private JButton btnSair;
	

	public JTextField getTextField() {
		return tfPesquisar;
	}

	public void setTextField(JTextField textField) {
		this.tfPesquisar = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}

	public JFrame getFrmEventifMonitor() {
		return frmEventifMonitor;
	}

	public void setFrmEventifMonitor(JFrame frmEventifMonitor) {
		this.frmEventifMonitor = frmEventifMonitor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitor window = new Monitor();
					window.frmEventifMonitor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Monitor() {
		initialize();
		frmEventifMonitor.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifMonitor = new JFrame();
		frmEventifMonitor.setResizable(false);
		frmEventifMonitor.setIconImage(Toolkit.getDefaultToolkit().getImage(Monitor.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifMonitor.setTitle("EventIF - monitor");
		frmEventifMonitor.setBounds(100, 100, 790, 500);
		frmEventifMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifMonitor.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 472);
		frmEventifMonitor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBemVindoMonitor = new JLabel("Bem vindo, monitor.");
		lblBemVindoMonitor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindoMonitor.setBounds(35, 33, 181, 35);
		panel.add(lblBemVindoMonitor);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisar.setBounds(35, 92, 66, 14);
		panel.add(lblPesquisar);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(105, 91, 535, 20);
		panel.add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(644, 90, 52, 23);
		panel.add(btnOk);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos.setBounds(35, 148, 50, 14);
		panel.add(lblEventos);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(607, 438, 89, 23);
		panel.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 150, 551, 261);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Monitor.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
	}
}
