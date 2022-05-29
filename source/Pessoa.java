public class Pessoa {

	private String nome;
	private String telefone;
	private String dataNascimento;
	private String dataCadastro;
	private String ultimaAlteracao;

	public Pessoa() {

		this.nome = "";
		this.telefone = "";
		this.dataNascimento = "";
		this.dataCadastro = "";
		this.ultimaAlteracao = "";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	

	public void setUltimaAlteracao(String ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}	
	
	public String getDataCadastro() {
		return this.dataCadastro;
	}

	public String getUltimaAlteracao() {
		return this.ultimaAlteracao;
	}	
}