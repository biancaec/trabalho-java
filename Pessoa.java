public class Pessoa {

	private String nome;
	private String tel;
	private String nasc; //data nascimento
	private String cad; //data de cadastro
	private String alt; //data ultima alteracao

	public Pessoa() {

		this.nome = "";
		this.tel = "";
		this.nasc = "";
		this.cad = "";
		this.alt = "";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}

	public void setCad(String cad) {
		this.cad = cad;
	}	

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTel() {
		return this.tel;
	}

	public String getNasc() {
		return this.nasc;
	}	
	
	public String getCad() {
		return this.cad;
	}

	public String getAlt() {
		return this.alt;
	}	
}