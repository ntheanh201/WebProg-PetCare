package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import dao.RootDao;
import model.Category;

public class CategoryDaoImpl extends RootDao implements CategoryDao{

	@Override
	public void addCategory(Category categories) {
		String sql = "INSERT INTO categories (id, name, description) VALUES (?, ?, ?)";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, categories.getId());
			preparedStatement.setString(2, categories.getName());
			preparedStatement.setString(3, categories.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editCategory(Category categories) {
		String sql = "UPDATE categiries SET name = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, categories.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(String id) {
		String sql = "DELETE FROM categories WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		
		String sql = "SELECT * FROM categories";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setId(rs.getString("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

}
