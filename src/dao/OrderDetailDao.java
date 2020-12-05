package dao;

import java.util.List;

import model.OrderDetail;

public interface OrderDetailDao {
	void addOrderDetail(OrderDetail od);
	
	void editOrderDetail(OrderDetail od);
	
	void deleteOrderDetail(String id);
	
	List<OrderDetail> getAll();
	
	List<OrderDetail> getAllByOrder(String orderId);
	
}
