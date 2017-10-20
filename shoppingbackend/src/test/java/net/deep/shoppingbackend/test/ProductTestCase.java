package net.deep.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.deep.shoppingbackend.dao.ProductDAO;
import net.deep.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.deep.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testCRUDProduct() {

		// create operation
		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something Went Wrong while inserting a new product", true, productDAO.add(product));

		// read and update operation
		product = productDAO.get(2);
		product.setName("MOTO X PLAY");
		assertEquals("Something Went Wrong while updating product", true, productDAO.update(product));

		// delete operation
		assertEquals("Something Went Wrong while deleting the existing product", true, productDAO.delete(product));

		// list operation
		assertEquals("Something went wrong while fetching the list of products!", 6, productDAO.list().size());

	}

	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!", 5,
				productDAO.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!", 3,
				productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!", 2,
				productDAO.listActiveProductsByCategory(1).size());
	}

	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!", 3,
				productDAO.getLatestActiveProducts(3).size());
	}
}
