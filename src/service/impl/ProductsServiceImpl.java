package service.impl;

import java.util.List;

import dao.ProductsDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductsService;

public class ProductsServiceImpl implements ProductsService{
	private ProductsDao ProductsDao = new ProductDaoImpl();
	
	@Override
	public void addSP(Product Products) {
		ProductsDao.addSP(Products);
	}

	@Override
	public void editSP(Product Products) {
		ProductsDao.editSP(Products);
	}

	@Override
	public void deleteSP(int id) {
		ProductsDao.deleteSP(id);
	}

	@Override
	public List<Product> getAll() {
		return ProductsDao.getAll();
	}

	@Override
	public Product getByID(int id) {
		return ProductsDao.getByID(id);
	}

	@Override
	public List<Product> getByName(String tenSP) {
		return ProductsDao.getByName(tenSP);
	}

	@Override
	public void updateImageSP(Product Products) {
		ProductsDao.updateImageSP(Products);
	}

	@Override
	public List<Product> getProductByIDCategori(int id) {
		return ProductsDao.getProductByIDCategori(id);
	}

}
