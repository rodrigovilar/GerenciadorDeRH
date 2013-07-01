package projeto;

public class InformacaoPessoal {

	private String nome;
	private Endereco endereco;
	private String dataDeNascimento;
	private String identidade;
	private String cpf;

	public InformacaoPessoal(String nome, String cpf, String data,String identidade, Endereco endereco){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco =  endereco;
		this.dataDeNascimento = data;
		this.identidade = identidade;
	}

	public InformacaoPessoal(String nome, String cpf){ //construtor temporario
		this.nome = nome;
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}

