package Model;

import java.sql.Date;
import java.sql.Time;

public class Turma {
	private Integer id_turma;
	private Time hora_inicio;
	private Time hora_fim;
	private Date dia_inicio;
	private Date dia_fim;
	private Curso curso;
	private Instrutor instrutor;
	private Filial filial;
	private Area area;
	
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}
	public Date getDia_inicio() {
		return dia_inicio;
	}
	public void setDia_inicio(Date dia_inicio) {
		this.dia_inicio = dia_inicio;
	}
	public Date getDia_fim() {
		return dia_fim;
	}
	public void setDia_fim(Date dia_fim) {
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
}
