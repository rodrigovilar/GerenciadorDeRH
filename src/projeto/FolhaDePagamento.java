package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class FolhaDePagamento implements Serializable{
	//----------------------------------------------------------Atributos
	private String data;
	private String folha;
	private List<Funcionario> listaDeFuncionarios;
	//---------------------------------------------------------------------
	
	

	public FolhaDePagamento(List<Funcionario> list) {//construtor
		listaDeFuncionarios = list;
		if(list == null){
			throw new FuncionarioNullExeption("Voc� passou um array de funcion�rios nulo");
		}
		GregorianCalendar calendar = new GregorianCalendar();
		data = calendar.get(GregorianCalendar.MONTH)+"/"+calendar.get(GregorianCalendar.YEAR);
		folha = gerarFolha();
		
	}
	
	private String gerarFolha(){//gera a folha de pagamento com as devidas informações
		folha = "";
		for(int i=0; i< 60; i++){
			folha += "-";
		}
		folha += "\n\nFolha de pagamento referente ao m�s "+data;
		
		for(Funcionario funcionario: listaDeFuncionarios){
			folha += "\n\n-Nome: "+funcionario.getInfo().getNome()+
					" -Fun��o: "+funcionario.getCargo()+
					" -ID: "+funcionario.getId()+
					" -Sal�rio: "+funcionario.getSalario();
			
		}
		
		return folha;
	}
	
	//------------------------------------------------------------------------Getters e Setters
	public List<Funcionario> getListaDeFuncionarios() {
		return listaDeFuncionarios;
	}

	public void setListaDeFuncionarios(List<Funcionario> listaDeFuncionarios) {
		this.listaDeFuncionarios = listaDeFuncionarios;
	}

	public String getData() {
		return data;
	}
	public String getFolha() {
		return folha;
	}
	//------------------------------------------------------------------------------------------------
	
	

}
