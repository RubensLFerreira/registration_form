package Model;

public class Instrutor {
	private Integer id_instrutor;
	private String nome_instrutor;
	private Cidade cidade;
	
	public Integer getId_instrutor() {
		return id_instrutor;
	}
	public void setId_instrutor(Integer id_instrutor) {
		this.id_instrutor = id_instrutor;
	}
	public String getNome_instrutor() {
		return nome_instrutor;
	}
	public void setNome_instrutor(String nome_instrutor) {
		this.nome_instrutor = nome_instrutor;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
