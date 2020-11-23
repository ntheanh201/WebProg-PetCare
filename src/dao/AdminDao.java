package dao;


import model.Admin;

public interface AdminDao {
	
	void editAdmin(Admin ad);
	
	Admin getAdminDetail(String username);		
}
