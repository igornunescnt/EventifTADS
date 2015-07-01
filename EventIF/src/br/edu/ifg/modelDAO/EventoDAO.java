package br.edu.ifg.modelDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.model.ModeloEvento;

public class EventoDAO {
	
	public Vector<Vector<String>> buscaEventos(){
		
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		
		ConnectionFactory conf = new ConnectionFactory();
		
		Connection c = conf.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("select * from evento");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ModeloEvento m = new ModeloEvento();
				m.setId(rs.getLong("idevento"));
				m.setNomeEvento(rs.getString("nomeevento"));
				m.setOrganizadorEvento(rs.getString("organizadorEvento"));
				Calendar ca = Calendar.getInstance();
				ca.setTime(new Date(rs.getDate("datainicio").getTime()));
				m.setDataInicio(ca);
				ca.setTime(new Date(rs.getDate("datafim").getTime()));
				m.setDatafim(ca);
				m.setLocal(rs.getString("localevento"));
				
				Vector<String> me = new Vector<String>();
				me.add(m.getId()+"");
				me.add(m.getNomeEvento());
				me.add(m.getOrganizadorEvento());
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				me.add(sd.format(m.getDataInicio().getTime()));
				me.add(sd.format(m.getDatafim().getTime()));
				me.add(m.getLocal());
				
				v.add(me);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}

}
