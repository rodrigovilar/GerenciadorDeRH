package projeto;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class FolhaDePagamento implements Serializable{
	private String data;
	private String folha;
	
	public FolhaDePagamento(Funcionario[] funcionarios) {
		if(funcionarios == null){
			throw new FuncionarioNullExeption("Você passou um array de funcionários nulo");
		}
		GregorianCalendar calendar = new GregorianCalendar();
		data = calendar.get(GregorianCalendar.MONTH)+"/"+calendar.get(GregorianCalendar.YEAR);
		folha = gerarFolha(funcionarios);
		System.out.println(folha);
		
	}
	
	public String gerarFolha(Funcionario[] funcionarios){
		String folha = "";
		for(int i=0; i< 60; i++){
			folha += "-";
		}
		folha += "\n\nFolha de pagamento referente ao mês "+data;
		
		for(Funcionario funcionario: funcionarios){
			folha += "\n\n-Nome: "+funcionario.getInfo().getNome()+
					" -Função: "+funcionario.getCargo()+
					" -ID: "+funcionario.getId()+
					" -Salário: "+funcionario.getSalario();
			
		}
		
		return folha;
		
	}

}
