package br.edu.ifg.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class CadastrarEvento {

	private JFrame frmEventifCadastrar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEvento window = new CadastrarEvento();
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
	public CadastrarEvento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventifCadastrar = new JFrame();
		frmEventifCadastrar.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarEvento.class.getResource("/br/edu/ifg/view/icon.png")));
		frmEventifCadastrar.setTitle("EventIF - cadastrar evento");
		frmEventifCadastrar.setResizable(false);
		frmEventifCadastrar.setBounds(100, 100, 786, 385);
		frmEventifCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventifCadastrar.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 782, 356);
		panel.setBackground(SystemColor.window);
		
		JLabel lblNewLabel = new JLabel("Cadastrar evento");
		lblNewLabel.setBounds(10, 11, 210, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 84, 47, 14);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(10, 115, 75, 14);
		
		textField = new JTextField();
		textField.setBounds(64, 84, 284, 20);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data incio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 146, 58, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(64, 115, 284, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 146, 86, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(64, 177, 86, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(74, 208, 274, 20);
		textField_4.setColumns(10);
		
		JLabel lblDataIncio = new JLabel("Data fim");
		lblDataIncio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataIncio.setBounds(10, 177, 65, 14);
		
		JLabel lblOrganizador = new JLabel("Organizador");
		lblOrganizador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrganizador.setBounds(10, 211, 75, 14);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 239, 42, 14);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 270, 42, 14);
		
		textField_5 = new JTextField();
		textField_5.setBounds(64, 239, 86, 20);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(64, 270, 284, 20);
		textField_6.setColumns(10);
		
		JLabel lblLocalDoEvento = new JLabel("Local ");
		lblLocalDoEvento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalDoEvento.setBounds(398, 87, 37, 14);
		
		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRua.setBounds(398, 118, 45, 14);
		
		textField_7 = new JTextField();
		textField_7.setBounds(446, 115, 284, 20);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(426, 84, 304, 20);
		textField_8.setColumns(10);
		
		JLabel lblN = new JLabel("Numero");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblN.setBounds(399, 149, 44, 14);
		
		textField_10 = new JTextField();
		textField_10.setBounds(444, 149, 86, 20);
		textField_10.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBairro.setBounds(398, 180, 45, 14);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(398, 211, 45, 14);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUf.setBounds(398, 245, 16, 14);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCep.setBounds(459, 245, 30, 14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(437, 180, 202, 20);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(437, 211, 202, 20);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(419, 242, 37, 20);
		textField_13.setColumns(10);
		panel.setLayout(null);
		
		textField_14 = new JTextField();
		textField_14.setBounds(487, 242, 86, 20);
		textField_14.setColumns(10);
		panel.add(textField_14);
		panel.add(lblNome);
		panel.add(lblDescrio);
		panel.add(lblNewLabel_1);
		panel.add(lblDataIncio);
		panel.add(lblOrganizador);
		panel.add(lblTelefone);
		panel.add(lblEmail);
		panel.add(textField_4);
		panel.add(textField_3);
		panel.add(textField_2);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(textField_5);
		panel.add(textField_6);
		panel.add(lblRua);
		panel.add(lblLocalDoEvento);
		panel.add(lblBairro);
		panel.add(lblN);
		panel.add(lblCidade);
		panel.add(textField_12);
		panel.add(textField_10);
		panel.add(textField_7);
		panel.add(textField_8);
		panel.add(textField_11);
		panel.add(lblUf);
		panel.add(textField_13);
		panel.add(lblCep);
		panel.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(637, 314, 93, 23);
		panel.add(btnCadastrar);
		frmEventifCadastrar.getContentPane().add(panel);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(538, 314, 93, 23);
		panel.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastrarEvento.class.getResource("/br/edu/ifg/view/bgeventif.jpg")));
		label.setBounds(0, 0, 782, 356);
		panel.add(label);
	}
}
