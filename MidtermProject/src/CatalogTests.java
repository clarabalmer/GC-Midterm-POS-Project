import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CatalogTests {

	@Test
	void testCatalogCreation() {
		Catalog cat = new Catalog();
		Assert.assertNotNull(cat);
	}
	@Test
	void testAddProduct() {
		Catalog cat = new Catalog();
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		cat.addProduct(prod);
		Assert.assertTrue(cat.getProducts().contains(prod));
	}
	@Test
	void testAddProductRepeat() {
		Catalog cat = new Catalog();
		Product prod = new Product("Tomatoes", "Produce", "Round and red", 3.50, true);
		cat.addProduct(prod);
		Assert.assertFalse(cat.addProduct(prod));
	}
	@Test
	void testCatalogSize() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Assert.assertEquals(cat.getSize(), 2);
	}
}