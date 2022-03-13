package Dao;

import Model.Aluno;
import Model.Turma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

public class TurmaDao extends Dao{

  public List<Turma> listar() {
    List<Turma> turmas = new ArrayList<>();
    try {
      PreparedStatement stmt = this.conexao.prepareStatement(
                "SELECT a.numeroMatricula, p.id, p.nome, "
              + "p.cidade_id, c.nome as nomeCidade, c.uf_id, u.nome as nomeUf "
              + "FROM aluno AS a INNER JOIN pessoa AS p ON(a.pessoa_id=p.id) "
              + "INNER JOIN cidade AS c ON(p.cidade_id=c.id) "
              + "INNER JOIN uf AS u on(u.id=c.uf_id) ORDER BY p.nome");
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Aluno aluno = new Aluno();
        Turma turma = new Turma();

        turma.setId(rs.getInt("id_turma"));
        turma.setFilial(rs.getInt("id_filial"));
        //turma.setFilial(rs.getString("nome"));
        aluno.setNome(rs.getString("nome"));

        turma.setFilial(turma.getFilial());
        turmas.add(turma);
      }
    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }
    return turmas;
  }

  public Integer salvar(Turma turma) {
    Integer last_inserted_id = null;
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("insert into turma(id_turma) values(?)");
      stmt.setInt(1, turma.getId());
      //stmt.setString(2, turma.getFilial().getNome());
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        last_inserted_id = rs.getInt(1);
      }

      stmt = this.conexao.prepareStatement("insert into turma(id_turma) values(?)");
      stmt.setInt(1, turma.getId());
      stmt.executeUpdate();

    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }
    return last_inserted_id;
  }

  public void excluir(int id) {
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("delete from turma where pessoa_id=?");
      stmt.setInt(1, id);
      stmt.executeUpdate();

      stmt = this.conexao.prepareStatement("delete from pessoa where id=?");
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      System.out.println("erro" + ex.getMessage());
    }

   public void atualizar(Turma t) {
     try {
       PreparedStatement stmt = this.conexao.prepareStatement("update turma set id=?");
       stmt.setInt(1, t.getId());
       stmt.executeUpdate();

       stmt = this.conexao.prepareStatement("update turma set id=?");
       stmt.setInt(1, t.getId());
       stmt.executeUpdate();
     } catch (SQLException ex) {
       System.out.println("erro" + ex.getMessage());
     }
   }
  }
}