package trouble.service;

import java.sql.SQLException;
import java.util.List;

import trouble.dao.EnterpriseDao;
import trouble.domain.Enterprise;
import trouble.domain.PageBean;
import trouble.exception.EnterpriseException;

public class EnterpriseService {

	EnterpriseDao ed = new EnterpriseDao();
	

	public PageBean findEnterprisePage(int currentPage, int pageSize, String category) {
		try {
			int count  = ed.count(category);//得到总记录数
			int totalPage = (int)Math.ceil(count*1.0/pageSize); //求出总页数
			List<Enterprise> enterprises= ed.findEnterprises(currentPage,pageSize,category);
			
			//把5个变量封装到PageBean中，做为返回值
			PageBean pb = new PageBean();
			pb.setEnterprises(enterprises);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			//在pageBean中添加属性，用于点击上一页或下一页时使用
			pb.setCategory(category);
			
			return pb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public Enterprise findEnterpriseById(String id) throws EnterpriseException {
		try {
			return ed.findEnterpriseById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("查找企业失败");
		}
	}


	public List<Enterprise> findEnterprise() throws EnterpriseException {
		try {
			return ed.findEnterprise();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("查找企业信息失败");
		}
	}


	public List<Enterprise> findEnterpriseByManyCondition(String id, String category, String name) throws EnterpriseException {
		try {
			return ed.findEnterpriseByManyCondition(id,category,name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("条件查找企业失败");
		}
	}


	public void addEnterprise(String name, String corporate, String telephone, String category, String description,
			String img_url) throws EnterpriseException {
		try {
			ed.addEnterprise(name,corporate,telephone,category,description,img_url);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("添加企业失败");
		}
	}



	public void updateEnterprise(Enterprise enterprise) throws EnterpriseException {
		try {
			ed.updateEnterprise(enterprise);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("更新企业失败");
		}
	}


	public void deleteEnterpriseById(String id) throws EnterpriseException {
		try {
			ed.deleteEnterpriseById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EnterpriseException("删除失败");
		}
	}

}
