package Dao;

/*import Model.Cidade;
import Model.Uf;*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Cidade;
import Model.Uf;

public class AlunoDao extends Dao {

	public List<Aluno> listar() {
		List<Aluno> alunos = new ArrayList<>();
		try {

			PreparedStatement stmt = this.conexao
					.prepareStatement("select a.id_aluno, a.nome_aluno, c.id_cidade, c.nome_cidade,  e.nome_estado, "
							+ "e.id_estado from aluno a inner join cidade c on (a.id_cidade=c.id_cidade) inner join estado e on (e.id_estado=c.id_estado)");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				Cidade cidade = new Cidade();
				Uf uf = new Uf();

				// aluno.setNumeroMatricula(rs.getString("numeroMatricula"));
				aluno.setNome(rs.getString("nome_aluno"));
				aluno.setId(rs.getInt("id_aluno"));

				cidade.setNome_cidade(rs.getString("nome_cidade"));
				cidade.setId_cidade(rs.getInt("id_cidade"));

				uf.setNome_estado(rs.getString("nome_estado"));
				uf.setId_estado(rs.getInt("id_estado"));

				cidade.setEstado(uf);
				aluno.setCidade(cidade);
				alunos.add(aluno);
			}
		} catch (SQLException ex) {
			System.out.println("erro" + ex.getMessage());
		}
		return alunos;
	}

	public Integer salvar(Aluno aluno) {
		Integer last_inserted_id = null;
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(
					"insert into aluno (nome_aluno, id_cidade) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getNome());
			// stmt.setInt(2, aluno.getCidade().getId());
			stmt.setInt(2, aluno.getCidade().getId_cidade());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				last_inserted_id = rs.getInt(1);
			}

		} catch (SQLException ex) {
			System.out.println("erro" + ex.getMessage());
		}
		return last_inserted_id;
	}

	public void atualizar(Aluno a) {

		try {

			PreparedStatement stmt = this.conexao.prepareStatement("update aluno set nome_aluno=? where id_aluno=?");
			stmt.setString(1, a.getNome());
			stmt.setInt(2, a.getId());
			// stmt.setInt(3, a.getCidade().getId_cidade());
			stmt.executeUpdate();

			/*
			 * stmt = this.conexao.
			 * prepareStatement("update aluno set numeroMatricula=? where pessoa_id=?");
			 * stmt.setString(1, a.getNumeroMatricula()); stmt.setInt(2, a.getId());
			 * stmt.executeUpdate();
			 */
		} catch (SQLException ex) {
			System.out.println("erro" + ex.getMessage());
		}
	}

	public void excluir(Integer id) {

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("delete from aluno where id_aluno=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

			/*stmt = this.conexao.prepareStatement("delete from pessoa where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();*/
		} catch (SQLException ex) {
			System.out.println("erro" + ex.getMessage());
		}
	}

}
