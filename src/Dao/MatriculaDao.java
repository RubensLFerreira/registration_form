package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Matricula;
import Model.Turma;

public class MatriculaDao extends Dao {
	
	public List<Matricula> listar() {
		List<Matricula> matriculas = new ArrayList<>();
		
			try {
				PreparedStatement stmt = this.conexao.prepareStatement("select m.id_matricula, m.status_matricula, m.data_matricula, m.id_aluno, m.id_turma "
						+ " from matricula m inner join aluno a on (m.id_aluno=a.id_aluno) "
						+ " inner join turma t on (m.id_turma=t.id_turma);");
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Turma turma = new Turma();
					Aluno aluno = new Aluno();
					Matricula matricula = new Matricula();
					
					matricula.setId_matricula(rs.getInt("id_matricula"));
					matricula.setStatus_matricula(rs.getString("status_matricula"));
					matricula.setData_matricula(rs.getString("data_matricula"));
					matricula.getAluno().setId(rs.getInt("id_aluno"));
					matricula.getTurma().setId_turma(rs.getInt("id_turma"));
					
					matricula.setAluno(aluno);
					matricula.setTurma(turma);
					matriculas.add(matricula);
				}
			} catch (SQLException ex) {
				System.out.println("ERRO: " + ex.getMessage());
			}
		return matriculas;
	}
	
	public Integer salvar(Matricula matricula) {
		Integer last_inserted_id = null;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("insert into matricula (status_matricula, data_matricula, id_aluno, id_turma) "
					+ "values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, matricula.getStatus_matricula());
			stmt.setString(2, matricula.getData_matricula());
			stmt.setInt(3, matricula.getAluno().getId());
			stmt.setInt(4, matricula.getTurma().getId_turma());
			
			stmt.executeUpdate();
			 
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				last_inserted_id = rs.getInt(1);
			}
			
		} catch (SQLException ex) {
			System.out.println("ERRO: " + ex.getMessage());
		}
		return last_inserted_id;
	} 
	
	
	public void atualizar(Matricula matricula) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update matricula set status_matricula=?, data_matricula=?, id_alun0=?, id_turma=? "
					+ " where id_matricula=?");
			stmt.setString(1, matricula.getStatus_matricula());
			stmt.setString(2, matricula.getData_matricula());
			stmt.setInt(3, matricula.getAluno().getId());
			stmt.setInt(4, matricula.getTurma().getId_turma());
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("ERRO: " + ex.getMessage());
		}
	}
	
	
	public void excluir(Integer id_matricula) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete from matricula where id_matricula=?");
			stmt.setInt(1, id_matricula);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("ERRO: " + ex.getMessage());
		}
	}
}