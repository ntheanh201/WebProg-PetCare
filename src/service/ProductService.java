package service;

import java.util.List;

import model.Product;

public interface ProductService {
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(int id);
	
	List<Product> getAll();
	
	Product getByID(int id);
	
	List<Product> getByName(String productName);
	
	void updateImage(Product product);
	
	List<Product> getProductByCategory(int categoryId);
}
