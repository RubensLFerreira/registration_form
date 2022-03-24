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
		Integer id_cidade = Integer.parseInt(this.jIn.nextLine());
		return this.aControle.salvar(nome, id_cidade);
	}

	public void atualizar() {
		Aluno a = new Aluno();
		System.out.println("Digite o código do aluno: ");
		a.setId(Integer.parseInt(jIn.nextLine()));
		System.out.println("Digite o novo nome do aluno: ");
		a.setNome(jIn.nextLine());
		// System.out.println("Digite o ID da cidade");
		// a.setCidade(Integer.parseInt(jIn.nextLine()));
		aControle.atualizar(a);
	}

	public void listar() {
		List<Aluno> alunos = aControle.listar();
		for (Aluno aluno : alunos) {
			System.out.print("ID aluno: "  + aluno.getId() + " Nome: " + aluno.getNome());
			System.out.print(" || ID cidade: " + aluno.getCidade().getId_cidade() + " Nome cidade: " + aluno.getCidade().getNome_cidade());
			System.out.println(" || ID estado: " + aluno.getCidade().getEstado().getId_estado() + " Nome estado: " + aluno.getCidade().getEstado().getNome_estado());
		}
	}

	public void excluir() {
		System.out.println("Digite o código do aluno: ");
		aControle.excluir(Integer.parseInt(jIn.nextLine()));
	}

}
