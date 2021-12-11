public class Aluno extends Pessoa {

	private float nota;

	public Aluno() {
		super();
		this.nota = 0;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public float getNota() {
		return this.nota;
	}
}