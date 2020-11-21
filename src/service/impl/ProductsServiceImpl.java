package service.impl;

import java.util.List;

import dao.ProductsDao;
import dao.impl.ProductsDaoImpl;
import model.Products;
import service.ProductsService;

public class ProductsServiceImpl implements ProductsService{
	private ProductsDao ProductsDao = new ProductsDaoImpl();
	
	@Override
	public void addSP(Products Products) {
		ProductsDao.addSP(Products);
	}

	@Override
	public void editSP(Products Products) {
		ProductsDao.editSP(Products);
	}

	@Override
	public void deleteSP(int id) {
		ProductsDao.deleteSP(id);
	}

	@Override
	public List<Products> getAll() {
		return ProductsDao.getAll();
	}

	@Override
	public Products getByID(int id) {
		return ProductsDao.getByID(id);
	}

	@Override
	public List<Products> getByName(String tenSP) {
		return ProductsDao.getByName(tenSP);
	}

	@Override
	public void updateImageSP(Products Products) {
		ProductsDao.updateImageSP(Products);
	}

	@Override
	public List<Products> getProductByIDCategori(int id) {
		return ProductsDao.getProductByIDCategori(id);
	}

}
