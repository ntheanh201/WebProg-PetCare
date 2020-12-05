package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	void addOrder(Order order);
	
	void changeOrderStatus(Order order);
	
	void deleteOrder(String id);
	
	List<Order> getAll();	
}
