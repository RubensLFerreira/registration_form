package Model;

public class Aluno extends Pessoa {
  private String numeroMatricula;


    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

  public boolean Persistir() {
    return true;
  }

}
