package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ShipperDao;
import dao.RootDao;
import model.Shipper;

public class ShipperDaoImpl extends RootDao implements ShipperDao {

	@Override
	public void addShipper(Shipper shipper) {
		String sql = "INSERT INTO shippers (id, name, username, password, email) VALUES (?,?,?,?,?) ";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, shipper.getId());
			preparedStatement.setString(2, shipper.getName());
			preparedStatement.setString(3, shipper.getUsername());
			preparedStatement.setString(4, shipper.getPassword());
			preparedStatement.setString(5, shipper.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editShipper(Shipper shipper) {
		String sql = "UPDATE shippers SET name = ?, username = ?, password = ?, email = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, shipper.getName());
			preparedStatement.setString(2, shipper.getUsername());
			preparedStatement.setString(3, shipper.getPassword());
			preparedStatement.setString(4, shipper.getEmail());
//			preparedStatement.setString(5, shipper.getPhoneNumber());
//			preparedStatement.setString(6, shipper.getAddress());
			preparedStatement.setString(7, shipper.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteShipper(String id) {
		String sql = "DELETE FROM shippers WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Shipper> getAll() {
		List<Shipper> Shippers = new ArrayList<Shipper>();

		String sql = "SELECT * FROM shippers";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Shipper shipper = new Shipper();
				shipper.setId(rs.getString("id"));
				shipper.setName(rs.getString("name"));
				shipper.setUsername(rs.getString("username"));
				shipper.setPassword(rs.getString("password"));
				shipper.setEmail(rs.getString("email"));
//				shipper.setPhoneNumber(rs.getString("phoneNumber"));
//				shipper.setAddress(rs.getString("address"));
				shipper.setReg_date(rs.getDate("reg_date"));
				
				Shippers.add(shipper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Shippers;
	}

	@Override
	public Shipper getByUsername(String username) {
		String sql = "SELECT * FROM shippers WHERE username = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Shipper shipper = new Shipper();
				shipper.setId(rs.getString("id"));
				shipper.setName(rs.getString("name"));
				shipper.setUsername(rs.getString("username"));
				shipper.setPassword(rs.getString("password"));
				shipper.setEmail(rs.getString("email"));
//				shipper.setPhoneNumber(rs.getString("phoneNumber"));
//				shipper.setAddress(rs.getString("address"));
				shipper.setReg_date(rs.getDate("reg_date"));
				
				return shipper;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Shipper getByID(String id) {
		String sql = "SELECT * FROM shippers WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Shipper shipper = new Shipper();
				shipper.setId(rs.getString("id"));
				shipper.setName(rs.getString("name"));
				shipper.setUsername(rs.getString("username"));
				shipper.setPassword(rs.getString("password"));
//				shipper.setPhoneNumber(rs.getString("phoneNumber"));
//				shipper.setAddress(rs.getString("address"));
				shipper.setReg_date(rs.getDate("reg_date"));
				
				return shipper;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
