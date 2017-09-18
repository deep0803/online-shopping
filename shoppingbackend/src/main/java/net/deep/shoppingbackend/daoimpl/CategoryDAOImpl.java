package net.deep.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.deep.shoppingbackend.dao.CategoryDAO;
import net.deep.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// adding first category
		Category category = new Category();
		category.setId(1);
		category.setName("TEST CAT");
		category.setDescription("TEST DESC");
		category.setImageURL("TEST_URL");
		categories.add(category);

		// adding second category

		category.setId(2);
		category.setName("TEST CAT2");
		category.setDescription("TEST DESC2");
		category.setImageURL("TEST_URL2");
		categories.add(category);

		// adding third category

		category.setId(3);
		category.setName("TEST CAT3");
		category.setDescription("TEST DESC3");
		category.setImageURL("TEST_URL3");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

}
