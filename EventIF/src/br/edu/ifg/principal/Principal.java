package br.edu.ifg.principal;

import br.edu.ifg.controll.ControleAluno;
import br.edu.ifg.controll.ControleCadastrar;
import br.edu.ifg.controll.ControleLogin;
import br.edu.ifg.modelDAO.AlunoDAO;
import br.edu.ifg.view.Aluno;
import br.edu.ifg.view.Login;

public class Principal {

	public static void main(String[] args) {

		Login l = new Login();
		ControleLogin cl = new ControleLogin(l);
		
		//Aluno b = new Aluno();
		//ControleAluno c = new ControleAluno(b);
		//AlunoDAO a = new AlunoDAO();
		//ModeloAluno m = new ModeloAluno();
		/*m.setMatricula(222);
		m.getA().setCpfPessoa("222");
		m.getA().setNomePessoa("Luisao");
		m.getA().setEmailPessoa("efea@afa.com");
		m.getA().getEndereco().setBairro("adfa");
		m.getA().getEndereco().setCep("dasd");
		m.getA().getEndereco().setCidade(2l);
		m.getA().getEndereco().setComplemento("dafdga");
		m.getA().getEndereco().setNumero(1);
		m.getA().getEndereco().setRua("zsxx");
		m.getA().getEndereco().setUf(2l);
		m.getA().setRgPessoa("222");
		m.getA().setSenhaPessoa("123");
		m.getA().setTelefonePessoa("34234");
		a.inserir(m);

		
		ModeloMonitor b = new ModeloMonitor();
		MonitorDAO n = new MonitorDAO();
		
		b.setMatricula(111);
		b.getM().setCpfPessoa("11111111111");
		b.getM().setNomePessoa("testmonitor");
		b.getM().setEmailPessoa("monitor@gmail.com");
		b.getM().getEndereco().setBairro("formosinha");
		b.getM().getEndereco().setCep("73813290");
		b.getM().getEndereco().setCidade(1l);
		b.getM().getEndereco().setComplemento("prox.");
		b.getM().getEndereco().setNumero(1);
		b.getM().getEndereco().setRua("19");
		b.getM().getEndereco().setUf(1l);
		b.getM().setRgPessoa("1111111");
		b.getM().setSenhaPessoa("000");
		b.getM().setTelefonePessoa("556198594985");
		
		n.inserir(b); */
		
		//a.buscar();
		//a.atualizar(m);
		
		
	}

}
