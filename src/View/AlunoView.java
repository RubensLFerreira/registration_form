package View;

import Controller.AlunoControl;
import Model.Aluno;

import java.util.List;
import java.util.Scanner;

public class AlunoView {

  private Scanner jIn;
  private AlunoControl aControle;

  public AlunoView() {
    this.jIn = new Scanner(System.in);
    this.aControle = new AlunoControl();
  }

  public Aluno salvar() {
    System.out.println("Digite o nome do aluno:");
    String nome = this.jIn.nextLine();
    System.out.println("Digite o codigo da cidade do aluno:");
    Integer cidade_id = Integer.parseInt(this.jIn.nextLine());
    return this.aControle.salvar(nome, cidade_id);
  }

  public void atualizar() {
    Aluno a = new Aluno();
    System.out.println("Digite o código do aluno: ");
    a.setId(Integer.parseInt(jIn.nextLine()));
    System.out.println("Digite o novo nome do aluno: ");
    a.setNome(jIn.nextLine());
    aControle.atualizar(a);
  }

  public List<Aluno> listar(){
    return aControle.listar();
  }

  public void excluir() {
    System.out.println("Digite o código do aluno: ");
    aControle.excluir(Integer.parseInt(jIn.nextLine()));
  }
}
