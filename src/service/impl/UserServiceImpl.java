package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;
import util.Hasher;

public class UserServiceImpl implements UserService{
	UserDao khachHangDao = new UserDaoImpl();
	
	@Override
	public void addKhachHang(User khachHang) {
		User khachHangNew = khachHangDao.getByUsername(khachHang.getUsername());
		if(khachHangNew == null)
			khachHangDao.addKhachHang(khachHang);
		else System.out.println("Username đã tồn tại");
	}

	@Override
	public void editKhachHang(User khachHang) {
		khachHangDao.editKhachHang(khachHang);
	}

	@Override
	public void deleteKhachHang(int id) {
		khachHangDao.deleteKhachHang(id);
	}

	@Override
	public List<User> getAll() {
		return khachHangDao.getAll();
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return khachHangDao.getByUsername(username);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		String hashed = Hasher.getHash(password);
		System.out.println("hashed : " + hashed);
		User khachHang = khachHangDao.getByUsername(username);
		if(khachHang != null && khachHang.getPassword().equals(hashed)){
			return true;
		}
		return false;
	}

	@Override
	public User getByID(int id) {
		return khachHangDao.getByID(id);
	}

	

}
