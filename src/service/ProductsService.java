package service;

import java.util.List;

import model.Products;

public interface ProductsService {
	void addSP(Products Products);
	
	void editSP(Products Products);
	
	void deleteSP(int id);
	
	List<Products> getAll();
	
	Products getByID(int id);
	
	List<Products> getByName(String tenSP);
	
	void updateImageSP(Products Products);
	
	List<Products> getProductByIDCategori(int id);
}
