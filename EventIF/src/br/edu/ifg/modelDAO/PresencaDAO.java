package br.edu.ifg.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.model.ModeloAluno;

public class PresencaDAO {
	
	Connection con = null;
	ConnectionFactory conf = new ConnectionFactory();
	PreparedStatement ps = null;
	
	public Vector<Vector<String>> carregarTabelaAluno(){
		
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		
		ModeloAluno m = new ModeloAluno();
		
		con = conf.getConnection();
		
		try {
			ps = con.prepareStatement("select*from pessoa p inner join pessoaaluno pa on p.idpessoa=pa.idpessoa"
									+ " inner join alunoatividade aa on aa.matriculaaluno=pa.matriculaaluno");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				ModeloAluno l = new ModeloAluno();
				l.setMatricula(rs.getLong("matriculaaluno"));		
				l.getA().setNomePessoa(rs.getString("nomepessoa"));
			
			
			Vector<String> me = new Vector<String>();
			me.add(l.getMatricula()+"");
			me.add(l.getA().getNomePessoa());
			
			v.add(me);
			}
			
			return v;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
/*	public Vector<String> checkin(){
		
		con = conf.getConnection();
		ps = con.prepareStatement("select extract(hour from sum(age(horasaida,horaentrada)))*60 as frequencia from alunoatividade a where a.matriculaaluno = 2; 
");
		
		
		return 
	}*/


}
