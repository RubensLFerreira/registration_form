package Dao;

import Model.Aluno;
import Model.Cidade;
import Model.Uf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao {
  List<Aluno> alunos = new ArrayList<>();

  try
  {
    PreparedStatement stmt = this.conexao.preparedStatement("SELECT a.numeroMatricula, p.id, p.nome, "
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
      aluno.setNome(rs.getString("nome_aluno"));
      aluno.setId(rs.getInt("id_aluno"));
      cidade.setId(rs.getInt("id_cidade"));
      cidade.setNome(rs.getString("nome_cidade"));
      uf.setId(rs.getInt("id_uf"));
      uf.setNome(rs.getNome("nome_uf"));

      cidade.setEstado(uf);
      aluno.setCidade(cidade);
      alunos.add(aluno);
    } catch(SQLException ex){
    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
  }
    return alunos;
  }

  public Interger salvar(Aluno aluno) {
    Integer last_insert_id = null;
    try {
      PreparedStatement stmt = this.conexao.preparedStatement();
      stmt.setString(1, aluno.getNome());
      stmt.setInt(2, aluno.getCidade().getId());
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (re.next()) {
        last_insert_id = rs.getInt(1);
      }

      stmt = this.conexao.preparedStatement();
      stmt.setString(1, aluno.getNumeroMatricula());
      stmt.setInt(2, last_insert_id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
    return last_insert_id;
  }

  public void excluir(int id) {
    try {
      PreparedStatement stmt = this.conexao.preparedStatement();
      stmt.setInt(1, id);
      stmt.executeUpdate();

      stmt = this.conexao.preparedStatement();
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void atualizar(Aluno a) {
    try {
      PreparedStatement stmt = this.conexao.preparedStatement();
      stmt.setString(1, a.getNome());
      stmt.setInt(2, a.getId());
      stmt.executeUpdate();

      stmt = this.conexao.preparedStatement();
      stmt.setString(1, a.getNumeroMatricula());
      stmt.setInt(2, a.getId());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
