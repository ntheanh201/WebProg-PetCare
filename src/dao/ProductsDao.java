package dao;

import java.util.List;

import model.Products;

public interface ProductsDao {
	void addSP(Products product);
	
	void editSP(Products product);
	
	void deleteSP(int id);
	
	List<Products> getAll();
	
	Products getByID(int id);
	
	List<Products> getByName(String tenSP);
	
	void updateImageSP(Products products);
	
	List<Products> getProductByIDCategori(int id);
}
