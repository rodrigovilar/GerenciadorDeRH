package projeto;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeRHTest {
	
	
	private GerenciadorDeRH gerenciador;
	
	@Before
	public void criarGerenciador() {
		gerenciador = new GerenciadorDeRH();
	}
	@Test
	public void validarListaFuncionariosVazia(){
		InformacaoPessoal info = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(info);
	}
	@Test  
	public void validarListaFuncionariosComDados(){ //valida��o de entrada de dados
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		InformacaoPessoal g = new InformacaoPessoal("Robson", "122");
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
	}
	@Test
	public void validaEdicao(){ //Valida��o de autoriza��o somente funcion�rio n�vel "1"
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		InformacaoPessoal g = new InformacaoPessoal("Robson", "122");
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
		Assert.assertTrue("Esperava autoriza��o", gerenciador.validaEdicao(gerenciador.getFuncionario(0)));
		Assert.assertFalse("Esperava autoriza��o negada", gerenciador.validaEdicao(gerenciador.getFuncionario(1)));
				
	}
	@Test
	public void validaDataDeNascimento(){//Valida��es do formato correto de data
		Assert.assertTrue("Esperava data v�lida", gerenciador.validaDataNascimento("15/02/2002"));
		Assert.assertFalse("Esperava data inv�lida ano",gerenciador.validaDataNascimento("10/02/20001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",gerenciador.validaDataNascimento("10/0220001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",gerenciador.validaDataNascimento("1002/20001"));
		Assert.assertFalse("Esperava data invalida(espaço)",gerenciador.validaDataNascimento(" "));
		Assert.assertFalse("Esperava data invalida(letras)",gerenciador.validaDataNascimento("aa/bb/bbbb"));
	}
	@Test
	public void validaCPF(){
		Assert.assertTrue("Esperava CPF v�lido",gerenciador.validaCPF("08446924475"));
		Assert.assertFalse("Esperava CPF inv�lido(menor)",gerenciador.validaCPF("34825"));
		Assert.assertFalse("Esperava CPF inv�lido(maior)",gerenciador.validaCPF("3482592555454"));
		Assert.assertFalse("Esperava CPF inv�lido(letras)",gerenciador.validaCPF("ahsfehrgdtr"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("00000000000"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("11111111111"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("22222222222"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("33333333333"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("44444444444"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("55555555555"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("66666666666"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("77777777777"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("88888888888"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",gerenciador.validaCPF("99999999999"));
	}
	@Test
	public void validaRG(){
		Assert.assertTrue("Esperava RG v�lido",gerenciador.validaRG("2478965"));
		Assert.assertFalse("Esperava RG inv�lido(maior)",gerenciador.validaRG("247896546"));
		Assert.assertFalse("Esperava RG inv�lido(menor)",gerenciador.validaRG("24789"));
		Assert.assertFalse("Esperava RG inv�lido (letras)",gerenciador.validaRG("ahshehs"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("0000000"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("1111111"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("2222222"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("3333333"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("4444444"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("5555555"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("6666666"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("7777777"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("8888888"));
		Assert.assertFalse("Esperava RG inv�lido(repetidos)",gerenciador.validaCPF("9999999"));
	}
	@Test
	public void validaCampoDeTexto(){
		Assert.assertTrue("Esperava Dado v�lido",gerenciador.validaCampoDeTexto("Robson"));
		Assert.assertTrue("Esperava Dado inv�lido(Espaço)",gerenciador.validaCampoDeTexto("Robson Soares De Lima"));
		Assert.assertFalse("Esperava Dado inv�lido(caracteres especiais)",gerenciador.validaCampoDeTexto("{Robson - Soares}"));
		Assert.assertFalse("Esperava Dado inv�lido(números)",gerenciador.validaCampoDeTexto("1452368222"));
	}
	
	@Test
	public void funcionarioExiste(){
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		Assert.assertTrue("Esperava um funcion�rio cadastrado", gerenciador.verificarExistenciaFuncionario(gerenciador.getFuncionario(0)));
				
	}

}
