package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRH implements Serializable{

	private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private int quantidadeFuncionarios = 0;
	
	
	public boolean isEmpty() {
		return listaFuncionarios.size() == 0;
	}
	public boolean validaCampoDeTexto(String s) {
		boolean temp = true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=' ' && Character.isLetter(s.charAt(i))!=true){
				temp = false;
			}
		}
		return temp;
		//return s.matches("[A-Z a-z Çç]{" + s.length() + "}");
	}

	public void validaCadastro(InformacaoPessoal info)throws ValidaCadastroException {

		if(vericarCpfExistente(info.getCpf())==true){// busca de funcionario com cpf já cadastrado
			throw new ValidaCadastroException("Funcionario existente com esse cpf!");
		}
		
				
		/*A implementação desse método depende das outras sub validações
		 * 
		 * 
		 * 
		 */
		
	}

	private boolean vericarCpfExistente(String cpf) {
		if (isEmpty() == false) {
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (getCpfFuncionario(i).equals(cpf)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean validaEdicao(Funcionario f) {
		return f.getHierarquia() == 1;
	}
	private String getCpfFuncionario(int pos) {
		return listaFuncionarios.get(pos).getInfo().getCpf();
	}
	public Funcionario getFuncionario(int pos) {
		return listaFuncionarios.get(pos);
	}
	public boolean validaDataNascimento(String dataNascimento){ //Validação de entrada do formato de Data
						
		if((dataNascimento.length()!=10)){
			return false;
		}else if((dataNascimento.charAt(2)!='/')||(dataNascimento.charAt(5))!='/'){
			return false;
		}
		
		if(Character.isDigit(dataNascimento.charAt(0))!=true||Character.isDigit(dataNascimento.charAt(0))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(3))!=true||Character.isDigit(dataNascimento.charAt(4))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(6))!=true||Character.isDigit(dataNascimento.charAt(7))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(8))!=true||Character.isDigit(dataNascimento.charAt(9))!=true){
			return false;
		}
		
		return true;
	}

	public boolean validaCPF(String cpf) {// Validação de formato CPF - "melhoramentos ainda"
		
		boolean temp = true;
		if(cpf.length()!=11){
			temp = false;
		}else{
			for(int i =0;i<cpf.length();i++){
				if(Character.isLetter(cpf.charAt(i))==true){
					temp = false;
				}
			}
		}
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
		        cpf.equals("22222222222") || cpf.equals("33333333333") ||
		        cpf.equals("44444444444") || cpf.equals("55555555555") ||
		        cpf.equals("66666666666") || cpf.equals("77777777777") ||
		        cpf.equals("88888888888") || cpf.equals("99999999999") ||
		        (cpf.length() != 11))
		temp = false;
		return temp;
	}

	public boolean validaRG(String rg) { //Validação de formato RG - "melhoramentos ainda"
		boolean temp = true;
		
		if(rg.length()!=7){
			return false;
		}else{
			for(int i =0;i<rg.length();i++){
				if(Character.isDigit(rg.charAt(i))!=true){
					temp = false;
				}
			}
		}
		
		if (rg.equals("0000000") || rg.equals("1111111") ||
				rg.equals("2222222") || rg.equals("3333333") ||
				rg.equals("4444444") || rg.equals("5555555") ||
				rg.equals("6666666") || rg.equals("7777777") ||
				rg.equals("8888888") || rg.equals("9999999")) 
				temp = false;
				
		return temp;
	}
	public boolean verificarExistenciaFuncionario(Funcionario funcionario) {
		boolean temp = false;
		
		if(isEmpty()==true){
			temp = false;
			return temp;
		}else{
			for(int i = 0 ; i<listaFuncionarios.size();i++){
				if(funcionario.equals(listaFuncionarios.get(i))){
					temp = true;
				}}
		}
		return temp; //incluir exce��o nesse m�todo -----------
	}
	public void demitirFuncionario(Funcionario f){
		verificarExistenciaFuncionario(f);
		listaFuncionarios.remove(f);
	}
	public void contratarFuncionario(InformacaoPessoal info, int hierarquia) {//contratar funcionário
		Funcionario f = new Funcionario(info, 0, hierarquia,"");
		listaFuncionarios.add(f);
	}
}
