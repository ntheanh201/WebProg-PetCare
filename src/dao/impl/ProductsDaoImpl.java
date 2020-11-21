package dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import dao.RootDao;
import dao.ProductsDao;
import model.Categories;
import model.Products;
import service.CategoriesService;
import service.impl.CategoriesServiceImpl;

public class ProductsDaoImpl extends RootDao implements ProductsDao {

	@Override
	public void addSP(Products Products){
		String sql = "INSERT INTO products (name,code,brief,price,category_id,description,photo) VALUES (?,?,?,?,?,?,?) ";
		
//		CategoriesService categoriesService =  new CategoriesServiceImpl();
		
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, Products.getName());
			preparedStatement.setString(2, Products.getCode());
			preparedStatement.setString(3, Products.getBrief());
			preparedStatement.setDouble(4, Products.getPrice());
			preparedStatement.setInt(5, Products.getCategory_id());
			preparedStatement.setString(6, Products.getDescription());
			
			InputStream inputStream = null; // input stream of the upload file
	        if (Products.getPhoto() != null) {
	        	Part filePart = Products.getPhoto();
	        	inputStream = filePart.getInputStream();
	        }
	        if (inputStream != null) {
	        	preparedStatement.setBlob(7, inputStream);
            }
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editSP(Products Products) {
		String sql = "UPDATE products SET name = ?,maSP = ?,brief = ?,price = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, Products.getName());
			preparedStatement.setString(2, Products.getCode());
			preparedStatement.setString(3, Products.getBrief());
			preparedStatement.setDouble(4, Products.getPrice());
			preparedStatement.setInt(5, Products.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteSP(int id) {
		String sql = "DELETE FROM products WHERE id = ?";
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
	public List<Products> getAll() {
		List<Products> Productss = new ArrayList<Products>();
		String sql = "SELECT * FROM products";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Products Products = new Products();
				Products.setId(rs.getInt("id"));
				Products.setName(rs.getString("name"));
				Products.setCode(rs.getString("code"));
				Products.setBrief(rs.getString("brief"));
				Products.setImage(rs.getString("image"));
				Products.setPrice(rs.getDouble("price"));
				Products.setDescription(rs.getString("description"));	
				Products.setCategory_id(rs.getInt("category_id"));
//				Products.setPhoto(rs.getBlob("photo"));
				Productss.add(Products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Productss;
	}

	@Override
	public Products getByID(int id) {
		String sql = "SELECT * FROM products WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Products Products = new Products();
				Products.setId(rs.getInt("id"));
				Products.setName(rs.getString("name"));
				Products.setCode(rs.getString("code"));
				Products.setBrief(rs.getString("brief"));
				Products.setPrice(rs.getDouble("price"));
				Products.setDescription(rs.getString("description"));
				return Products;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Products> getByName(String name) {
		List<Products> Productss = new ArrayList<Products>();
		String sql = "SELECT * FROM products WHERE name LIKE '%" + name + "%'";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			// preparedStatement.setString(1, '');
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Products Products = new Products();
				Products.setId(rs.getInt("id"));
				Products.setName(rs.getString("name"));
				Products.setCode(rs.getString("code"));
				Products.setBrief(rs.getString("brief"));
				Products.setImage(rs.getString("image"));
				Products.setPrice(rs.getDouble("price"));
				Productss.add(Products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Productss;
	}

	@Override
	public void updateImageSP(Products Products) {
		String sql = "UPDATE products SET image = ? WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, Products.getImage());
			preparedStatement.setInt(2, Products.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Products> getProductByIDCategori(int id) {
		String sql = "SELECT * FROM products WHERE category_id = ?";
		List<Products> Productss = new ArrayList<Products>();
		
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Products Products = new Products();
				Products.setId(rs.getInt("id"));
				Products.setName(rs.getString("name"));
				Products.setCode(rs.getString("code"));
				Products.setPrice(rs.getDouble("price"));
				Products.setImage(rs.getString("image"));
				Products.setCategory_id(rs.getInt("category_id"));
				
				Productss.add(Products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Productss;
	}
	
	

}
