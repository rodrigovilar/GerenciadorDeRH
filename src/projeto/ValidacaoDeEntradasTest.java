package projeto;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class ValidacaoDeEntradasTest {

	
	ValidacaoDeEntradas v = new ValidacaoDeEntradas();
	
	@Test
	public void validaDataDeNascimento(){//ValidaÁıes do formato correto de data
		Assert.assertTrue("Esperava data v·lida", v.validaDataNascimento("15/02/2002"));
		Assert.assertFalse("Esperava data inv·lida ano",v.validaDataNascimento("10/02/20001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",v.validaDataNascimento("10/0220001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",v.validaDataNascimento("1002/20001"));
		Assert.assertFalse("Esperava data invalida(espa√ßo)",v.validaDataNascimento(" "));
		Assert.assertFalse("Esperava data invalida(letras)",v.validaDataNascimento("aa/bb/bbbb"));
	}
	
	@Test
	public void validaCPF(){
		Assert.assertTrue("Esperava CPF v·lido",v.validaCPF("08446924475"));
		Assert.assertFalse("Esperava CPF inv·lido(menor)",v.validaCPF("34825"));
		Assert.assertFalse("Esperava CPF inv·lido(maior)",v.validaCPF("3482592555454"));
		Assert.assertFalse("Esperava CPF inv·lido(letras)",v.validaCPF("ahsfehrgdtr"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("00000000000"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("11111111111"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("22222222222"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("33333333333"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("44444444444"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("55555555555"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("66666666666"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("77777777777"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("88888888888"));
		Assert.assertFalse("Esperava CPF inv·lido(repetidos)",v.validaCPF("99999999999"));
	}
	
	@Test
	public void validaRG(){
		Assert.assertTrue("Esperava RG v·lido",v.validaRG("2478965"));
		Assert.assertFalse("Esperava RG inv·lido(maior)",v.validaRG("247896546"));
		Assert.assertFalse("Esperava RG inv·lido(menor)",v.validaRG("24789"));
		Assert.assertFalse("Esperava RG inv·lido (letras)",v.validaRG("ahshehs"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("0000000"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("1111111"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("2222222"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("3333333"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("4444444"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("5555555"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("6666666"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("7777777"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("8888888"));
		Assert.assertFalse("Esperava RG inv·lido(repetidos)",v.validaCPF("9999999"));
	}
	
	@Test
	public void validaCampoDeTexto(){
		Assert.assertTrue("Esperava Dado v·lido",v.validaCampoDeTexto("Robson"));
		Assert.assertTrue("Esperava Dado inv·lido(Espa√ßo)",v.validaCampoDeTexto("Robson Soares De Lima"));
		Assert.assertFalse("Esperava Dado inv·lido(caracteres especiais)",v.validaCampoDeTexto("{Robson - Soares}"));
		Assert.assertFalse("Esperava Dado inv·lido(n√∫meros)",v.validaCampoDeTexto("1452368222"));
	}
	
	
	
	
	
	

}
