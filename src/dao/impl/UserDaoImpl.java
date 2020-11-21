package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dao.RootDao;
import model.User;

public class UserDaoImpl extends RootDao implements UserDao {

	@Override
	public void addKhachHang(User khachHang) {
		String sql = "INSERT INTO khachhang (name,username,password,role, email) VALUES (?,?,?,?,?) ";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getName());
			preparedStatement.setString(2, khachHang.getUsername());
			preparedStatement.setString(3, khachHang.getPassword());
			preparedStatement.setString(4, khachHang.getRole());
			preparedStatement.setString(5, khachHang.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editKhachHang(User khachHang) {
		String sql = "UPDATE khachhang SET name = ?,username = ?,password = ?,role = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, khachHang.getName());
			preparedStatement.setString(2, khachHang.getUsername());
			preparedStatement.setString(3, khachHang.getPassword());
			preparedStatement.setString(4, khachHang.getRole());
			preparedStatement.setInt(5, khachHang.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteKhachHang(int id) {
		String sql = "DELETE FROM khachhang WHERE id = ?";

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
	public List<User> getAll() {
		List<User> khachHangs = new ArrayList<User>();

		String sql = "SELECT * FROM khachhang";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User khachHang = new User();
				khachHang.setId(rs.getInt("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setRole(rs.getString("role"));
				khachHangs.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHangs;
	}

	@Override
	public User getByUsername(String username) {
		String sql = "SELECT * FROM khachhang WHERE username = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User khachHang = new User();
				khachHang.setId(rs.getInt("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setRole(rs.getString("role"));
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
	public User getByID(int id) {
		String sql = "SELECT * FROM khachhang WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User khachHang = new User();
				khachHang.setId(rs.getInt("id"));
				khachHang.setName(rs.getString("name"));
				khachHang.setUsername(rs.getString("username"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setRole(rs.getString("role"));
				return khachHang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
