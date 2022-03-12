import Model.Aluno;
import View.AlunoView;
import View.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    AlunoView alunoView = new AlunoView();
    List<Aluno> alunos = new ArrayList<>();

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
      }
    } while (opcao != 0);
  }
}
