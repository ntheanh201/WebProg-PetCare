package dao;


import java.util.List;

import model.Admin;

public interface AdminDao {
	
	void addAdmin(Admin ad);
	
	void editAdmin(Admin ad);
	
	void deleteAdmin(String id);
	
	List<Admin> getAll();
	
	Admin getByUsername(String username);
	
	Admin getByID(String id);
}
