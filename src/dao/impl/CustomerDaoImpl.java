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
		String sql = "INSERT INTO khachhang (name,username,password, email) VALUES (?,?,?,?,?) ";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getName());
			preparedStatement.setString(2, khachHang.getUsername());
			preparedStatement.setString(3, khachHang.getPassword());
			preparedStatement.setString(5, khachHang.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editCustomer(Customer khachHang) {
		String sql = "UPDATE customers SET name = ?,username = ?,password = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getName());
			preparedStatement.setString(2, khachHang.getUsername());
			preparedStatement.setString(3, khachHang.getPassword());
			preparedStatement.setString(5, khachHang.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM customers WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getAll() {
		List<Customer> khachHangs = new ArrayList<Customer>();

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
				khachHangs.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHangs;
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
				return khachHang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer getByID(int id) {
		String sql = "SELECT * FROM customers WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer khachHang = new Customer();
				khachHang.setId(rs.getString("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				return khachHang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
