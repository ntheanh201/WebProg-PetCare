package service;

import java.util.List;

import model.Categories;

public interface CategoriesService {
	void addCategories(Categories categories);

	void editCategories(Categories categories);

	void deleteCategories(int id);

	List<Categories> getAllCategories();
}
