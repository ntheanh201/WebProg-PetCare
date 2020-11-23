package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	void addOrder(Order order);
	
	void editOrder(Order order);
	
	void delteOrder(int id);
	
	List<Order> getAll();
	
	Order getByID(int id);
	
		
}
