package trouble.service;

import java.sql.SQLException;
import java.util.List;

import trouble.dao.LaborDao;
import trouble.domain.Labor;
import trouble.exception.LaborException;

public class LaborService {

	LaborDao ld = new LaborDao();
	
	public void register(Labor labor) throws LaborException {
		try {
			ld.addLabor(labor);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LaborException();
		}
	}

	public Labor login(String username, String password) throws LaborException {
		try {
			return ld.findLaborByLaborNameAndPassword(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LaborException();
		}
	}

	public Labor findLaborById(String id) throws LaborException {
		try {
			return ld.findLaborById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LaborException("用户查找失败");
		}
	}

	public void modifyLabor(Labor labor) throws LaborException {
		try {
			ld.modifyLabor(labor);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LaborException("更新用户失败");
		}
	}

	public List<Labor> findLabors() throws LaborException {
		try {
			return ld.findLabors();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LaborException();
		}
	}

}
