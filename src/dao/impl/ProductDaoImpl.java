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
import dao.ProductDao;
import model.Category;
import model.Product;
import service.CategoriesService;
import service.impl.CategoriesServiceImpl;

public class ProductDaoImpl extends RootDao implements ProductDao {

	@Override
	public void addProduct(Product product){
		String sql = "INSERT INTO products (id, name, description, price, quantity, category_id, supplier_id, image, photo) VALUES (?,?,?,?,?,?,?,?,?) ";
				
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setFloat(4, product.getPrice());
			preparedStatement.setInt(5, product.getQuantity());
			preparedStatement.setString(6, product.getCategory_id());
			preparedStatement.setString(7, product.getSupplier_id());
			
			InputStream image = null;
			if (product.getPhoto() != null) {
	        	Part filePart = product.getImage();
	        	image = filePart.getInputStream();
	        }
	        if (image != null) {
	        	preparedStatement.setBlob(8, image);
            }
	        
			InputStream inputStream = null;
	        if (product.getPhoto() != null) {
	        	Part filePart = product.getPhoto();
	        	inputStream = filePart.getInputStream();
	        }
	        if (inputStream != null) {
	        	preparedStatement.setBlob(9, inputStream);
            }
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editProduct(Product product) {
		String sql = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setFloat(3, product.getPrice());
			preparedStatement.setInt(4, product.getQuantity());
			preparedStatement.setString(5, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct(String id) {
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setDescription(rs.getString("quantity"));
				product.setCategory_id(rs.getString("category_id"));
				product.setSupplier_id(rs.getString("supplier_id"));
				product.setCreated_at(rs.getDate("created_at"));
//				product.setPhoto(rs.getBlob("photo"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public Product getByID(String id) {
		String sql = "SELECT * FROM products WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getFloat("price"));
				product.setCategory_id(rs.getString("description"));
				product.setCategory_id(rs.getString("description"));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getByName(String name) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE name LIKE '%" + name + "%'";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			// preparedStatement.setString(1, '');
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getFloat("price"));
//				product.setImage(rs.getString("image"));
				product.setCategory_id(rs.getString("category_id"));
				product.setSupplier_id(rs.getString("supplier_id"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void updateImage(Product product) {
		String sql = "UPDATE products SET image = ? WHERE id = ?";

		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
//			preparedStatement.setBlob(1, product.getImage());
//			preparedStatement.setString(2, product.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getProductByCategory(String id) {
		String sql = "SELECT * FROM products WHERE category_id = ?";
		List<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement preparedStatement = getJDBCconnection().prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setCode(rs.getString("code"));
				product.setPrice(rs.getDouble("price"));
				product.setImage(rs.getString("image"));
				product.setCategory_id(rs.getString("category_id"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Productss;
	}
	
	

}
