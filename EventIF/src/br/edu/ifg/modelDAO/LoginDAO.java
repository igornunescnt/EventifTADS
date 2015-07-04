package br.edu.ifg.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.view.Login;

public class LoginDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs;
	ConnectionFactory conf = new ConnectionFactory();

	
	 public boolean consultar(String login, String senha) {  
	        boolean autenticado = false;  
	        String sql;  
	        try {  
	            Connection conn = conf.getConnection();  
	  
	            sql = "SELECT cpfpessoa, senhapessoa FROM pessoa WHERE cpfpessoa=? and senhapessoa=?";  
	            PreparedStatement ps;  
	            ps = conn.prepareStatement(sql);  
	            ps.setString(1, login);  
	            ps.setString(2, senha);  
	  
	            ResultSet rs;  
	            rs = ps.executeQuery();  
	  
	            if (rs.next()) {  
	                String user = rs.getString("cpfpessoa");  
	                String pass = rs.getString("senhapessoa");  
	                autenticado = true;  
	            } else {  
	                //JOptionPane.showMessageDialog(this, "Acesso Negado \nInforme o setor de Inventário");  
	                ps.close();  
	                return autenticado;  
	            }  
	        } catch (SQLException ex) {  
	            JOptionPane.showMessageDialog(null, "Dados incorretos, tente novamente!");  
	        }  
	        return autenticado;  
	    } 
}
