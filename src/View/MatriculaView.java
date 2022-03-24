package View;

import java.util.List;
import java.util.Scanner;

//import Controller.AlunoControl;
import Controller.MatriculaControl;
//import Controller.TurmaControl;
//import Model.Aluno;
import Model.Matricula;
//import Model.Turma;

public class MatriculaView {
	private Scanner jIn;
	private MatriculaControl mControle;
	
	public MatriculaView() {
		this.jIn = new Scanner(System.in);
		this.mControle = new MatriculaControl();
	}
	
	public void listar() {
		List<Matricula> matriculas = mControle.listar();
		for (Matricula matricula : matriculas) {
			System.out.println("ID matricula: " + matricula.getId_matricula()
			+ "Status da matricula: " + matricula.getStatus_matricula()
			+ "Data da matricula: " + matricula.getData_matricula()
			+ "ID do aluno: " + matricula.getAluno().getId()
			+ "ID da turma: " + matricula.getTurma().getId_turma());
		}
	}
	
	
}
