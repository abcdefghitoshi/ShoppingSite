package jp.co.aforce.beans;

public class Product2 implements java.io.Serializable {

	private String admin_id;
	private String password;
	

	public String getMember_id() {
		return admin_id;
	}
	
	public String getPassword() {
		return password;
	}


	public void setMember_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}

	
}