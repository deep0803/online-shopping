package net.deep.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.deep.shoppingbackend.dao.CategoryDAO;
import net.deep.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.deep.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

	}

	@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		assertEquals("Successfully fetched a category from the table!", "Laptop", category.getName());
	}

	@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(1);
		category.setName("Computer");
		assertEquals("Successfully updated a category in the table!", true, categoryDAO.update(category));

	}

	@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(1);
		category.setName("Computer");
		assertEquals("Successfully deleted a category in the table!", true, categoryDAO.delete(category));

	}

	@Test
	public void testListCategory() {

		assertEquals("Successfully fetched the list of categories in the table!", 1, categoryDAO.list().size());

	}
*/
	@Test
	public void testCRUDCategory() {

		//Test case for adding data into the table
			category = new Category();
	
			category.setName("Laptop");
			category.setDescription("This is some description for laptop!");
			category.setImageURL("CAT_105.png");
	
			assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
			
			category = new Category();
	
			category.setName("Television");
			category.setDescription("This is some description for Television!");
			category.setImageURL("CAT_106.png");
	
			assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
			
			category = new Category();
	
			category.setName("Mobile");
			category.setDescription("This is some description for Mobile!");
			category.setImageURL("CAT_107.png");
	
			assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
			
			category = new Category();
	
			category.setName("Camera");
			category.setDescription("This is some description for Camera!");
			category.setImageURL("CAT_108.png");
	
			assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		//Test case for fetching and updating the record into the table
			category=categoryDAO.get(2);
			category.setName("TV");
			assertEquals("Successfully updated a category in the table!", true, categoryDAO.update(category));
			
		//Test case for deleting the category from the table
			
			assertEquals("Successfully updated a category in the table!", true, categoryDAO.delete(category));
		
		//Test case for getting the list of categories
			assertEquals("Successfully fetched the list of categories in the table!", 3, categoryDAO.list().size());
			
	}
}
