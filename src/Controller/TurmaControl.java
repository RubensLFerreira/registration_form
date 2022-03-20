package Controller;

import java.util.List;

import Dao.FactoryDao;
import Model.Turma;

public class TurmaControl {
	public List<Turma> listar() {
		return FactoryDao.getTurmaDao().listar();
	}
}
