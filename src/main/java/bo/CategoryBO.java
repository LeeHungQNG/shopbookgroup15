package bo;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class CategoryBO {
	CategoryDAO dao = new CategoryDAO();

	public List<Category> getListCategory() {
		return dao.getListCategory();
	}

	public boolean addCategory(Category ca) {
		return dao.addCategory(ca);
	}
	public Category getCategoryByID(long id) {
		return dao.getCategoryByID(id);
	}
	public boolean deleteCategory(long id) {
		return dao.deleteCategory(id);
	}
	

	
}
