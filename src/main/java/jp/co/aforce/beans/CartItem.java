package jp.co.aforce.beans;

import java.util.Objects;

public class CartItem implements java.io.Serializable {

	private int item_no;
    private String item_name;
    private int item_price;
    private int count;

    public CartItem(int item_no, String item_name, int item_price, int count) {
        this.item_no = item_no;
        this.item_name = item_name;
        this.item_price = item_price;
        this.count = count;
    }

    public int getItem_no() {
        return item_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public int getCount() {
        return count;
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
    
    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItem cartItem = (CartItem) o;
        return item_no == cartItem.item_no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_no);
    }
}