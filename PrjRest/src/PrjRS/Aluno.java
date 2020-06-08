package PrjRS;

public class Aluno {
	private int id;
	private String nome;
	private String curso;
	
	public Aluno() {}
	
	public Aluno(int id, String nome, String curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", curso=" + curso + "]";
	}
	
	
}
