package Dao;

import Model.Aluno;
import Model.Cidade;
import Model.Uf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao extends Dao {

  public List<Aluno> listar() {
    List<Aluno> alunos = new ArrayList<>();
    try {

      PreparedStatement stmt = this.conexao.prepareStatement("SELECT a.numeroMatricula, p.id, p.nome, "
              + "p.cidade_id, c.nome as nomeCidade, c.uf_id, u.nome as nomeUf "
              + "FROM aluno AS a INNER JOIN pessoa AS p ON(a.pessoa_id=p.id) "
              + "INNER JOIN cidade AS c ON(p.cidade_id=c.id) "
              + "INNER JOIN uf AS u on(u.id=c.uf_id) ORDER BY p.nome");
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Aluno aluno = new Aluno();
        Cidade cidade = new Cidade();
        Uf uf = new Uf();

        aluno.setNumeroMatricula(rs.getString("numeroMatricula"));
        aluno.setNome(rs.getString("nome"));
        aluno.setId(rs.getInt("id"));
        cidade.setNome(rs.getString("nomeCidade"));
        cidade.setId(rs.getInt("cidade_id"));
        uf.setNome(rs.getString("nomeUf"));
        uf.setId(rs.getInt("uf_id"));

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
      PreparedStatement stmt = this.conexao.prepareStatement("insert into pessoa(nome,cidade_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, aluno.getNome());
      stmt.setInt(2, aluno.getCidade().getId());
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        last_inserted_id = rs.getInt(1);
      }

      stmt = this.conexao.prepareStatement("insert into aluno(numeroMatricula,pessoa_id) values(?,?)");
      stmt.setString(1, aluno.getNumeroMatricula());
      stmt.setInt(2, last_inserted_id);
      stmt.executeUpdate();

    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }
    return last_inserted_id;
  }

  public void excluir(int id) {

    try {
      PreparedStatement stmt = this.conexao.prepareStatement("delete from aluno where pessoa_id=?");
      stmt.setInt(1, id);
      stmt.executeUpdate();

      stmt = this.conexao.prepareStatement("delete from pessoa where id=?");
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }
  }

  public  void atualizar(Aluno a) {

    try {

      PreparedStatement stmt = this.conexao.prepareStatement("update pessoa set nome=? where id=?");
      stmt.setString(1, a.getNome());
      stmt.setInt(2, a.getId());
      stmt.executeUpdate();

      stmt = this.conexao.prepareStatement("update aluno set numeroMatricula=? where pessoa_id=?");
      stmt.setString(1, a.getNumeroMatricula());
      stmt.setInt(2, a.getId());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }
  }
}