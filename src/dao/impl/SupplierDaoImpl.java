package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RootDao;
import dao.SupplierDao;
import model.Supplier;

public class SupplierDaoImpl extends RootDao implements SupplierDao {

	@Override
	public void addSupplier(Supplier Supplier){
		String sql = "INSERT INTO suppliers (id, name, phoneNumber, address) VALUES (?,?,?,?) ";
				
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, Supplier.getId());
			preparedStatement.setString(2, Supplier.getName());
			preparedStatement.setString(3, Supplier.getPhoneNumber());
			preparedStatement.setString(4, Supplier.getAddress());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editSupplier(Supplier supplier) {
		String sql = "UPDATE suppliers SET name = ?, phoneNumber = ?, address = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, supplier.getName());
			preparedStatement.setString(2, supplier.getPhoneNumber());
			preparedStatement.setString(3, supplier.getAddress());
			preparedStatement.setString(4, supplier.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteSupplier(String id) {
		String sql = "DELETE FROM suppliers WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> Suppliers = new ArrayList<Supplier>();
		String sql = "SELECT * FROM suppliers";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Supplier Supplier = new Supplier();
				Supplier.setId(rs.getString("id"));
				Supplier.setName(rs.getString("name"));
				Supplier.setPhoneNumber(rs.getString("phoneNumber"));
				Supplier.setAddress(rs.getString("address"));
				Suppliers.add(Supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Suppliers;
	}

	@Override
	public Supplier getSupplierByID(String id) {
		String sql = "SELECT * FROM suppliers WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Supplier Supplier = new Supplier();
				Supplier.setId(rs.getString("id"));
				Supplier.setName(rs.getString("name"));
				Supplier.setPhoneNumber(rs.getString("phoneNumber"));
				Supplier.setAddress(rs.getString("address"));
				return Supplier;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
