package edu.csula.jaxrs;

import java.sql.Date;



public class Order {
	enum Statuses {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}
	int order_id;
	int item_id;
	String item_img;
	 String castomer_name;
	 Date created;
	 String statuse; 
	public Order(int id,int item_id,String item_img,String customer_name,Date created,String statuse) {
		
		this.order_id = id;
		this.item_id=item_id;
		this.item_img=item_img;
		this.castomer_name=customer_name;
		this.created=created;
		this.statuse=statuse;
				
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int id) {
		this.order_id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getCastomer_name() {
		return castomer_name;
	}
	public void setCastomer_name(String castomer_name) {
		this.castomer_name = castomer_name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getStatuse() {
		return statuse;
	}
	public void setStatuse(String statuse) {
		this.statuse = statuse;
	}
	
	
}