package dao;

import java.util.List;

import model.Categories;

public interface CategoriesDao {
	void addCategories(Categories categories);

	void editCategories(Categories categories);

	void deleteCategories(int id);

	List<Categories> getAllCategories();
}
