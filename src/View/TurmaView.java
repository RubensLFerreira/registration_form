package View;

import java.util.List;
import java.util.Scanner;

import Controller.TurmaControl;
import Model.Turma;

public class TurmaView {
	private Scanner jIn;
	private TurmaControl tControle;
	
	public TurmaView() {
		this.jIn = new Scanner(System.in);
		this.tControle = new TurmaControl();
	}
	
	public void listar() {
		List<Turma> turmas = tControle.listar();
		for (Turma turma : turmas) {
			System.out.println("ID turma: " + turma.getId_turma() + " || Horario de inicio: " + turma.getHora_inicio() + " || Horario de fim: " + turma.getHora_fim() + " || Dia de inicio: " + turma.getDia_inicio() + " || dia de fim: "+ turma.getDia_fim()
			+ " || Nome do curso: " + turma.getCurso().getNome_curso()
			+ " || Nome do instrutor: " + turma.getInstrutor().getNome_instrutor()
			+ " || Nome da filial: " + turma.getFilial().getNome_filial()
			+ " || localidade: " + turma.getFilial().getLocalidade());

		}
	}
	
	public Turma salvar() {

		System.out.println("Digite a hora de inicio");
		String hora_inico = this.jIn.nextLine();
		
		System.out.println("Digite a hora de fim");
		String hora_fim = this.jIn.nextLine();
		
		System.out.println("Digite uma dia de inicio");
		String dia_inicio = this.jIn.nextLine();
		
		System.out.println("Digite uma dia de fim");
		String dia_fim = this.jIn.nextLine();
		
		System.out.println("Digite o id do curso");
		Integer id_curso = Integer.parseInt(this.jIn.nextLine());
		 
		System.out.println("Digite o id do instrutor");
		Integer id_instrutor = Integer.parseInt(this.jIn.nextLine());
		 
		System.out.println("Digite o id do filial");
		Integer id_filial = Integer.parseInt(this.jIn.nextLine());
		 
		
		return this.tControle.salvar(hora_inico, hora_fim, dia_inicio, dia_fim, id_curso, id_instrutor, id_filial );
	}
	
	public void atualizar() {
		Turma t = new Turma();
		
		System.out.println("Digite o código da turma: ");
		t.setId_turma(Integer.parseInt(jIn.nextLine()));
		
		System.out.println("Digite o novo horario de inicio: ");
		t.setHora_inicio(jIn.nextLine());
		
		System.out.println("Digite o novo horario de fim: ");
		t.setHora_fim(jIn.nextLine());
		
		System.out.println("Digite um novo dia de inicio: ");
		t.setDia_inicio(jIn.nextLine());
		
		System.out.println("Digite um novo dia de fim: ");
		t.setDia_fim(jIn.nextLine());
		
		System.out.println("Digite um novo id de curso: ");
		t.getCurso().setId_curso(Integer.parseInt(jIn.nextLine()));
		 
		System.out.println("Digite um novo id de instrutor: ");
		t.getInstrutor().setId_instrutor(Integer.parseInt(jIn.nextLine()));
		 
		System.out.println("Digite um novo id de filial: ");
		t.getFilial().setId_filial(Integer.parseInt(jIn.nextLine()));
		

		tControle.atualizar(t);
		
	}
	
	public void excluir() {
		System.out.println("Digite o ID da turma: ");
		tControle.excluir(Integer.parseInt(jIn.nextLine()));
	}
}
