import java.util.ArrayList;

public class Catalog {
	
	private ArrayList<Product> products;
	private int size;
	public final double TAX_RATE = 0.06;
	
	/**
	 * Basic constructor which sets the arraylist of product objects
	 * as well as the size of the catalog
	 */
	public Catalog() {
		products = new ArrayList<>();
		size = products.size();
	}
	
	/**
	 * Printing method which prints out a formatted menu of catalog products
	 * 
	 * @TimeComplexity "O(n)"
	 */
	public void printCatalog() {
		System.out.print("0   | Finish Order");
		for(int i = 0; i < products.size(); i++) {
			System.out.printf("\n%-3s", i + 1);
			System.out.printf("%-33s", " | " + products.get(i).getName());
			System.out.printf("$%6.2f", products.get(i).getPrice());
		}
		System.out.println();
	}
	
	/**
	 * Adds a Product object type to the products ArrayList field
	 * 
	 * @param p Product to be added to class ArrayList field
	 * @return true if the item is successfully added, false if item already exits
	 * @TimeComplexity "O(n)"
	 */
	public boolean addProduct(Product p) {
		if(products.indexOf(p) == -1) {
			products.add(p);
			size++;
			return true;
		}
		
		return false;
	}
	
	//getters and setters:
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public int getSize() {
		return size;
	}
}
