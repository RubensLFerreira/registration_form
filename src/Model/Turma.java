package Model;

import java.util.Date;

public class Turma {
  private Integer id_turma;
  private Date dateInicio;
  private Date dataFim;
  private Integer filial;
  private Instrutor instrutor;

  public Integer getId() {
    return id_turma;
  }

  public void setId(Integer id) {
    this.id_turma = id;
  }

  public Date getDateInicio() {
    return dateInicio;
  }

  public void setDateInicio(Date dateInicio) {
    this.dateInicio = dateInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public Integer getFilial() {
    return filial;
  }

  public void setFilial(Integer filial) {
    this.filial = filial;
  }

  public Instrutor getInstrutor() {
    return instrutor;
  }

  public void setInstrutor(Instrutor instrutor) {
    this.instrutor = instrutor;
  }
}
