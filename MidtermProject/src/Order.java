
public class Order {
	
	//fields:
	private Catalog catalog;
	private int[] orderQuantities;
	private double subtotal;
	private double totalTax;
	
	
	/**
	 * Constructor which initializes the Product Catalog and item quantities array
	 * 
	 * @param catalog Catalog object which contains the Products available for the order
	 */
	public Order(Catalog catalog) {
		setCatalog(catalog);
		orderQuantities = new int[catalog.getProducts().size()];
	}
	
	
	/**
	 * adds quantity to value at index (ID - 1) in orderQuantities array
	 * adds price*quantity to subtotal
	 * adds tax to totalTax
	 * 
	 * @param ID the index of the item in the catalog
	 * @param quantity the quantity of item at index "ID" to be added to order
	 */
	public void addProduct(int ID, int quantity) {
		orderQuantities[ID - 1] += quantity;
		subtotal += quantity * (catalog.getProducts().get(ID - 1).getPrice());
		if (catalog.getProducts().get(ID - 1).getTaxable()) {
			totalTax += catalog.TAX_RATE * quantity * (catalog.getProducts().get(ID - 1).getPrice());
		}
	}
	
	
	/**
	 * prints grand total (rounded totalTax included)
	 */
	public void displaySummary() {	
		System.out.printf("%-36s", "      Total: ");
		System.out.printf("$%6.2f\n", subtotal + getRoundedTax());
	}
	
	//getters and setters:
	public Catalog getCatalog() {
		return catalog;
	}
	
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	public int[] getOrderQuantities() {
		return orderQuantities;
	}
	
	public void setOrderQuantities(int[] orderQuantities) {
		this.orderQuantities = orderQuantities;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double getTotalTax() {
		return totalTax;
	}
	
	public double getRoundedTax() {
		return Math.round(getTotalTax() * 100.0) / 100.0;
	}
	
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	
}
