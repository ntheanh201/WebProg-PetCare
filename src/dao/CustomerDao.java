package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	void addCustomer(Customer cus);
	
	void editCustomer(Customer cus);
	
	void deleteCustomer(int id);
	
	List<Customer> getAll();
	
	Customer getByUsername(String username);
	
	Customer getByID(int id);
}
