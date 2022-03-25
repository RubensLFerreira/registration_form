package Controller;

import java.util.List;

import Dao.FactoryDao;
import Model.Matricula;

public class MatriculaControl {

	
	public Matricula salvar(String status_matricula, String data_matricula, Integer id_aluno, Integer id_turma) {
		Matricula matricula = new Matricula();
		matricula.setStatus_matricula(status_matricula);
		matricula.setData_matricula(data_matricula);
		matricula.getAluno().setId(id_aluno);
		matricula.getTurma().setId_turma(id_turma);
		
		matricula.setId_matricula(FactoryDao.getMatriculaDao().salvar(matricula));
		
		return matricula;
	}
	
	public void atualizar(Matricula matricula) {
		FactoryDao.getMatriculaDao().atualizar(matricula);
	}
	
	public List<Matricula> listar() {
		return FactoryDao.getMatriculaDao().listar();
	}
	
	
	public void excluir(Integer id_matricula) {
		FactoryDao.getMatriculaDao().excluir(id_matricula);
	}
}
