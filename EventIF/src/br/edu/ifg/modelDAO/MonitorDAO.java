package br.edu.ifg.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.model.ModeloAluno;
import br.edu.ifg.model.ModeloMonitor;

public class MonitorDAO {
ConnectionFactory conf = null;
	
	public MonitorDAO(){
		conf = new ConnectionFactory();
	}
	
	public void inserir(ModeloMonitor monitor){
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conf.getConnection();
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement("insert into enderecopessoa "
					+ "(numero, cep, complemento,idcidade, bairro) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS );
			stmt.setInt(1, monitor.getM().getEndereco().getNumero());
			stmt.setString(2,  monitor.getM().getEndereco().getCep());
			stmt.setString(3,  monitor.getM().getEndereco().getComplemento());
			stmt.setLong(4,  monitor.getM().getEndereco().getCidade());
			stmt.setString(5,  monitor.getM().getEndereco().getBairro());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			int id =0;
			if(rs!=null && rs.next()){
				id = rs.getInt(1);
			}
						
			stmt = con.prepareStatement("insert into pessoa (nomePessoa, cpfPessoa,emailPessoa,rgPessoa,"
					+ "telefonePessoa,senhaPessoa,idEnderecoPessoa) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1,  monitor.getM().getNomePessoa());
		stmt.setString(2,  monitor.getM().getCpfPessoa());
		stmt.setString(3,  monitor.getM().getEmailPessoa());
		stmt.setString(4,  monitor.getM().getRgPessoa());
		stmt.setString(5,  monitor.getM().getTelefonePessoa());
		stmt.setString(6,  monitor.getM().getSenhaPessoa());
		stmt.setLong(7, id);
		
		stmt.executeUpdate();
		ResultSet rs1 = stmt.getGeneratedKeys();
		id =0;
		if(rs1!=null && rs1.next()){
			id = rs1.getInt(1);
		}
		
		stmt = con.prepareStatement("insert into pessoamonitor (matriculaMonitor, idPessoa) values (?,?)");
		stmt.setLong(1, monitor.getMatricula());
		stmt.setLong(2, id);
		stmt.execute();
		con.commit();
		con.rollback();
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro não realizado, tente novamente!");
			e.printStackTrace();
		}
	}


}
