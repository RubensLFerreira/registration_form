package Dao;

public class FactoryDao {
  public static AlunoDao getAlunoDao() {
    return new AlunoDao();
  }

  public static TurmaDao getTurmaDao() {
    return new TurmaDao();
  }

  public static MatriculaDao getMatriculaDao() {
    return new MatriculaDao();
  }
}
