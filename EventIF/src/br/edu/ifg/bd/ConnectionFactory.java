package br.edu.ifg.bd;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public Connection getConnection(){
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tadseventif","postgres","ifg");
			
//			JOptionPane.showMessageDialog(null, "Conectado");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão");
		}
	
		return con;
		
	}
}
