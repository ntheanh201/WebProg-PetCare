package service.impl;

import java.util.List;

import dao.CategoriesDao;
import dao.impl.CategoriesDaoImpl;
import model.Categories;
import service.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService{
	CategoriesDao categorydao = new CategoriesDaoImpl();
	
	@Override
	public void addCategories(Categories categories) {
		categorydao.addCategories(categories);
	}

	@Override
	public void editCategories(Categories categories) {
		categorydao.editCategories(categories);
	}

	@Override
	public void deleteCategories(int id) {
		categorydao.deleteCategories(id);
	}

	@Override
	public List<Categories> getAllCategories() {
		return categorydao.getAllCategories();
	}

}
