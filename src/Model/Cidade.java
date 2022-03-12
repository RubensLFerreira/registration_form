package Model;

public class Cidade {
  private Integer id;
  private Uf estado;
  private String nome;
  private String rua;
  private String numero;
  private String cep;

  public Uf getEstado() {
    return estado;
  }

  public void setEstado(Uf estado) {
    this.estado = estado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
