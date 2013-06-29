package projeto;

public class Funcionario {
	
	
	private InformacaoPessoal info;
	private int hierarquia;
	private int id;
	
	
	public Funcionario(InformacaoPessoal info, int id, int hierarquia){
		this.info = info;
		this.id = id;
		this.hierarquia = hierarquia;
	}
	public int getHierarquia() {
		return hierarquia;
	}
	public void setHierarquia(int hierarquia) {
		this.hierarquia = hierarquia;
	}
	public int getId() {
		return id;
	}
	public InformacaoPessoal getInfo() {
		return info;
	}
	public void setInfo(InformacaoPessoal info) {
		this.info = info;
	}
	
	
}
