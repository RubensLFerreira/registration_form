package Model;

public class Matricula {
	private Integer id_matricula;
	private String status_matricula;
	private String data_matricula;
	
	private Aluno aluno;
	private Turma turma;
	
	private Aluno alunos;
	private Turma turmas;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	public Turma getTurmas() {
		return turmas;
	}
	public void setTurmas(Turma turmas) {
		this.turmas = turmas;
	}
	public Integer getId_matricula() {
		return id_matricula;
	}
	public void setId_matricula(Integer id_matricula) {
		this.id_matricula = id_matricula;
	}
	public String getStatus_matricula() {
		return status_matricula;
	}
	public void setStatus_matricula(String status_matricula) {
		this.status_matricula = status_matricula;
	}
	public String getData_matricula() {
		return data_matricula;
	}
	public void setData_matricula(String data_matricula) {
		this.data_matricula = data_matricula;
	}
}
