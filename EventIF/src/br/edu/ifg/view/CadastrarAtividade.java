package br.edu.ifg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarAtividade {

	private JFrame frmEventifCadastrar;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtTipoatv;
	private JTextField txtMinistrante;
	private JTextField txtData;
	private JTextField txtHinicio;
	private JTextField txtHenc;
	private JTextField txtChh;
	private JTextField txtNvagas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAtividade window = new CadastrarAtividade();
					window.frmEventifCadastrar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarAtividade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifCadastrar = new JFrame();
		frmEventifCadastrar.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarAtividade.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifCadastrar.setTitle("EventIF - cadastrar atividade");
		frmEventifCadastrar.setBounds(100, 100, 790, 338);
		frmEventifCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifCadastrar.setResizable(false);
		frmEventifCadastrar.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 784, 310);
		frmEventifCadastrar.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastrarAtividade = new JLabel("Cadastrar atividade");
		lblCadastrarAtividade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarAtividade.setBounds(10, 0, 200, 50);
		panel.add(lblCadastrarAtividade);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 61, 41, 14);
		panel.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(10, 103, 51, 14);
		panel.add(lblDescrio);
		
		JLabel lblTipoDeAtividade = new JLabel("Tipo de atividade");
		lblTipoDeAtividade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoDeAtividade.setBounds(10, 148, 87, 14);
		panel.add(lblTipoDeAtividade);
		
		JLabel lblMinistrante = new JLabel("Ministrante");
		lblMinistrante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinistrante.setBounds(10, 184, 53, 14);
		panel.add(lblMinistrante);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblData.setBounds(10, 217, 30, 14);
		panel.add(lblData);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de inicio");
		lblHoraDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoraDeInicio.setBounds(453, 64, 71, 14);
		panel.add(lblHoraDeInicio);
		
		JLabel lblHoraDeEncerramento = new JLabel("Hora de encerramento");
		lblHoraDeEncerramento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoraDeEncerramento.setBounds(453, 103, 108, 14);
		panel.add(lblHoraDeEncerramento);
		
		txtNome = new JTextField();
		txtNome.setBounds(58, 58, 333, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(58, 93, 333, 35);
		panel.add(txtDescricao);
		
		txtTipoatv = new JTextField();
		txtTipoatv.setColumns(10);
		txtTipoatv.setBounds(93, 142, 298, 20);
		panel.add(txtTipoatv);
		
		txtMinistrante = new JTextField();
		txtMinistrante.setColumns(10);
		txtMinistrante.setBounds(93, 181, 298, 20);
		panel.add(txtMinistrante);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(58, 214, 108, 20);
		panel.add(txtData);
		
		txtHinicio = new JTextField();
		txtHinicio.setColumns(10);
		txtHinicio.setBounds(545, 58, 108, 20);
		panel.add(txtHinicio);
		
		txtHenc = new JTextField();
		txtHenc.setColumns(10);
		txtHenc.setBounds(565, 100, 108, 20);
		panel.add(txtHenc);
		
		JLabel lblCargaHoraria = new JLabel("Carga horaria");
		lblCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCargaHoraria.setBounds(453, 148, 71, 14);
		panel.add(lblCargaHoraria);
		
		JLabel lblNumeroDeVagas = new JLabel("Numero de vagas");
		lblNumeroDeVagas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumeroDeVagas.setBounds(453, 184, 87, 14);
		panel.add(lblNumeroDeVagas);
		
		txtChh = new JTextField();
		txtChh.setColumns(10);
		txtChh.setBounds(545, 148, 108, 20);
		panel.add(txtChh);
		
		txtNvagas = new JTextField();
		txtNvagas.setColumns(10);
		txtNvagas.setBounds(545, 181, 108, 20);
		panel.add(txtNvagas);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(683, 270, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(584, 270, 89, 23);
		panel.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastrarAtividade.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 784, 310);
		panel.add(label);
	}
}
