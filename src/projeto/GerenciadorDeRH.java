package projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRH {

	private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
	
	public boolean isEmpty() {
		return listaFuncionarios.size() == 0;
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
	public void demitirFuncionario(Funcionario f){
		verificarExistenciaFuncionario(f);
		listaFuncionarios.remove(f);
	}
	public void contratarFuncionario(InformacaoPessoal info, int hierarquia) {//contratar funcionário
		Funcionario f = new Funcionario(info, 0, hierarquia);
		listaFuncionarios.add(f);
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
}
