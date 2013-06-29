package projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRH {

	 List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	

	public boolean isEmpty() {
		return listaFuncionarios.size() == 0;
	}
	
	public boolean  validaCaracteres(InformacaoPessoal info){ //Falta implementar
				
		return info.getNome().matches("[A-Z a-z Çç]{"+info.getNome().length()+"}");
			
	}
	
	public void validaCadastro(InformacaoPessoal info) throws ValidaCadastroException{

		if (isEmpty() == false) {
			for (int i = 0; i < listaFuncionarios.size(); i++) {//busca de funcionario com cpf já cadastrado
				if (listaFuncionarios.get(i).getInfo().getCpf()==info.getCpf()) {
					throw new ValidaCadastroException("Funcionario existente com esse cpf!");
					
				}
				
			}
		}
		if(validaCaracteres(info)!=true){
			throw new ValidaCadastroException("Caracteres inválidos");
		}
		
	}

	public void contratarFuncionario(InformacaoPessoal info, int hierarquia) {
		Funcionario f = new Funcionario(info, 0, hierarquia);
		listaFuncionarios.add(f);
	}

	public boolean validaEdicao() {
		// TODO Auto-generated method stub
		return false;
	}

}
