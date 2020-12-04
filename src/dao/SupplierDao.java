package dao;

import java.util.List;

import model.Supplier;

public interface SupplierDao {
	void addSupplier(Supplier Supplier);
	
	void editSupplier(Supplier product);
	
	void deleteSupplier(String id);
	
	List<Supplier> getAllSuppliers();
	
	Supplier getSupplierByID(String id);
}
