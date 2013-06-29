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
	public void validarListaFuncionariosComDados(){ //validações de entrada de dados
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		InformacaoPessoal g = new InformacaoPessoal("Robson", "122");
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
	}
	@Test
	public void validaEdicao(){ //Validação de autorização somente funcionário nível "1"
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		InformacaoPessoal g = new InformacaoPessoal("Robson", "122");
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
		Assert.assertTrue("Esperava autorização", gerenciador.validaEdicao(gerenciador.getFuncionario(0)));
		Assert.assertFalse("Esperava autorização negada", gerenciador.validaEdicao(gerenciador.getFuncionario(1)));
				
	}
	@Test
	public void validaDataDeNascimento(){//Validações do formato correto de data
		Assert.assertTrue("Esperava data válida", gerenciador.validaDataNascimento("15/02/2002"));
		Assert.assertFalse("Esperava data inválidaano",gerenciador.validaDataNascimento("10/02/20001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",gerenciador.validaDataNascimento("10/0220001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",gerenciador.validaDataNascimento("1002/20001"));
		Assert.assertFalse("Esperava data invalida(espaço)",gerenciador.validaDataNascimento(" "));
		Assert.assertFalse("Esperava data invalida(letras)",gerenciador.validaDataNascimento("aa/bb/bbbb"));
	}
	@Test
	public void validaCPF(){
		
		Assert.assertTrue("Esperava CPF válido",gerenciador.validaCPF("08446924475"));
		Assert.assertFalse("Esperava CPF válido(menor)",gerenciador.validaCPF("34825"));
		Assert.assertFalse("Esperava CPF válido(maior)",gerenciador.validaCPF("3482592555454"));
		Assert.assertFalse("Esperava CPF válido(letras)",gerenciador.validaCPF("085169a9475"));
	}
	@Test
	public void validaRG(){
		Assert.assertTrue("Esperava RG válido",gerenciador.validaRG("2478965"));
		Assert.assertFalse("Esperava RG inválido(maior)",gerenciador.validaRG("247896546"));
		Assert.assertFalse("Esperava RG inválido(menor)",gerenciador.validaRG("24789"));
		Assert.assertFalse("Esperava RG inválido (letras)",gerenciador.validaRG("24s8f65"));
	}

}
