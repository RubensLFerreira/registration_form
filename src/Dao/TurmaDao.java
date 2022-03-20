package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Area;
import Model.Curso;
import Model.Filial;
import Model.Instrutor;
import Model.Turma;

public class TurmaDao extends Dao {
	
	public List<Turma> listar() {
		List<Turma> turmas = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select "
					+ "t.id_turma, t.hora_inicio, t.hora_fim,  "
					+ "c.nome_curso,  "
					+ "i.nome_instrutor,  "
					+ "f.nome_filial, f.localidade,  "
					+ "a.nome_area "
					+ "from turma t inner join curso c on (t.id_curso=c.id_curso) "
					+ "inner join area a on (c.id_area=a.id_area) "
					+ "inner join instrutor i on (t.id_instrutor=i.id_instrutor) "
					+ "inner join filial f on (t.id_filial=f.id_filial)");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Turma turma = new Turma();
				Curso curso = new Curso();
				Instrutor instrutor = new Instrutor();
				Filial filial = new Filial();
				Area area = new Area();
				//Aluno aluno = new Aluno();
				
				turma.setId_turma(rs.getInt("id_turma"));
				turma.setHora_inicio(rs.getTime("hora_inicio"));
				turma.setHora_fim(rs.getTime("hora_fim"));
				
				//curso.setId_curso(rs.getInt("id_curso"));
				curso.setNome_curso(rs.getString("nome_curso"));
				
				//instrutor.setId_instrutor(rs.getInt("id_instrutor"));
				instrutor.setNome_instrutor(rs.getString("nome_instrutor"));
				
				//filial.setId_filial(rs.getInt("id_filial"));
				filial.setNome_filial(rs.getString("nome_filial"));
				filial.setLocalidade(rs.getString("localidade"));
				
				area.setNome_area(rs.getString("nome_area"));
				
				turma.setCurso(curso);
				turma.setFilial(filial);
				turma.setInstrutor(instrutor);
			}
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		return turmas;
	}
}
