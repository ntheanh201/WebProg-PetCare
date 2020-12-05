package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.OrderDetailDao;
import dao.RootDao;
import model.OrderDetail;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDaoImpl extends RootDao implements OrderDetailDao {

	@Override
	public void addOrderDetail(OrderDetail od) {
		String sql = "INSERT INTO order_detail (id, order_id, product_id, quantity) VALUES (?,?,?,?) ";
		
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, od.getId());
			preparedStatement.setString(2, od.getOrder_id());
			preparedStatement.setString(3, od.getProduct_id());
			preparedStatement.setInt(4, od.getQuantity());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editOrderDetail(OrderDetail od) {
		String sql = "UPDATE order_detail SET product_id = ?, quantity = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, od.getProduct_id());
			preparedStatement.setInt(1, od.getQuantity());
			preparedStatement.setString(3, od.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderDetail(String id) {
		String sql = "DELETE FROM order_detail WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderDetail> getAllByOrder(String orderId) {
		String sql = "SELECT * FROM order_detail WHERE order_id = ?";
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, orderId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				OrderDetail od = new OrderDetail();
				od.setId(rs.getString("id"));
				od.setOrder_id(rs.getString("order_id"));
				od.setProduct_id(rs.getString("product_id"));
				od.setQuantity(rs.getInt("quantity"));
				
				orderDetails.add(od);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderDetails;
	}

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
