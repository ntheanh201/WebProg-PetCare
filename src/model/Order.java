package model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String status;
	private float total_price;
	private String customer_id;
	private Date date;

	public Order() {
		super();
	}

	public Order(String status, float total_price, String customer_id, Date date) {
		super();
		this.status = status;
		this.total_price = total_price;
		this.customer_id = customer_id;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
