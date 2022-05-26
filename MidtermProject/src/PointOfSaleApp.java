import java.util.Scanner;

public class PointOfSaleApp {
	
	private static Scanner scnr;
	private static Catalog generalStore;
	

	public static void main(String[] args) {
		generalStore = new Catalog();
		fillGeneralStore();
		System.out.println("Welcome to our General Store!");
		System.out.println("Here is the menu: ");
		generalStore.printCatalog();
		

	}
	//public Product(String name, String category, String description, double price, boolean taxable)
	private static void fillGeneralStore() {
		generalStore.addProduct(new Product("Notebook", "Office", "College Ruled 1-Subject, 70 sheets", 1.19, true));
		generalStore.addProduct(new Product("Stapler", "Office", "Mini Standard Stapler with Staples", 2.40, true));
		generalStore.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		generalStore.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		generalStore.addProduct(new Product("Campari Tomatoes", "Produce", "Medium tomatoes on the vine, 16 oz", 3.99, false));
		generalStore.addProduct(new Product("Doritos", "Pantry", "Nacho Cheese falvor, 9.25 oz", 4.99, false));
		generalStore.addProduct(new Product("Pringles", "Pantry", "Sour Cream and Onion Potato Crisps", 1.89, false));
		generalStore.addProduct(new Product("Rice", "Pantry", "Enriched Long Grain White Rice, 32 oz", 1.49, false));
		generalStore.addProduct(new Product("Black Beans", "Pantry", "15.25 oz canned black beans", 0.79, false));
		generalStore.addProduct(new Product("Eggs", "Dairy & Eggs", "12 ct Grade A Large Eggs", 3.69, false));
		generalStore.addProduct(new Product("Oat Milk", "Dairy & Eggs", "64 fl oz Extra Creamy", 2.77, false));
		generalStore.addProduct(new Product("Butter", "Dairy & Eggs", "Kerrygold Pure Irish Butter, 4 oz unsalted", 4.49, false));
		generalStore.addProduct(new Product("Ramen", "Pantry", "Sapporo Ramen Ichi Tonkotsu Noodles 5 Pack", 5.49, false));
		generalStore.addProduct(new Product("Roast Chicken", "Deli", "Fresh Roasted Rotisserie Chicken", 8.99, true));
		generalStore.addProduct(new Product("Sushi", "Deli", "California Roll combo", 8.99, false));
	}
	

}
