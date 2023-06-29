package jp.co.aforce.beans;

public class Item implements java.io.Serializable {

	private int item_no;
	private String item_name;
	private int item_price;
	

	public int getItem_no() {
		return item_no;
	}
	
	public String getItem_name() {
		return item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
	public void setItem_name(String item_name) {
		this.item_name = item_name; 
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	
}