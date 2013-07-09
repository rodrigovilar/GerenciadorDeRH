package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Serializable{
	//-------------------------------------------------------------Atributos
	private double salario;
	private int horasTrabalhadas, horasATrabalhar;
	private InformacaoPessoal info;
	private int hierarquia;
	private int id;
	private String cargo;
	private ArrayList<ContraCheque> contracheques = new ArrayList<>();
	//---------------------------------------------------------------------


	
	public Funcionario(InformacaoPessoal info, int id, int hierarquia, String cargo){//construtor
		this.info = info;
		this.id = id;
		this.hierarquia = hierarquia;
		this.cargo = cargo;
	}
	
	//-------------------------------------------------------------------Getters e Setters
	public ArrayList<ContraCheque> getContracheques() {
		return contracheques;
	}
	public String gerarContracheque(){
		ContraCheque contraCheque = new ContraCheque(this);
		contracheques.add(contraCheque);
		return contraCheque.getInformacoes();
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
	//--------------------------------------------------------------------------
}

