package projeto;

public class ContraCheque {
	private Funcionario funcionario;
	private double valeTransporte, valeRefeicao, INSS, descontos, horasNaoTrabalhadas, descontoPorHoraNaoTrabalhada;
	
	public ContraCheque(Funcionario funcionario) {
		this.funcionario = funcionario;
		horasNaoTrabalhadas = this.funcionario.getHorasATrabalhar()-this.funcionario.getHorasTrabalhadas();
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
	
	public double gerarDescontoDeINSS(){//Gera o desconto do INSS com base no salário do funcionário
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
	
	public double gerarDescontoValeTransporte() {//Gera o desconto de vale transporte com base no salário do funcionário 
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
