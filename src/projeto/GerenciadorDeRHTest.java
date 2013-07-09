package projeto;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeRHTest {
		
	private GerenciadorDeRH gerenciador;
	Funcionario funcionario;
	ContraCheque contraCheque;
	validacaoDeEntradas validacao;
	 
	@Before
	public void criarGerenciador() {
		gerenciador = new GerenciadorDeRH();
		Endereco endereco = new Endereco("rua do coisa", "3229-1475", "centro", "04", 25);
		InformacaoPessoal informacaoPessoal = new InformacaoPessoal("Fulano da silva", 
				"09347099473", "28/07/1993","3626097", endereco);	
		funcionario = new Funcionario(informacaoPessoal, 01, 3, "gerente");
		funcionario.setHorasATrabalhar(30);
		funcionario.setHorasTrabalhadas(25);
		contraCheque = new ContraCheque(funcionario);
		validacao = new validacaoDeEntradas();
		
	}
	
	private Endereco criarEnderecoPadrao(){//Criação de endereço para testes
		Endereco endereco = new Endereco("R. Aurora", "87651556", "Centro", "Condomínio Rio Tinto", 4);
		return endereco;
	}
	
	private InformacaoPessoal criarInformacoes1(){ //Criação de informações
		Endereco endereco = new Endereco("Rua Brasil", "884577755", "Jardiam Silvas", "27", 566);
		InformacaoPessoal info = new InformacaoPessoal("Robson", "08446924475", "20/04/1989","2478965", endereco);
		return info;
	}
	
	private InformacaoPessoal criarInformacoes2(){//Criação de informações
		Endereco endereco = new Endereco("Rua Jornal Alagoas", "884577755", "Jardim Olivera", "27", 565);
		InformacaoPessoal info = new InformacaoPessoal("Robson", "08446924475", "20/04/1989","2478965", endereco);
		return info;
	}
	
	private Funcionario criarFuncionarioNivel1(){ //Funcion�rio de teste n�vel 1
		InformacaoPessoal info = criarInformacoes1();
		Funcionario funcionario = new Funcionario(info, 001, 1, "Gerente");
		
		
		return funcionario;
	}
	
	private Funcionario criarFuncionarioNivel2(){ //Funcion�rio de teste n�vel 2
		InformacaoPessoal info = criarInformacoes2();
		Funcionario funcionario = new Funcionario(info, 002, 2, "Atendente");
		return funcionario;
	}
	private List<Funcionario> criarListaDeFuncionarios(){
		InformacaoPessoal[] infos = {new InformacaoPessoal("Caio", "098.654.345.56"),new InformacaoPessoal("Raimunda", "087.543.421.12")};
		int id = 0;
		int tamanhoDaList = 2;
		int hierarquia = 1;
		String cargo = "Auxiliar";
		List<Funcionario> funcionarios = new LinkedList<>();
		for(int i = 0; i < tamanhoDaList; i++){
			Funcionario f = new Funcionario(infos[i], id++, hierarquia++, cargo);
			funcionarios.add(f);
		}
		
		return funcionarios;
		
	}
	//------------------------Funcionario -------------------------------------------------------------
	@Test
	public void testConstrutorFuncionario(){
		List<Funcionario> funcionarios = criarListaDeFuncionarios();
		
		Assert.assertEquals(funcionarios.get(0).getInfo().getNome(), "Caio");
		Assert.assertEquals(funcionarios.get(1).getInfo().getNome(), "Raimunda");
		
		Assert.assertEquals(funcionarios.get(0).getId(), 0);
		Assert.assertEquals(funcionarios.get(1).getId(), 1);
		
		Assert.assertEquals(funcionarios.get(0).getHierarquia(), 1);
		Assert.assertEquals(funcionarios.get(1).getHierarquia(), 2);
		
		Assert.assertEquals(funcionarios.get(0).getCargo(), "Auxiliar");
		Assert.assertEquals(funcionarios.get(1).getCargo(), "Auxiliar");
		
	}
	
	@Test
	public void testContracheques(){
		Assert.assertTrue(funcionario.getContracheques().isEmpty());
		
		String contracheque = funcionario.gerarContracheque();
		Assert.assertFalse(funcionario.getContracheques().isEmpty());
		
		Assert.assertEquals(funcionario.getContracheques().get(0).getInformacoes(), contracheque);
			
	}
	
	//------------------------endereço ----------------------------------------------------------------
	@Test
	public void testDeAtributosDeEndereco(){
		Endereco enderecoPadrao = criarEnderecoPadrao();
		
		Assert.assertEquals(enderecoPadrao.getApartamento(), "Condomínio Rio Tinto");
		Assert.assertEquals(enderecoPadrao.getRua(), "R. Aurora");
		Assert.assertEquals(enderecoPadrao.getTelefone(), "87651556");
		Assert.assertEquals(enderecoPadrao.getBairro(), "Centro");
		Assert.assertEquals(enderecoPadrao.getNumeroCasaOuApartamento(), 4);
		
	}
	//------------------------FolhaDePagamento----------------------------------------------------------
	@Test(expected=FuncionarioNullExeption.class)
	public void arrayDeFuncionariosNull(){ 
		FolhaDePagamento folha = new FolhaDePagamento(null);
	}
	
	@Test
	public void testAtributos(){
		FolhaDePagamento folha = new FolhaDePagamento(criarListaDeFuncionarios()); 
		
		Assert.assertTrue(folha.getFolha() != null);
		Assert.assertTrue(folha.getData() != null);
	}
	//------------------------contra cheque -----------------------------------------------------------
	@Test(expected=FuncionarioNullExeption.class)
	public void funcionarioNull(){
		ContraCheque contraChequeTeste = new ContraCheque(null);
	}
	
	@Test
	public void testEmitirContracheque(){
		Assert.assertTrue(contraCheque.emitirContraCheque() != null);
	}
	
	@Test
	public void testeGerarDesconto(){
		funcionario.setSalario(2079.51);
		contraCheque.gerarDescontos();
		Assert.assertEquals(contraCheque.getDescontos(), 366.0167);

	}
	
	@Test
	public void testGerarDescontoPorHoraPerdida(){//verifica o valor retornado do metodo descontoPorHoraNaoTrabalhada()	
		Assert.assertEquals(contraCheque.descontoPorHoraNaoTrabalhada(),12,50);
	}
	
	@Test
	public void testeDescontoINSS() {//verifica o valor de retorno do metodo gerarDescontoDeINSS
		funcionario.setSalario(1147.70);
		Assert.assertEquals(contraCheque.gerarDescontoDeINSS(),91,82);	
		funcionario.setSalario(1247.71);
		Assert.assertEquals(contraCheque.gerarDescontoDeINSS(),112.2939);
		funcionario.setSalario(2079.51);
		Assert.assertEquals(contraCheque.gerarDescontoDeINSS(),228.7461);
	}
	
	@Test
	public void testeDescontoValeTransporte(){//verifica o valor de retorno do metodo gerarDescontoValeTransporte
		funcionario.setSalario(780);
		
		Assert.assertEquals(contraCheque.gerarDescontoValeTransporte(),46.80);	
		funcionario.setSalario(2079.51);
		
		Assert.assertEquals(contraCheque.gerarDescontoValeTransporte(),124,7706);
	}
	//----------------------------Gerenciador de RH-------------------------------------------------------------------
	
	@Test  
	public void verificarCPFExistente(){ //Verificação de CPF cadastrado
		InformacaoPessoal f = criarInformacoes1();
		gerenciador.contratarFuncionario(f, 1, 001,"Gerente");
		InformacaoPessoal g = criarInformacoes2();
		
		Assert.assertFalse("Esperava autoriza��o negada", gerenciador.vericarCpfExistente(g));
	}
	
	@Test
	public void validaEdicao(){ //Valida��o de autoriza��o somente funcion�rio n�vel "1"
		Funcionario f = criarFuncionarioNivel1();
		Funcionario g = criarFuncionarioNivel2();
		
		Assert.assertTrue("Esperava autoriza��o", gerenciador.validaEdicao(f));
		Assert.assertFalse("Esperava autoriza��o negada", gerenciador.validaEdicao(g));
	}
	
	@Test
	public void funcionarioExiste(){ //verificação de cadastro de funcionário
		InformacaoPessoal f = criarInformacoes1();
		gerenciador.contratarFuncionario(f,1,001,"Gerente");
		Funcionario g = gerenciador.getFuncionario(0);
				
	}
	
	@Test
	public void editarCargo(){//verificação de edição de cargo somente por funcionario hierarquia 1
		InformacaoPessoal f = criarInformacoes1();
		gerenciador.contratarFuncionario(f,001,1,"Gerente");
		InformacaoPessoal g = criarInformacoes1();
		gerenciador.contratarFuncionario(g,002,2,"Caixa");
		
		Assert.assertTrue("Esperava cargo editado",gerenciador.editarCargo(001,002,"Auxiliar Admistrativo"));
		Assert.assertFalse("Esperava edi��o de cargo negada",gerenciador.editarCargo(001,001,"Auxiliar Admistrativo"));
	}
	
	@Test
	public void editarSalario(){ //Edição de salário somente por funcionario hierarquia 1
		InformacaoPessoal f = criarInformacoes1();
		gerenciador.contratarFuncionario(f,001,1,"Gerente");
		InformacaoPessoal g = criarInformacoes1();
		gerenciador.contratarFuncionario(g,002,2,"Caixa");
		
		Assert.assertTrue("Esperava salario editado",gerenciador.editarSalario(001,002,200));
		Assert.assertFalse("Esperava edi��o de salario negada",gerenciador.editarSalario(001,001,200));
		
	}
	
	@Test
	public void editarHierarquia(){ //Edição de hierarquia
		InformacaoPessoal f = criarInformacoes1();
		gerenciador.contratarFuncionario(f,001,1,"Gerente");
		InformacaoPessoal g = criarInformacoes1();
		gerenciador.contratarFuncionario(g,002,2,"Caixa");
		
		Assert.assertTrue("Esperava salario editado",gerenciador.editarHierarquia(001,002,2));
		Assert.assertFalse("Esperava edi��o de salario negada",gerenciador.editarHierarquia(001,001,2));
		
	}
	  
	@Test
	public void validaDataDeNascimento(){//Valida��es de entrada do formato de data (dd/mm/aaaa)
		Assert.assertTrue("Esperava data v�lida", validacao.validaDataNascimento("15/02/2002"));
		
		Assert.assertFalse("Esperava data inv�lida ano",validacao.validaDataNascimento("10/02/20001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",validacao.validaDataNascimento("10/0220001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",validacao.validaDataNascimento("1002/20001"));
		Assert.assertFalse("Esperava data invalida(espaço)",validacao.validaDataNascimento(" "));
		Assert.assertFalse("Esperava data invalida(letras)",validacao.validaDataNascimento("aa/bb/bbbb"));
	}
	
	@Test
	public void validaCPF(){ //Validação de entrada de dados (CPF)
		Assert.assertTrue("Esperava CPF v�lido",validacao.validaCPF("08446924475"));
		
		Assert.assertFalse("Esperava CPF inv�lido(menor)",validacao.validaCPF("34825"));
		Assert.assertFalse("Esperava CPF inv�lido(maior)",validacao.validaCPF("3482592555454"));
		Assert.assertFalse("Esperava CPF inv�lido(letras)",validacao.validaCPF("ahsfehrgdtr"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("00000000000"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("11111111111"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("22222222222"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("33333333333"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("44444444444"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("55555555555"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("66666666666"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("77777777777"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("88888888888"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",validacao.validaCPF("99999999999"));
	}
	
	@Test
	public void validaRG(){ //Validação entrada de dados (RG)
		Assert.assertTrue("Esperava RG v�lido",validacao.validaRG("2478965"));
		Assert.assertFalse("Esperava RG inv�lido(maior)",validacao.validaRG("247896546"));
		Assert.assertFalse("Esperava RG inv�lido(menor)",validacao.validaRG("24789"));
		Assert.assertFalse("Esperava RG inv�lido (letras)",validacao.validaRG("ahshehs"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("0000000"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("1111111"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("2222222"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("3333333"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("4444444"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("5555555"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("6666666"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("7777777"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("8888888"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",validacao.validaCPF("9999999"));
	}
	
	@Test
	public void validaCampoDeTexto(){//Validação de entrada de dados, somente texto
		Assert.assertTrue("Esperava Dado v�lido",gerenciador.validaCampoDeTexto("Robson"));
		Assert.assertTrue("Esperava Dado inv�lido(Espaço)",gerenciador.validaCampoDeTexto("Robson Soares De Lima"));
		Assert.assertFalse("Esperava Dado inv�lido(caracteres especiais)",gerenciador.validaCampoDeTexto("{Robson - Soares}"));
		Assert.assertFalse("Esperava Dado inv�lido(números)",gerenciador.validaCampoDeTexto("1452368222"));
	}
	
}