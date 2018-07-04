package trouble.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import trouble.domain.Enterprise;
import trouble.utils.C3P0Util;

public class EnterpriseDao {

	public int count(String category) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select count(*) from enterprise";
		// 如果category不是空，就把条件加上
		if (!"".equals(category)) {
			sql += " where nature='" + category + "'";
		}
		long l = (Long) qr.query(sql, new ScalarHandler(1));
		return (int) l;
	}

	public List<Enterprise> findEnterprises(int currentPage, int pageSize, String category) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		String sql = "select * from enterprise where 1=1";
		List list = new ArrayList();
		if (!"".equals(category)) {
			sql += " and nature=?";
			list.add(category);
		}
		sql += " limit ?,?";

		list.add((currentPage - 1) * pageSize);
		list.add(pageSize);

		return qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), list.toArray());
	}

	public Enterprise findEnterpriseById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		return qr.query("select * from enterprise where id=?", new BeanHandler<Enterprise>(Enterprise.class), id);
	}

	public List<Enterprise> findEnterprise() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from enterprise", new BeanListHandler<Enterprise>(Enterprise.class));
	}

	public List<Enterprise> findEnterpriseByManyCondition(String id, String category, String name) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from enterprise where 1=1";
		if (!"".equals(id.trim()))
			sql += " and id='" + id + "'";
		if (!"".equals(category.trim()))
			sql += " and nature='" + category + "'";
		if (!"".equals(name.trim()))
			sql += " and name='" + name + "'";
		// System.out.println(sql);
		return qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class));
	}

	public void addEnterprise(String name, String corporate, String telephone, String category, String description,
			String img_url) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO enterprise(NAME,nature,corporate,introduce,telephone,img_url) VALUES(?,?,?,?,?,?)";
		qr.update(sql,name,category,corporate,description,telephone,img_url);
		
	}

	public void updateEnterprise(String id, String name, String corporate, String telephone, String category,
			String description) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		qr.update("update enterprise set name=?,corporate=?,telephone=?,nature=?,introduce=? where id=?",name,corporate,telephone,category,description,id);
		
	}

	public void updateEnterprise(Enterprise enterprise) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update enterprise set name=?,corporate=?,telephone=?,nature=?,introduce=? where id=?",
				enterprise.getName(),enterprise.getCorporate(),enterprise.getTelephone(),enterprise.getNature(),enterprise.getIntroduce(),enterprise.getId());
	}

	public void deleteEnterpriseById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from enterprise where id=?",id);
	}

}
