package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import dao.RootDao;
import model.Order;

public class OrderDaoImpl extends RootDao implements OrderDao {

	@Override
	public void addOrder(Order order){
		String sql = "INSERT INTO orders (id, status, total_price, customer_id, shipper_id) VALUES (?,?,?,?,?) ";
				
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, order.getId());
			preparedStatement.setString(2, order.getStatus());
			preparedStatement.setFloat(3, order.getTotal_price());
			preparedStatement.setString(4, order.getCustomer_id());
			preparedStatement.setString(5, order.getShipper_id());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeOrderStatus(Order Order) {
		String sql = "UPDATE orders SET status = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, Order.getStatus());
			preparedStatement.setString(2, Order.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(String id) {
		String sql = "DELETE FROM orders WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> getAll() {
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT * FROM orders";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				
				order.setId(rs.getString("id"));
				order.setStatus(rs.getString("status"));
				order.setTotal_price(rs.getFloat("total_price"));
				order.setCustomer_id(rs.getString("customer_id"));
				order.setShipper_id(rs.getString("shipper_id"));
				order.setDate(rs.getDate("date"));
				
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}	

}
