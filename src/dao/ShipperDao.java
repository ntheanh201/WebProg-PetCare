package dao;

import java.util.List;

import model.Shipper;

public interface ShipperDao {
	void addShipper(Shipper cus);
	
	void editShipper(Shipper cus);
	
	void deleteShipper(String id);
	
	List<Shipper> getAll();
	
	Shipper getByUsername(String username);
	
	Shipper getByID(String id);
}
