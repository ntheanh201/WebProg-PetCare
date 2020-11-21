package service;

import java.util.List;

import model.User;

public interface UserService {
	void addKhachHang(User khachHang);
	
	void editKhachHang(User khachHang);
	
	void deleteKhachHang(int id);
	
	List<User> getAll();
	
	User getByUsername(String username);
	
	User getByID(int id);
	
	boolean checkLogin(String username, String password);
}
