package Model;

public class Cidade {
    private Integer id_cidade;
    private String nome_cidade;
    private Uf estado;
    
	public Uf getEstado() {
		return estado;
	}
	public void setEstado(Uf estado) {
		this.estado = estado;
	}
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getNome_cidade() {
		return nome_cidade;
	}
	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}
  
}