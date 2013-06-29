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
	public void validarListaVazia(){
		InformacaoPessoal info = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(info);
	}
	@Test
	public void validarListaComDados(){
		InformacaoPessoal f = new InformacaoPessoal("Robson", "123");
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,2);
		InformacaoPessoal g = new InformacaoPessoal("Robson", "122");
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,1);
	}
	@Test
	public void validaEdicao(){
		Assert.assertTrue("Esperava autorização", gerenciador.validaEdicao());
		
		
		
	}

}
