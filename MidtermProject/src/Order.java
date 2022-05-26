
public class Order {
	//
	//print receipt (receipt contains: subtotal, tax, total, all the items, payment info (last four cc, check, cash amount and change))
	
	//fields:
	private Catalog catalog;
	private int[] orderQuantities;
	private Payment orderPayment; //do we need this here?
	private double subtotal;
	private double totalTax;
	private double total;
	
	
	//constructor:
	public Order(Catalog catalog) {
		setCatalog(catalog);
		orderQuantities = new int[catalog.getProducts().size()];
	}
	
	//methods:
	//adds quantity to value at index ID in orderQuantities array
	public void addProduct(int ID, int quantity) {
		orderQuantities[ID - 1] += quantity;
	}
	//prints ordered items and quantities, sums subtotal and tax, prints subtotal, totalTax, and total.
	public void displaySummary() {
		for (int i = 0; i < catalog.getProducts().size(); i++) {
			if (orderQuantities[i] != 0) {
				System.out.printf("%-6s%-1s%-1s%-1s%s%.2f%n", catalog.getProducts().get(i).getName(), 
						" x ", orderQuantities[i], ":  ", "$", (orderQuantities[i] * catalog.getProducts().get(i).getPrice()));
				subtotal += (orderQuantities[i] * catalog.getProducts().get(i).getPrice());
				if (catalog.getProducts().get(i).getTaxable()) {
					totalTax += catalog.TAX_RATE * orderQuantities[i] * catalog.getProducts().get(i).getPrice();
				}
			}
		}
		System.out.println("========================");
		System.out.printf("%-11s%s%5.2f%n", "Subtotal: ", "$", subtotal);
		System.out.printf("%-11s%s%5.2f%n", "Tax: ", "$", totalTax);
		System.out.printf("%-11s%s%5.2f%n", "Total: ", "$", (subtotal + totalTax));
	}
	
	//getters/setters:
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
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
