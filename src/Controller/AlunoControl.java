package Controller;

import Dao.FactoryDao;
import Model.Aluno;

import java.util.List;

public class AlunoControl {
	
	public Aluno salvar(String nome,  Integer cidade_id){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.getCidade().setId_cidade(cidade_id);
        //aluno.getCidade().setId(cidade_id);
        
        aluno.setId(FactoryDao.getAlunoDao().salvar(aluno));
        
        return aluno;
    }

	/*
	 * public void atualizar(Aluno aluno) {
	 * FactoryDao.getAlunoDao().atualizar(aluno); }
	 */

  public List<Aluno> listar() { return FactoryDao.getAlunoDao().listar();}

	/* public void excluir(Integer id) { FactoryDao.getAlunoDao().excluir(id);} */
}
