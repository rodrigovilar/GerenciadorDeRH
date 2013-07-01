package projeto;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeRHTest {
	
	
	private GerenciadorDeRH gerenciador;
	private InformacaoPessoal f;
	private InformacaoPessoal g;
	
	@Before
	public void criarGerenciador() {
		gerenciador = new GerenciadorDeRH();
		f = new InformacaoPessoal("Robson", "123");
		g = new InformacaoPessoal("Robson", "122");
	}
	@Test
	public void validarListaFuncionariosVazia(){
		gerenciador.validaCadastro(f);
	}
	@Test  
	public void validarListaFuncionariosComDados(){ //valida��o de entrada de dados
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
	}
	@Test
	public void validaEdicao(){ //Valida��o de autoriza��o somente funcion�rio n�vel "1"
		
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		gerenciador.validaCadastro(g);
		gerenciador.contratarFuncionario(g,2);
		Assert.assertTrue("Esperava autoriza��o", gerenciador.validaEdicao(gerenciador.getFuncionario(0)));
		Assert.assertFalse("Esperava autoriza��o negada", gerenciador.validaEdicao(gerenciador.getFuncionario(1)));
	}
	@Test
	public void funcionarioExiste(){
		gerenciador.validaCadastro(f);
		gerenciador.contratarFuncionario(f,1);
		Assert.assertTrue("Esperava um funcion�rio cadastrado", gerenciador.verificarExistenciaFuncionario(gerenciador.getFuncionario(0)));
	}

}
