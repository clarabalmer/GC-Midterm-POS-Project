
public class Order {
	
	//fields:
	private Catalog catalog;
	private int[] orderQuantities;
	private Payment orderPayment; //do we need this here?
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
	 * adds quantity to value at index ID in orderQuantities array
	 * 
	 * @param ID the index of the item in the catalog
	 * @param quantity the quantity of item at index "ID" to be added to order
	 */
	public void addProduct(int ID, int quantity) {
		orderQuantities[ID - 1] += quantity;
	}
	
	
	/**
	 * prints ordered items and quantities, sums subtotal and tax, prints subtotal, totalTax, and total.
	 * unneeded formatted print statements are commented out but saved for future use
	 */
	public void displaySummary() {
		for (int i = 0; i < catalog.getProducts().size(); i++) {
			if (orderQuantities[i] != 0) {
				
				subtotal += (orderQuantities[i] * catalog.getProducts().get(i).getPrice());
				if (catalog.getProducts().get(i).getTaxable()) {
					totalTax += catalog.TAX_RATE * orderQuantities[i] * catalog.getProducts().get(i).getPrice();
				}
			}
		}
	
		System.out.printf("%-36s", "      Total: ");
		System.out.printf("$%6.2f\n", subtotal + totalTax);
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
	
	public Payment getOrderPayment() {
		return orderPayment;
	}
	
	public void setOrderPayment(Payment orderPayment) {
		this.orderPayment = orderPayment;
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
