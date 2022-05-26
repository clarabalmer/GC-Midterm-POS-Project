
public abstract class Payment {
<<<<<<< Updated upstream
	//Fields:
	//subtotal
	//taxRate
	//taxAmount
	//total
	
	//constructor takes in the subtotal
	
	//methods:
	//override tostring
	
	//getters for all, setter for subtotal
	
	
	//private double subtotal;
	//private double taxRate;
	private double taxAmount;
	//private double total;
	
	
	/*
	 * public Payment getOrderPayment () { super(Payment orderPayment); }
	 */
	
	
	public  Payment (double subtotal) {
		this.subtotal=subtotal;
	}
	
	/*
	 * public double getsubtotal() { return subtotal;
	 */
	//}
	/*
	 * public void setsubtotal(double subtotal) { this.subtotal=subtotal;
	 * 
	 * }
	 * 
	 * public double gettaxRate() { return taxRate; }
	 */
	
=======
	// Fields:
	// subtotal
	// taxRate
	// taxAmount
	// total

	// constructor takes in the subtotal

	// methods:
	// override tostring

	// getters for all, setter for subtotal

	private double taxAmount;
	double subtotal;
	double total;

	public Payment(Order order) {
		taxAmount = order.getTotalTax();
		subtotal = order.getSubTotal();
		total = taxAmount+subtotal;
>>>>>>> Stashed changes

	}

	public abstract void Pay();
	
	public void PrintReceipt() {
		
	}
		
	
	@Override
	public String toString() {
		return "Payment [taxAmount=" + taxAmount + "]";

	}
<<<<<<< Updated upstream
	
	TODO add a method to print receipt 
	TODO add a method that prints out what type of payments the customer wants and then 
=======

	/*
	 * TODO add a method to print receipt TODO add a method that prints out what
	 * type of payments the customer wants and then
	 */

>>>>>>> Stashed changes
}
