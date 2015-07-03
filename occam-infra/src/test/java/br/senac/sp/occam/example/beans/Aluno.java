package br.senac.sp.occam.example.beans;

public class Aluno {
	private Integer id;
	private String nome;
	private int idade;
	private float notaFinal;
	private boolean aprovado;
	
	public Aluno() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		return String.format(
				"Aluno [id=%s, nome=%s, idade=%s, notaFinal=%s, aprovado=%s]",
				id, nome, idade, notaFinal, aprovado);
	}

}
