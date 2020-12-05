package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;
import dao.RootDao;
import model.Admin;

public class AdminDaoImpl extends RootDao implements AdminDao {

	@Override
	public void addAdmin(Admin admin) {
		String sql = "INSERT INTO admins (id, name, username, password, email) VALUES (?,?,?,?,?) ";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, admin.getId());
			preparedStatement.setString(2, admin.getName());
			preparedStatement.setString(3, admin.getUsername());
			preparedStatement.setString(4, admin.getPassword());
			preparedStatement.setString(5, admin.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editAdmin(Admin admin) {
		String sql = "UPDATE admins SET name = ?, username = ?, password = ?, email = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getUsername());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getEmail());
//			preparedStatement.setString(5, admin.getPhoneNumber());
//			preparedStatement.setString(6, admin.getAddress());
			preparedStatement.setString(7, admin.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAdmin(String id) {
		String sql = "DELETE FROM admins WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Admin> getAll() {
		List<Admin> admins = new ArrayList<Admin>();

		String sql = "SELECT * FROM admins";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setEmail(rs.getString("email"));
//				admin.setPhoneNumber(rs.getString("phoneNumber"));
//				admin.setAddress(rs.getString("address"));
				admin.setReg_date(rs.getDate("reg_date"));
				
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public Admin getByUsername(String username) {
		String sql = "SELECT * FROM admins WHERE username = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setEmail(rs.getString("email"));
//				admin.setPhoneNumber(rs.getString("phoneNumber"));
//				admin.setAddress(rs.getString("address"));
				admin.setReg_date(rs.getDate("reg_date"));
				
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Admin getByID(String id) {
		String sql = "SELECT * FROM admins WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
//				admin.setPhoneNumber(rs.getString("phoneNumber"));
//				admin.setAddress(rs.getString("address"));
				admin.setReg_date(rs.getDate("reg_date"));
				
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
