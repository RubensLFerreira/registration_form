package View;

import java.util.List;
import java.util.Scanner;

import Controller.TurmaControl;
import Model.Turma;

public class TurmaView {
	private Scanner jIn;
	private TurmaControl aControle;
	
	public TurmaView() {
		this.jIn = new Scanner(System.in);
		this.aControle = new TurmaControl();
	}
	
	public void listar() {
		List<Turma> turmas = aControle.listar();
		for (Turma turma : turmas) {
			System.out.println("ID turma: " + turma.getId_turma() + " Horario de inicio: " + turma.getHora_inicio() + " Horario de fim: " + turma.getHora_fim());
			System.out.println(" Nome do curso: " + turma.getCurso().getNome_curso());
			System.out.println(" Nome do instrutor: " + turma.getInstrutor().getNome_instrutor());
			System.out.println(" Nome da filial: " + turma.getFilial().getNome_filial() + " localidade: " + turma.getFilial().getLocalidade());
			System.out.println(" Nome da area: " + turma.getArea().getNome_area());
		}
	}
}
