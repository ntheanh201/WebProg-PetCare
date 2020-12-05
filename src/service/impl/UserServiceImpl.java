//package service.impl;
//
//import java.util.List;
//
//import dao.CustomerDao;
//import dao.impl.CustomerDaoImpl;
//import model.Customer;
//import service.UserService;
//import util.Hasher;
//
//public class UserServiceImpl implements UserService{
//	CustomerDao khachHangDao = new CustomerDaoImpl();
//	
//	@Override
//	public void addKhachHang(Customer khachHang) {
//		Customer khachHangNew = khachHangDao.getByUsername(khachHang.getUsername());
//		if(khachHangNew == null)
//			khachHangDao.addCustomer(khachHang);
//		else System.out.println("Username đã tồn tại");
//	}
//
//	@Override
//	public void editKhachHang(Customer khachHang) {
//		khachHangDao.editCustomer(khachHang);
//	}
//
//	@Override
//	public void deleteKhachHang(int id) {
//		khachHangDao.deleteCustomer(id);
//	}
//
//	@Override
//	public List<Customer> getAll() {
//		return khachHangDao.getAll();
//	}
//
//	@Override
//	public Customer getByUsername(String username) {
//		// TODO Auto-generated method stub
//		return khachHangDao.getByUsername(username);
//	}
//
//	@Override
//	public boolean checkLogin(String username, String password) {
//		String hashed = Hasher.getHash(password);
//		System.out.println("hashed : " + hashed);
//		Customer khachHang = khachHangDao.getByUsername(username);
//		if(khachHang != null && khachHang.getPassword().equals(hashed)){
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public Customer getByID(int id) {
//		return khachHangDao.getByID(id);
//	}
//
//	
//
//}
