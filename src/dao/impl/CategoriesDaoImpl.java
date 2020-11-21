package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoriesDao;
import dao.RootDao;
import model.Categories;

public class CategoriesDaoImpl extends RootDao implements CategoriesDao{

	@Override
	public void addCategories(Categories categories) {
		String sql = "INSERT INTO categories (name, cate_id) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, categories.getName());
			preparedStatement.setInt(2, categories.getCate_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editCategories(Categories categories) {
		String sql = "UPDATE categiries SET name = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, categories.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategories(int id) {
		String sql = "DELETE FROM categories WHERE id = ?";

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
	public List<Categories> getAllCategories() {
		List<Categories> categories = new ArrayList<Categories>();
		
		String sql = "SELECT * FROM categories";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Categories categories2 = new Categories();
				categories2.setId(rs.getInt("id"));
				categories2.setName(rs.getString("name"));
				categories2.setCate_id(rs.getInt("cate_id"));
				
				categories.add(categories2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

}
