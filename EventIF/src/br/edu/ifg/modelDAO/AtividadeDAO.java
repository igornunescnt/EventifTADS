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
import br.edu.ifg.model.ModeloAluno;
import br.edu.ifg.model.ModeloAtividade;
import br.edu.ifg.model.ModeloEvento;

public class AtividadeDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ConnectionFactory conf = new ConnectionFactory();

	
public Vector<Vector<String>> buscaEventos(){
		
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		
		
		con = conf.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from atividade a inner join evento e on"
					+ " a.idevento=e.idevento inner join tipoatividade t on a.idtipoatividade=t.idtipoatividade");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ModeloAtividade m = new ModeloAtividade();
				m.setId(rs.getLong("idatividade"));
				m.setNome(rs.getString("nomeatividade"));
				m.setDescricao(rs.getString("descricaoatividade"));
				m.setMinistrante(rs.getString("ministranteatividade"));
				Calendar ca = Calendar.getInstance();
				ca.setTime(new Date(rs.getDate("dataatividade").getTime()));
				m.setData(ca);
				m.setHoraInicio(rs.getTimestamp("horainicio"));
				m.setHoraFim(rs.getTimestamp("horafim"));
				m.setChh(rs.getInt("chh"));
				m.setIdEvento(rs.getLong("idevento"));
				m.setIdEvento(rs.getLong("idtipoatividade"));

				
				Vector<String> me = new Vector<String>();
				me.add(m.getId()+"");
				me.add(m.getNome());
				me.add(m.getDescricao());
				me.add(m.getMinistrante());
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				me.add(sd.format(m.getData().getTime()));
				me.add(m.getHoraInicio()+"");
				me.add(m.getHoraFim()+"");
				me.add(m.getChh()+"");
				me.add(m.getVagas()+"");
				
				v.add(me);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}

	public Vector<Vector<String>> carregarTabelaAluno(){
		
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		
		ModeloAluno m = new ModeloAluno();
		
		con = conf.getConnection();
		
		try {
			ps = con.prepareStatement("select*from atividadealuno a inner join pessoaaluno p on a.matriculaaluno=p.matriculaaluno"
					+ "atividade at on a.idatividade=at.idatividade");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				ModeloAluno l = new ModeloAluno();
				l.getA().setNomePessoa(rs.getString("nomepessoa"));
				l.setMatricula(rs.getLong("matriculaaluno"));		
			
			
			Vector<String> me = new Vector<String>();
			me.add(l.getA().getNomePessoa());
			me.add(l.getMatricula()+"");
			
			v.add(me);
			}
			
			return v;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
