package jp.co.aforce.beans;

public class Product implements java.io.Serializable {

	private String member_id;
	private String password;
	

	public String getMember_id() {
		return member_id;
	}
	
	public String getPassword() {
		return password;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}

	
}