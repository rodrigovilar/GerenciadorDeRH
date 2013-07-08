package projeto;

import java.util.GregorianCalendar;

public class ContraCheque {
	private Funcionario funcionario;
	private double valeTransporte, INSS, descontos, horasNaoTrabalhadas, descontoPorHoraNaoTrabalhada;
	
	public ContraCheque(Funcionario funcionario) throws FuncionarioNullExeption{//construtor
		if(funcionario != null){			
			this.funcionario = funcionario;
			horasNaoTrabalhadas = this.funcionario.getHorasATrabalhar()-this.funcionario.getHorasTrabalhadas();
		}else{
			throw new FuncionarioNullExeption("Foi passado um parametro nulo!!!");
		}
	}
		
	public String emitirContraCheque(){
		String contraCheque = "";
		this.gerarDescontos();
		for(int i = 0; i < 60; i++){
			contraCheque += "-";
		}
		contraCheque += toStringContraCheque();
		return contraCheque;	
	}

	private String toStringContraCheque() {
		GregorianCalendar calendar = new GregorianCalendar();  
		return "\n Contracheque referente ao m�s "+calendar.get(GregorianCalendar.MONTH)+"/"+calendar.get(GregorianCalendar.YEAR)+
				
						"\n\nInforma��es pessoais>>>"+
						"\n\t\tFuncionario: "+funcionario.getInfo().getNome()+
						"\n\t\tCPF: "+funcionario.getInfo().getCpf()+
						"\n\t\tData de Nascimento: "+funcionario.getInfo().getDataDeNascimento()+
						
						"\n\nInforma��es individuais>>>"+
						"\n\t\tId: "+funcionario.getId()+
						"\n\t\tCargo: "+funcionario.getCargo()+
						"\n\t\tHoras trabalhadas: "+funcionario.getHorasTrabalhadas()+
						
						"\n\nDescontos>>>"+
						"\n\t\tVale transporte: "+this.gerarDescontoValeTransporte()+
						"\n\t\tINSS: "+this.gerarDescontoDeINSS()+
						"\n\t\tHoras n�o trabalhadas: "+this.descontoPorHoraNaoTrabalhada()+
						"\n\t\tTotal de descontos: "+this.getDescontos()+
						
						"\n\nSal�rio:>>>"+
						"\n\t\tTotal: "+funcionario.getSalario()+
						"\n\t\tCom descontos: "+(funcionario.getSalario()-this.descontos);
	}
	
	public void gerarDescontos(){
		valeTransporte = gerarDescontoValeTransporte();
		INSS = gerarDescontoDeINSS();
		descontoPorHoraNaoTrabalhada = descontoPorHoraNaoTrabalhada();
	
		descontos = valeTransporte + INSS + descontoPorHoraNaoTrabalhada;	
	}
	
	public double descontoPorHoraNaoTrabalhada(){
		double valorDescontadoPorHora = 2.50;
		return horasNaoTrabalhadas * valorDescontadoPorHora;
	}
	
	public double gerarDescontoDeINSS(){//Gera o desconto do INSS com base no sal�rio do funcion�rio
		double porcentagemDeDesconto;
		double salario = funcionario.getSalario();
		
		if(salario <= 1247.70){
			porcentagemDeDesconto = 8.0;}
		else if(salario <= 2079.50){
			porcentagemDeDesconto = 9.0;}
		else{
			porcentagemDeDesconto = 11.0;}
		return (porcentagemDeDesconto / 100.0) * salario;
	}
	
	public double gerarDescontoValeTransporte() {//Gera o desconto de vale transporte com base no sal�rio do funcion�rio 
		double porcentagemDescontoValeTransporte = 6.0;
		return (porcentagemDescontoValeTransporte / 100.0)*funcionario.getSalario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public double getDescontos() {
		return descontos;
	}

	public void setDescontos(double descontos) {
		this.descontos = descontos;
	}
	
}
