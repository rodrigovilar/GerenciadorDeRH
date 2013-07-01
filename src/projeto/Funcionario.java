package projeto;

public class Funcionario {

	private double salario;
	private int horasTrabalhadas, horasATrabalhar;
	private InformacaoPessoal info;
	private int hierarquia;
	private int id;
	private String cargo;


	public Funcionario(InformacaoPessoal info, int id, int hierarquia, String cargo){
		this.info = info;
		this.id = id;
		this.hierarquia = hierarquia;
		this.cargo = cargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public int getHorasATrabalhar() {
		return horasATrabalhar;
	}
	public void setHorasATrabalhar(int horasATrabalhar) {
		this.horasATrabalhar = horasATrabalhar;
	}
	public void setId(int id) {
		this.id = id;
	}

}
