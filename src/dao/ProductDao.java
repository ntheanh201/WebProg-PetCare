package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(String id);
	
	List<Product> getAll();
	
	Product getByID(String id);
	
	List<Product> getByName(String productName);
	
	void updateImage(Product product);
	
	List<Product> getProductByCategory(String categoryId);
}
