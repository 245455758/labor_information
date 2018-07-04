package trouble.domain;

import java.util.List;

public class PageBean {
	private int currentPage;
	private int pageSize;
	private int count;
	private int totalPage;
	private List<Enterprise> enterprises;
	private String category;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Enterprise> getEnterprises() {
		return enterprises;
	}
	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}
	
	
	
}
