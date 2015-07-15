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

public class AtividadeMonitor {

	private JFrame frmEventifMonitor;
	private JTable table;
	private JButton btnVoltar;

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JFrame getFrmEventifMonitor() {
		return frmEventifMonitor;
	}

	public void setFrmEventifMonitor(JFrame frmEventifMonitor) {
		this.frmEventifMonitor = frmEventifMonitor;
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
					AtividadeMonitor window = new AtividadeMonitor();
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
	public AtividadeMonitor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifMonitor = new JFrame();
		frmEventifMonitor.setResizable(false);
		frmEventifMonitor.setIconImage(Toolkit.getDefaultToolkit().getImage(AtividadeMonitor.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifMonitor.setTitle("EventIF - Monitor | atividades");
		frmEventifMonitor.setBounds(100, 100, 688, 455);
		frmEventifMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifMonitor.getContentPane().setLayout(null);
		frmEventifMonitor.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 683, 427);
		frmEventifMonitor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtividades.setBounds(29, 28, 132, 35);
		panel.add(lblAtividades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 73, 620, 299);
		panel.add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int lin, int col) {
				return false;				
			}
		};
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(560, 393, 89, 23);
		panel.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AtividadeAluno.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 683, 427);
		panel.add(label);
	}

}
