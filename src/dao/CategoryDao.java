package dao;

import java.util.List;

import model.Category;

public interface CategoryDao {
	void addCategory(Category category);

	void editCategory(Category category);

	void deleteCategory(int id);

	List<Category> getAllCategories();
}
