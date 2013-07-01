package projeto;

public class Endereco {

	private String rua;
	private String telefone;
	private String bairro;
	private String apartamento;
	private int numeroCasaOuApartamento;

	public Endereco(String rua, String telefone, String bairro, String apartamento, int numeroCasa){

		this.rua = rua;
		this.telefone = telefone;
		this.bairro = bairro;
		this.apartamento = apartamento;
		this.numeroCasaOuApartamento = numeroCasa;

	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public int getNumeroCasaOuApartamento() {
		return numeroCasaOuApartamento;
	}
	public void setNumeroCasaOuApartamento(int numeroCasaOuApartamento) {
		this.numeroCasaOuApartamento = numeroCasaOuApartamento;
	}


}