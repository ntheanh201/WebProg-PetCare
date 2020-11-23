package dao;

import java.util.List;

import model.OrderDetail;

public interface OrderDetailDao {
	void addOrderDetail(OrderDetail order);
	
	void editOrderDetil(OrderDetail order);
	
	void delteOrderDetail(int id);
	
	List<OrderDetail> getAll();
	
	OrderDetail getByID(int id);
	
		
}
