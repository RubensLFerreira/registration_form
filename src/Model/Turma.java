package Model;

public class Turma {
	private Integer id_turma;
	private String hora_inicio;
	private String hora_fim;
	private String dia_inicio;
	private String dia_fim;
	private Curso cursos;
	private Instrutor instrutores;
	private Filial filiais;
	private Area area;
	
	Curso curso = new Curso();
	Instrutor instrutor = new Instrutor();
	Filial filial = new Filial();
	
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}
	public String getDia_inicio() {
		return dia_inicio;
	}
	public void setDia_inicio(String dia_inicio) {
		this.dia_inicio = dia_inicio;
	}
	public String getDia_fim() {
		return dia_fim;
	}
	public void setDia_fim(String dia_fim) {
		this.dia_fim = dia_fim;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Instrutor getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	public void setCursos(Curso cursos) {
		this.cursos = cursos;
	}
	public Instrutor getInstrutores() {
		return instrutores;
	}
	public void setInstrutores(Instrutor instrutores) {
		this.instrutores = instrutores;
	}
	public Filial getFiliais() {
		return filiais;
	}
	public void setFiliais(Filial filiais) {
		this.filiais = filiais;
	}
	
}

