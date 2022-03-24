package Controller;

import java.util.List;

import Dao.FactoryDao;
import Model.Turma;

public class TurmaControl {
	
	public Turma salvar(String hora_inicio, String hora_fim, String dia_inicio, String dia_fim, Integer id_curso, Integer id_Instrutor, Integer id_filial) {
		Turma turma = new Turma();
		turma.setHora_inicio(hora_inicio);
		turma.setHora_fim(hora_fim);
		turma.setDia_inicio(dia_inicio);
		turma.setDia_fim(dia_fim);
		turma.getCurso().setId_curso(id_curso);
		turma.getInstrutor().setId_instrutor(id_Instrutor);
		turma.getFilial().setId_filial(id_filial);
		
		turma.setId_turma(FactoryDao.getTurmaDao().salvar(turma));
		
		return turma;
	}
	
	public void atualizar(Turma turma) {
		FactoryDao.getTurmaDao().atualizar(turma);
	}

	public List<Turma> listar() {
		return FactoryDao.getTurmaDao().listar();
	}
	
	public void excluir(Integer id_turma) {
		FactoryDao.getTurmaDao().excluir(id_turma);
	}
}
