package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import dao.RootDao;
import model.Customer;

public class CustomerDaoImpl extends RootDao implements CustomerDao {

	@Override
	public void addCustomer(Customer khachHang) {
		String sql = "INSERT INTO customers (id, name, username, password, email, phoneNumber, address) VALUES (?,?,?,?,?,?,?) ";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getId());
			preparedStatement.setString(2, khachHang.getName());
			preparedStatement.setString(3, khachHang.getUsername());
			preparedStatement.setString(4, khachHang.getPassword());
			preparedStatement.setString(5, khachHang.getEmail());
			preparedStatement.setString(6, khachHang.getPhoneNumber());
			preparedStatement.setString(7, khachHang.getAddress());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editCustomer(Customer khachHang) {
		String sql = "UPDATE customers SET name = ?, username = ?, password = ?, email = ?, phoneNumber = ?, address = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getName());
			preparedStatement.setString(2, khachHang.getUsername());
			preparedStatement.setString(3, khachHang.getPassword());
			preparedStatement.setString(4, khachHang.getEmail());
			preparedStatement.setString(5, khachHang.getPhoneNumber());
			preparedStatement.setString(6, khachHang.getAddress());
			preparedStatement.setString(7, khachHang.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(String id) {
		String sql = "DELETE FROM customers WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<Customer>();

		String sql = "SELECT * FROM customers";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer khachHang = new Customer();
				khachHang.setId(rs.getString("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setPhoneNumber(rs.getString("phoneNumber"));
				khachHang.setAddress(rs.getString("address"));
				khachHang.setReg_date(rs.getDate("reg_date"));
				
				customers.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getByUsername(String username) {
		String sql = "SELECT * FROM customers WHERE username = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer khachHang = new Customer();
				khachHang.setId(rs.getString("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setPhoneNumber(rs.getString("phoneNumber"));
				khachHang.setAddress(rs.getString("address"));
				khachHang.setReg_date(rs.getDate("reg_date"));
				
				return khachHang;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer getByID(String id) {
		String sql = "SELECT * FROM customers WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer khachHang = new Customer();
				khachHang.setId(rs.getString("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setPhoneNumber(rs.getString("phoneNumber"));
				khachHang.setAddress(rs.getString("address"));
				khachHang.setReg_date(rs.getDate("reg_date"));
				
				return khachHang;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
