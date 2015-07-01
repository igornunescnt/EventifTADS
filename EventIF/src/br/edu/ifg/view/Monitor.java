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
	private JTextField textField;
	
	

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
		lblBemVindoMonitor.setBounds(20, 11, 181, 35);
		panel.add(lblBemVindoMonitor);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisar.setBounds(20, 57, 66, 14);
		panel.add(lblPesquisar);
		
		textField = new JTextField();
		textField.setBounds(78, 56, 562, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(644, 55, 52, 23);
		panel.add(btnOk);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventos.setBounds(20, 96, 58, 14);
		panel.add(lblEventos);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(78, 96, 562, 343);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Monitor.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 472);
		panel.add(label);
	}
}
