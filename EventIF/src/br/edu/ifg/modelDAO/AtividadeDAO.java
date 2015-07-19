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
import br.edu.ifg.view.Aluno;

public class AtividadeDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ConnectionFactory conf = new ConnectionFactory();

	
public Vector<Vector<String>> buscaEventos(int id){
		
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		
		
		con = conf.getConnection();
		
		try {
			//Aluno a = new Aluno();
			System.out.println(id);
			PreparedStatement ps = con.prepareStatement("select * from atividade a inner join evento e on"
					+ " a.idevento=e.idevento where a.idevento = ?");
			ps.setInt(1, id);
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
				m.setVagas(rs.getInt("vagas"));

				
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
			return v;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
