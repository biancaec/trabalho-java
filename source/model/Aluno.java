package model;

public class Aluno extends Pessoa {

	private float nota;

	public Aluno(float nota) {
		super();
		this.nota = nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public float getNota() {
		return this.nota;
	}
}