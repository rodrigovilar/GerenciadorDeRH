package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRH implements Serializable {
	//---------------------------------------------------------------------------------------Atributos
	private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private List<FolhaDePagamento> folhaDePagamento = new ArrayList<FolhaDePagamento>();
	//------------------------------------------------------------------------------------------------
	
	public boolean isEmpty() {//verifica se não existem funcionarios em listaFuncionarios
		return listaFuncionarios.size() == 0;
	}

	public boolean validaCampoDeTexto(String s) {
		boolean temp = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && Character.isLetter(s.charAt(i)) != true) {
				temp = false;
			}
		}
		return temp;
	}

	public boolean vericarCpfExistente(InformacaoPessoal info) {
		if (isEmpty() == false) {
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (getCpfFuncionario(i).equals(info.getCpf())) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean validaEdicao(Funcionario f) {
		return f.getHierarquia() == 1;
	}

	private String getCpfFuncionario(int pos) {
		return listaFuncionarios.get(pos).getInfo().getCpf();
	}

	public Funcionario getFuncionario(int pos) throws RuntimeException {
		if (listaFuncionarios.isEmpty() == true) {
			throw new CadastroFuncionarioException(
					"Nenhum funcionario cadastrado!");
		} else if (pos > listaFuncionarios.size()) {
			throw new CadastroFuncionarioException(
					"Funcionario não cadastrado!");
		}

		return listaFuncionarios.get(pos);
	}

	public boolean verificarExistenciaFuncionario(Funcionario funcionario) {
		boolean temp = true;

		if (isEmpty() == false) {
			return temp;
		} else {
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (funcionario.equals(listaFuncionarios.get(i))) {
					temp = false;
				}
			}
		}
		return temp;
	}

	public void demitirFuncionario(Funcionario f) {
		verificarExistenciaFuncionario(f);
		listaFuncionarios.remove(f);
	}

	public void contratarFuncionario(InformacaoPessoal info, int id,
			int hierarquia, String cargo) {// contratar funcionário
		Funcionario f = new Funcionario(info, id, hierarquia, cargo);
		listaFuncionarios.add(f);
	}

	public boolean editarCargo(int id, int idF, String cargo) {//adicionada----------------------------
		if (id == idF) {
			return false;
		} else if (validaEdicao(buscaFuncionarioID(id)) == true) {
			if (buscaFuncionarioID(idF) != null) {
				Funcionario temp = buscaFuncionarioID(idF);
				temp.setCargo(cargo);
				return true;
			}
		}

		return false;
	}

	public Funcionario buscaFuncionarioID(int id) { //adicionada-----------------------
		Funcionario temp = null;
		if (isEmpty() != true) {
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (id == listaFuncionarios.get(i).getId()) {
					temp = listaFuncionarios.get(i);
				}
			}
		}
		return temp;
	}
	public boolean editarSalario(int id, int idF, double salario){//adicionada-----------------------
		if (id == idF) {
			return false;
		} else if (validaEdicao(buscaFuncionarioID(id)) == true) {
			if (buscaFuncionarioID(idF) != null) {
				Funcionario temp = buscaFuncionarioID(idF);
				temp.setSalario(salario);
				return true;
			}
		}

		return false;
	}

	public boolean editarHierarquia(int id, int idF, int hierarquia) {//adicionada---------------------
		if (id == idF) {
			return false;
		} else if (validaEdicao(buscaFuncionarioID(id)) == true) {
			if (buscaFuncionarioID(idF) != null) {
				Funcionario temp = buscaFuncionarioID(idF);
				temp.setHierarquia(hierarquia);
				return true;
			}
		}

		return false;
	}

}
