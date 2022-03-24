package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Model.Filial;
import Model.Instrutor;
import Model.Turma;

public class TurmaDao extends Dao {
	
	public List<Turma> listar() {
		List<Turma> turmas = new ArrayList<>();
		
			try {
				PreparedStatement stmt = this.conexao.prepareStatement("select "
						+ "t.id_turma, t.hora_inicio, t.hora_fim, t.dia_inicio, t.dia_fim, "
						+ "c.id_curso, c.nome_curso,  "
						+ "i.id_instrutor, i.nome_instrutor,  "
						+ "f.id_filial, f.nome_filial, f.localidade  "
						+ "from turma t inner join curso c on (t.id_curso=c.id_curso) "
						+ "inner join instrutor i on (t.id_instrutor=i.id_instrutor) "
						+ "inner join filial f on (t.id_filial=f.id_filial) "
						+ "ORDER BY t.id_turma;");
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Turma turma = new Turma();
					Curso curso = new Curso();
					Instrutor instrutor = new Instrutor();
					Filial filial = new Filial();
					
					turma.setId_turma(rs.getInt("id_turma"));
					turma.setHora_inicio(rs.getString("hora_inicio"));
					turma.setHora_fim(rs.getString("hora_fim"));
					turma.setDia_inicio(rs.getString("dia_inicio"));
					turma.setDia_fim(rs.getString("dia_fim"));
					curso.setNome_curso(rs.getString("nome_curso"));
					instrutor.setNome_instrutor(rs.getString("nome_instrutor"));
					filial.setNome_filial(rs.getString("nome_filial"));
					filial.setLocalidade(rs.getString("localidade"));
					
					turma.setCurso(curso);
					turma.setInstrutor(instrutor);
					turma.setFilial(filial);
					
					turmas.add(turma);
				}
			} catch (SQLException ex) {
				System.out.println("ERRO: " + ex.getMessage());
			}
			return turmas;
		}
	
	
	
	public Integer salvar(Turma turma) {
		Integer last_inserted_id = null;
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("insert into turma (hora_inicio, hora_fim, dia_inicio, dia_fim, id_curso, id_instrutor, id_filial)"
					+ " values(?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, turma.getHora_inicio());
			stmt.setString(2, turma.getHora_fim());
			stmt.setString(3, turma.getDia_inicio());
			stmt.setString(4, turma.getDia_fim());
			stmt.setInt(5, turma.getCurso().getId_curso());
			stmt.setInt(6, turma.getInstrutor().getId_instrutor());
			stmt.setInt(7, turma.getFilial().getId_filial());
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
	
	
	
	public void atualizar(Turma turma) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update turma set hora_inicio=?, hora_fim=?, dia_inicio=?, dia_fim=?, id_curso=?, id_instrutor=?, id_filial=? "
					+ " where id_turma=?");
			stmt.setString(1, turma.getHora_inicio());
			stmt.setString(2, turma.getHora_fim());
			stmt.setString(3, turma.getDia_inicio());
			stmt.setString(4, turma.getDia_fim());
			stmt.setInt(5, turma.getCurso().getId_curso());
			stmt.setInt(6, turma.getInstrutor().getId_instrutor());
			stmt.setInt(7, turma.getFilial().getId_filial());
			stmt.setInt(8, turma.getId_turma());
			 
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("ERRO: " + ex.getMessage());
		}
	}
	
	
	
	public void excluir(Integer id_turma) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete from turma where id_turma=?");
			stmt.setInt(1, id_turma);
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
	}
}
