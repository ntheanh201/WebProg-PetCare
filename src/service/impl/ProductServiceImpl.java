//package service.impl;
//
//import java.util.List;
//
//import dao.ProductDao;
//import dao.impl.ProductDaoImpl;
//import model.Product;
//import service.ProductService;
//
//public class ProductServiceImpl implements ProductService{
//	private ProductDao ProductsDao = new ProductDaoImpl();
//	
//	@Override
//	public void addProduct(Product product) {
//		ProductsDao.addProduct(product);
//	}
//
//	@Override
//	public void editProduct(Product Products) {
//		ProductsDao.editProduct(Products);
//	}
//
//	@Override
//	public void deleteProduct(int id) {
//		ProductsDao.deleteProduct(id);
//	}
//
//	@Override
//	public List<Product> getAll() {
//		return ProductsDao.getAll();
//	}
//
//	@Override
//	public Product getByID(int id) {
//		return ProductsDao.getByID(id);
//	}
//
//	@Override
//	public List<Product> getByName(String tenSP) {
//		return ProductsDao.getByName(tenSP);
//	}
//
//	@Override
//	public void updateImage(Product Products) {
//		ProductsDao.updateImage(Products);
//	}
//
//	@Override
//	public List<Product> getProductByCategory(int id) {
//		return ProductsDao.getProductByCategory(id);
//	}
//
//}
