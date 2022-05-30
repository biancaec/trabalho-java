import java.time.LocalDate;

public class Pessoa {

	private String nome;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataCadastro;
	private LocalDate ultimaAlteracao;

	public Pessoa() {

		this.nome = "";
		this.telefone = "";
		this.dataNascimento = LocalDate.now();
		this.dataCadastro = LocalDate.now();
		this.ultimaAlteracao = LocalDate.now();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	

	public void setUltimaAlteracao(LocalDate ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}	
	
	public LocalDate getDataCadastro() {
		return this.dataCadastro;
	}

	public LocalDate getUltimaAlteracao() {
		return this.ultimaAlteracao;
	}	
}