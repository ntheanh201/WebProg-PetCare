package dao;

import java.util.List;

import model.User;

public interface UserDao {
	void addKhachHang(User khachHang);
	
	void editKhachHang(User khachHang);
	
	void deleteKhachHang(int id);
	
	List<User> getAll();
	
	User getByUsername(String username);
	
	User getByID(int id);
}
