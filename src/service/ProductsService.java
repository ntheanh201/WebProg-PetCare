package service;

import java.util.List;

import model.Product;

public interface ProductsService {
	void addSP(Product Products);
	
	void editSP(Product Products);
	
	void deleteSP(int id);
	
	List<Product> getAll();
	
	Product getByID(int id);
	
	List<Product> getByName(String tenSP);
	
	void updateImageSP(Product Products);
	
	List<Product> getProductByIDCategori(int id);
}
