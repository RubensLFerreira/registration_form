package View;

import java.util.List;
import java.util.Scanner;

//import Controller.AlunoControl;
import Controller.MatriculaControl;
//import Controller.TurmaControl;
//import Model.Aluno;
import Model.Matricula;
//import Model.Turma;
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
	
	public Matricula salvar() {

		System.out.println("Digite o status damatricula: ");
		String status_matricula = this.jIn.nextLine();
		
		System.out.println("Digite a data da matricula: ");
		String data_matricula = this.jIn.nextLine();

		System.out.println("Digite o id do aluno");
		Integer id_aluno = Integer.parseInt(this.jIn.nextLine());
		
		System.out.println("Digite o id da turma: ");
		Integer id_turma = Integer.parseInt(this.jIn.nextLine());
		
		return this.mControle.salvar(status_matricula, data_matricula, id_aluno, id_turma);
	}
	
	public void atualizar() {
		Matricula m = new Matricula();
		
		System.out.println("Digite o ID da matricula: ");
		m.setId_matricula(Integer.parseInt(jIn.nextLine()));

		System.out.println("Digite o status da matricula: ");
		m.setStatus_matricula(jIn.nextLine());
		
		System.out.println("Digite a data da matricula: ");
		m.setData_matricula(jIn.nextLine());
		
		System.out.println("Digite um novo id de aluno: ");
		m.getAluno().setId(Integer.parseInt(jIn.nextLine()));
		
		System.out.println("Digite um novo id de turma: ");
		m.getTurma().setId_turma(Integer.parseInt(jIn.nextLine()));

		mControle.atualizar(m);
		
	}
	
	
	public void excluir() {
		System.out.println("Digite o ID da matricula: ");
		mControle.excluir(Integer.parseInt(jIn.nextLine()));
	}
}
