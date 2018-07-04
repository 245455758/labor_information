package trouble.domain;

import java.io.Serializable;

public class JobOffers implements Serializable{
	
	private int id;
	private String skill_need;
	private int peo_num;
	private String claim;
	private double wage;
	private String telephone;
	private int enterprise_id;
	private String enterprise_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	public int getPeo_num() {
		return peo_num;
	}
	public void setPeo_num(int peo_num) {
		this.peo_num = peo_num;
	}
	public String getClaim() {
		return claim;
	}
	public void setClaim(String claim) {
		this.claim = claim;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public String getSkill_need() {
		return skill_need;
	}
	public void setSkill_need(String skill_need) {
		this.skill_need = skill_need;
	}
	public int getEnterprise_id() {
		return enterprise_id;
	}
	public void setEnterprise_id(int enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
	public String getEnterprise_name() {
		return enterprise_name;
	}
	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}
	@Override
	public String toString() {
		return "JobOffers [id=" + id + ", skill_need=" + skill_need + ", peoNum=" + peo_num + ", claim=" + claim
				+ ", wage=" + wage + ", telephone=" + telephone + ", enterprise_id=" + enterprise_id
				+ ", enterprise_name=" + enterprise_name + "]";
	}
	
	
	
	
	

}
