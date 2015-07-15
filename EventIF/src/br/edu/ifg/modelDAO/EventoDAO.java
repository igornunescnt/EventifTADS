package br.edu.ifg.modelDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.model.ModeloEvento;
import br.edu.ifg.view.GerenciarEvento;

public class EventoDAO {

	PreparedStatement ps = null;
	Connection c = null;
	ConnectionFactory conf = new ConnectionFactory();
	GerenciarEvento ge = null;


	public Vector<Vector<String>> pesquisarEvento(ModeloEvento me){
		c = conf.getConnection();

		Vector<Vector<String>> v = new Vector<Vector<String>>();

		try {
			ps = c.prepareStatement("select*from evento where nomeevento like '%"+ge.getTextField().getText()+"%'");
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

				Vector<String> me1 = new Vector<String>();
				me1.add(m.getId()+"");
				me1.add(m.getNomeEvento());
				me1.add(m.getOrganizadorEvento());
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				me1.add(sd.format(m.getDataInicio().getTime()));
				me1.add(sd.format(m.getDatafim().getTime()));
				me1.add(m.getLocal());

				v.add(me1);
			} 
			return v;

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "busca incorreta!"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void inserir(ModeloEvento me){

		c = conf.getConnection();

		try {
			ps = c.prepareStatement("insert into enderecoevento (rua,bairro,cep,complemento,idcidade) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, me.getEndereco().getRua());
			ps.setString(2, me.getEndereco().getBairro());
			ps.setString(3, me.getEndereco().getCep());
			ps.setString(4, me.getEndereco().getComplemento());
			ps.setLong(5, me.getEndereco().getCidade());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}

			ps = c.prepareStatement("insert into evento (nomeevento,organizadorevento,datainicio,datafim,localevento,idenderecoevento) "
					+ "values (?,?,?,?,?,?)");
			ps.setString(1, me.getNomeEvento());
			ps.setString(2, me.getOrganizadorEvento());
			ps.setDate(3, new Date(me.getDataInicio().getTime().getTime()));
			ps.setDate(4, new Date(me.getDatafim().getTime().getTime()));
			ps.setString(5, me.getLocal());
			ps.setLong(6, id);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso!");


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "não foi possivel realizar o cadastro!");
			e.printStackTrace();
		}
	}

	/*public void atualiza(String end,String ev){

		c = conf.getConnection();

		try {
			ps = c.prepareStatement("update enderecoevento set "+end+" = ",PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}
			
			ps =  c.prepareStatement("update evento set idenderecoevento "+ev+"= ");
			ps.setLong(1, id);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Atualização não realizada!");
			e.printStackTrace();
		}
	}
	public void deleta(ModeloEvento me){
		c = conf.getConnection();

		try {
			ps = c.prepareStatement("delete from evento where idevento = ?");
			ps.setLong(1, me.getId());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Evento deletado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel essa ação!" + e.getMessage());
			e.printStackTrace();
		}
	}
*/
	public Vector<Vector<String>> buscaEventos(){

		Vector<Vector<String>> v = new Vector<Vector<String>>();


		c = conf.getConnection();

		try {
			ps = c.prepareStatement("select * from evento");
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

	public ResultSet Estado() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = conf.getConnection();
			stmt = con.prepareStatement("select ufestado from estado");
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}		



	public ResultSet Cidade(int idEstado) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = conf.getConnection();
			stmt = con.prepareStatement("select nomecidade from cidade where idestado="+idEstado);
			ResultSet rs = stmt.executeQuery();

			return rs;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
