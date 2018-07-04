package trouble.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import trouble.domain.Labor;
import trouble.utils.C3P0Util;

public class LaborDao {

	public void addLabor(Labor labor) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO labor(NAME,password,gender,telephone,skill,address,QQ) VALUES(?,?,?,?,?,?,?)";
		qr.update(sql, labor.getName(), labor.getPassword()	,labor.getGender(), labor.getTelephone(), labor.getSkill(), labor.getAddress(),
				labor.getQQ());
	}

	public Labor findLaborByLaborNameAndPassword(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		return qr.query("select * from labor where name=? and password=?", new BeanHandler<Labor>(Labor.class),
				username, password);
	}

	public Labor findLaborById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from labor where id=?", new BeanHandler<Labor>(Labor.class), id);
	}

	public void modifyLabor(Labor labor) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update labor set password=?,gender=?,telephone=?,skill=?,address=?,QQ=? where id=?",
				labor.getPassword(), labor.getGender(), labor.getTelephone(), labor.getSkill(), labor.getAddress(),
				labor.getQQ(), labor.getId());
	}

	public List<Labor> findLabors() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from labor", new BeanListHandler<Labor>(Labor.class));
	}

}
