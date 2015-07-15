package br.edu.ifg.modelDAO;

import java.awt.List;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.edu.ifg.bd.ConnectionFactory;
import br.edu.ifg.model.ModeloAluno;
import br.edu.ifg.model.ModeloPessoa;
import br.edu.ifg.view.CadastrarAtividade;
import br.edu.ifg.view.CadastrarPessoa;
import br.edu.ifg.view.Login;

public class AlunoDAO {

	ConnectionFactory conf = null;

	public AlunoDAO() {
		conf = new ConnectionFactory();
	}

	public void inserir(ModeloAluno aluno) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = conf.getConnection();
			con.setAutoCommit(false);

			stmt = con.prepareStatement("insert into enderecopessoa "
					+ "(numero, cep, complemento,idcidade, bairro) values (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getA().getEndereco().getNumero());
			stmt.setString(2, aluno.getA().getEndereco().getCep());
			stmt.setString(3, aluno.getA().getEndereco().getComplemento());
			stmt.setLong(4, aluno.getA().getEndereco().getCidade());
			stmt.setString(5, aluno.getA().getEndereco().getBairro());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			int id = 0;
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}

			stmt = con.prepareStatement("insert into pessoa (nomePessoa, cpfPessoa,emailPessoa,rgPessoa,"
					+ "telefonePessoa,senhaPessoa,idEnderecoPessoa) values (?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getA().getNomePessoa());
			stmt.setString(2, aluno.getA().getCpfPessoa());
			stmt.setString(3, aluno.getA().getEmailPessoa());
			stmt.setString(4, aluno.getA().getRgPessoa());
			stmt.setString(5, aluno.getA().getTelefonePessoa());
			stmt.setString(6, aluno.getA().getSenhaPessoa());
			stmt.setLong(7, id);

			stmt.executeUpdate();
			ResultSet rs1 = stmt.getGeneratedKeys();
			id = 0;
			if (rs1 != null && rs1.next()) {
				id = rs1.getInt(1);
			}

			stmt = con
					.prepareStatement("insert into pessoaaluno (idPessoa) values (?)");
			stmt.setLong(1, id);
			stmt.execute();

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

			con.commit();
			con.rollback();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Cadastro não realizado, tente novamente! " + e.getMessage());
			//e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				JOptionPane
				.showMessageDialog(null, "erro ao fechar a conexão!");
			}
		}
	}

	public Vector<Vector<String>> buscar() {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = conf.getConnection();
			stmt = con
					.prepareStatement("select  p.idpessoa, p.nomepessoa,p.cpfpessoa,p.rgpessoa,e.bairro,c.nomecidade from pessoa p inner join enderecopessoa e "
							+ "on p.idenderecopessoa =  e.idenderecopessoa inner join cidade c "
							+ "on e.idcidade=c.idcidade inner join pessoaaluno pa on p.idpessoa=pa.idpessoa ");

			ResultSet rs = stmt.executeQuery();

			Vector<Vector<String>> aluno = new Vector<Vector<String>>();
			ModeloAluno a1 = new ModeloAluno();

			while (rs.next()) {
				Vector<String> a = new Vector<String>();

				a1.getA().setIdPessoa(rs.getLong("idpessoa"));
				a1.getA().setNomePessoa(rs.getString("nomepessoa"));
				a1.getA().setCpfPessoa(rs.getString("cpfpessoa"));
				a1.getA().setRgPessoa(rs.getString("rgpessoa"));
				a1.getA().getEndereco().setBairro(rs.getString("bairro"));
				a1.getA().getEndereco().setCidade(rs.getString("nomecidade"));
				a.add(a1.toString());
				aluno.add(a);
			}
			return aluno;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Nenhum contato encontrado, tente novamente!");
			//e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				JOptionPane
				.showMessageDialog(null, "erro ao fechar a conexão!");
			}
		}
	}

	public void atualizar(ModeloAluno aluno) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = conf.getConnection();
			con.setAutoCommit(false);

			stmt = con.prepareStatement(
					"UPDATE enderecopessoa set numero = ?, cep = '?', complemento = '?',"
							+ "idcidade = ?, bairro = '?')",
							Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getA().getEndereco().getNumero());
			stmt.setString(2, aluno.getA().getEndereco().getCep());
			stmt.setString(3, aluno.getA().getEndereco().getComplemento());
			stmt.setLong(4, aluno.getA().getEndereco().getCidade());
			stmt.setString(5, aluno.getA().getEndereco().getBairro());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			int id = 0;
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}

			stmt = con
					.prepareStatement(
							"UPDATE pessoa SET nomePessoa = '?', cpfPessoa ='?' ,emailPessoa='?',rgPessoa='?',"
									+ "telefonePessoa='?',senhaPessoa='?',idEnderecoPessoa = ?)",
									Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getA().getNomePessoa());
			stmt.setString(2, aluno.getA().getCpfPessoa());
			stmt.setString(3, aluno.getA().getEmailPessoa());
			stmt.setString(4, aluno.getA().getRgPessoa());
			stmt.setString(5, aluno.getA().getTelefonePessoa());
			stmt.setString(6, aluno.getA().getSenhaPessoa());
			stmt.setLong(7, id);

			stmt.executeUpdate();
			ResultSet rs1 = stmt.getGeneratedKeys();
			id = 0;
			if (rs1 != null && rs1.next()) {
				id = rs1.getInt(1);
			}

			stmt = con.prepareStatement("UPDATE pessoaaluno matriculaAluno=?, idPessoa=?)");
			stmt.setLong(1, aluno.getMatricula());
			stmt.setLong(2, id);
			stmt.execute();
			con.commit();
			con.rollback();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Atualização não realizada, tente novamente!");
			//e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "erro ao fechar a conexão!");
			}
		}
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
