import java.util.ArrayList;

public class Catalog {
	
	private ArrayList<Product> products;
	private int size;
	public final double TAX_RATE = 0.06;
	
	public Catalog() {
		products = new ArrayList<>();
		size = products.size();
	}
	
	public void printCatalog() {
		for(int i = 0; i < products.size(); i++) {
			System.out.printf("\n%3d", i + 1);
			System.out.printf("%-33s", " | " + products.get(i).getName());
			System.out.printf("$%6.2f", products.get(i).getPrice());
		}
		System.out.println();
	}
	
	public boolean addProduct(Product p) {
		if(products.indexOf(p) == -1) {
			products.add(p);
			size++;
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public int getSize() {
		return size;
	}
}
