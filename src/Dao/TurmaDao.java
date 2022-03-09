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

public class TurmaDao {
  public List<Turma> turmas = new ArrayList<>();

    try

    {
      PreparedStatement stmt = this.conexao.prepareStatement();
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Aluno aluno = new Aluno();
        Turma turma = new Turma();

        turma.setId(rs.getInt("id_turma"));
        turma.setFilial(rs.getInt("id_filial"));
        turma.setFilial(rs.getString("nome_filial"));
        aluno.setNome(rs.getString("nome"));

        turma.setFilial(turma.getFilial());
        turmas.add(turma);
      }
    } catch(
    SQLException ex)

    {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
    return turmas;

  public Integer salvar(Turma turma) {
    Integer last_inserted_id = null;
    try {
      PreparedStatement stmt = this.conexao.prepareStatement();
      stmt.setInt(1, turma.getFilial().getId());
      stmt.setString(2, turma.getFilial().getNome());
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        last_inserted_id = rs.getInt(1);
      }

      stmt = this.conexao.prepareStatement();
      stmt.setInt(1, turma.getId());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}



