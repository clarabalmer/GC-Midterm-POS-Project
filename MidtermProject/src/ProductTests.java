import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ProductTests {

	@Test
	void testPruductCreation() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertNotNull(prod);
	}
	@Test
	void testProductName() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertEquals(prod.getName(), "Tomatoes");
	}
	@Test
	void testProductCategory() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertEquals(prod.getCategory(), "Produce");
	}
	@Test
	void testProductDescription() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertEquals(prod.getDescription(), "Round and red");
	}
	@Test
	void testProductPrice() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertTrue(prod.getPrice() == 3.50);
	}
	@Test
	void testProductTaxable() {
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		Assert.assertTrue(prod.getTaxable() == true);
	}
	//public Product(String name, String category, String description, double price, boolean taxable)
	//(constructor for reference, delete later)
}
