package projeto;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeRHTestluan {
	Funcionario funcionario;
	ContraCheque contraCheque;
	
	
	@Before
	public void instanciarContracheque(){
		Endereco endereco = new Endereco("rua do coisa", "3229-1475", "centro", "04", 25);
		InformacaoPessoal informacaoPessoal = new InformacaoPessoal("Fulano da silva", 
				"09347099473", "28/07/1993","3626097", endereco);
		funcionario = new Funcionario(informacaoPessoal, 01, 3, "gerente");
		funcionario.setHorasATrabalhar(30);
		funcionario.setHorasTrabalhadas(25);
		contraCheque = new ContraCheque(funcionario);
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

}
