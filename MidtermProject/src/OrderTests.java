import org.junit.Assert;
import org.junit.jupiter.api.Test;

class OrderTests {

	@Test
	void testOrderCreation() {
		Catalog cat = new Catalog();
		Order ord = new Order(cat);
		Assert.assertNotNull(ord);
	}
	@Test
	void testOrderAddProduct() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		int[] arr = {1, 0};
		Assert.assertEquals(ord.getOrderQuantities()[0], arr[0]);
	}
	@Test
	void testOrderAddProduct2() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		int[] arr = {1, 0};
		Assert.assertEquals(ord.getOrderQuantities()[1], arr[1]);
	}
	@Test
	void testSubtotalOneItem() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		Assert.assertTrue(ord.getSubtotal() == 1.49);
	}
	@Test
	void testSubtotalTwoItems() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		ord.addProduct(2, 1);
		Assert.assertTrue(ord.getSubtotal() == 8.17);
	}
	@Test
	void testOrderOneTaxable() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		ord.addProduct(2, 1);
		Assert.assertTrue(ord.getRoundedTax() == .40);
	}
	@Test
	void testOrderTwoTaxable() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Stapler", "Office", "Mini Standard Stapler with Staples", 2.40, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		ord.addProduct(2, 1);
		ord.addProduct(3, 1);
		Assert.assertTrue(ord.getRoundedTax() == (.40 + .14));
	}
	@Test
	void testOrderThreeTaxable() {
		Catalog cat = new Catalog();
		cat.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		cat.addProduct(new Product("Stapler", "Office", "Mini Standard Stapler with Staples", 2.40, true));
		cat.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		Order ord = new Order(cat);
		ord.addProduct(1, 1);
		ord.addProduct(2, 2);
		ord.addProduct(3, 1);
		Assert.assertTrue(ord.getRoundedTax() == (.40 + .29));
	}
}