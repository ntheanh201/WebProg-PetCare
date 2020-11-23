package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;
import service.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService{
	CategoryDao categorydao = new CategoryDaoImpl();
	
	@Override
	public void addCategories(Category categories) {
		categorydao.addCategory(categories);
	}

	@Override
	public void editCategories(Category categories) {
		categorydao.editCategory(categories);
	}

	@Override
	public void deleteCategories(int id) {
		categorydao.deleteCategory(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return categorydao.getAllCategories();
	}

}
