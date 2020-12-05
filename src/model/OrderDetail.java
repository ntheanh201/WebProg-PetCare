package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String product_id;
	private String order_id;
	private int quantity;
	
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(String product_id, String order_id, int quantity) {
		super();
		this.product_id = product_id;
		this.order_id = order_id;
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
