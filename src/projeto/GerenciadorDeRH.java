package projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRH {

	private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	public boolean isEmpty() {
		return listaFuncionarios.size() == 0;
	}

	public void contratarFuncionario(InformacaoPessoal info, int hierarquia) {//contratar funcionário
		Funcionario f = new Funcionario(info, 0, hierarquia);
		listaFuncionarios.add(f);
	}
	
	public boolean validaCaracteres(InformacaoPessoal info) { // Falta implementar
		return info.getNome().matches("[A-Z a-z Çç]{" + info.getNome().length() + "}");
	}

	public void validaCadastro(InformacaoPessoal info)throws ValidaCadastroException {

		if(vericarCpfExistente(info.getCpf())==true){// busca de funcionario com cpf já cadastrado
			throw new ValidaCadastroException("Funcionario existente com esse cpf!");
		}
		
		if (validaCaracteres(info) != true) {
			throw new ValidaCadastroException("Caracteres inválidos");
		}
		
		/*A implementação desse método depende da outra sub validações
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
																//Ainda precisa de melhoramentos
		
				
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
		return temp;
	}

	public boolean validaRG(String rg) { //Validação de formato RG - "melhoramentos ainda"
		
		boolean temp = true;
		
		if(rg.length()>7||rg.length()<7){
			return false;
		}else{
			for(int i =0;i<rg.length();i++){
				if(Character.isDigit(rg.charAt(i))!=true){
					temp = false;
				}
			}
		}
		
		return temp;
	}

}
