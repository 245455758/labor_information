package trouble.domain;

public class Labor {
	
	private int id;
	private String name;
	private String password;
	private String gender;
	private String telephone;
	private String role;
	private String skill;
	private String address;
	private String QQ;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	@Override
	public String toString() {
		return "Labor [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", telephone="
				+ telephone + ", role=" + role + ", skill=" + skill + ", address=" + address + ", QQ=" + QQ + "]";
	}
	
	

	

}
