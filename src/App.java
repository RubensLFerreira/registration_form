//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

//import Model.Aluno;
//import Model.Matricula;
import View.AlunoView;
import View.Main;
import View.MatriculaView;
import View.TurmaView;

public class App {

	public static void main(String[] args) {
		AlunoView alunoView = new AlunoView();
		//List<Aluno> alunos = new ArrayList<>();
		
		TurmaView turmaView = new TurmaView();
		//List<Aluno> turmas = new ArrayList<>();
		
		MatriculaView matriculaView = new MatriculaView();
		//List<Matricula> matriculas = new ArrayList<>();
		
		Scanner jIn = new Scanner(System.in);
		Integer opcao = null;
		do {
			Main.menu();
			System.out.println("Digite a opção: ");
			opcao = Integer.parseInt(jIn.nextLine());

			switch (opcao) {

			case 1:
				alunoView.salvar();
				break;

			case 2:
				alunoView.atualizar();
				break;

			case 3:
				alunoView.listar();
				break;
				
			case 4:
				alunoView.excluir();
				break;
				
			case 5:
				turmaView.salvar();
				break;
				
			case 6:
				turmaView.atualizar();
				break;
				
			case 7:
				turmaView.listar();
				break;
				
			case 8:
				turmaView.excluir();
				break;
				
			case 9:
				matriculaView.salvar();
				break;
				
			case 10:
				matriculaView.atualizar();
				break;
				
			case 11:
				matriculaView.listar();
				break;
				
			case 12:
				matriculaView.excluir();
				break;
			}
			
		} while (opcao != 0);
		jIn.close();
	}

}
