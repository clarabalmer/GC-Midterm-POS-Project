
public abstract class Payment {
	//Fields:
	//subtotal
	//taxRate
	//taxAmount
	//total
	
	//constructor takes in the subtotal
	
	//methods:
	//override tostring
	
	//getters for all, setter for subtotal
<<<<<<< Updated upstream
=======
	
	
	//private double subtotal;
	//private double taxRate;
	private double taxAmount;
	//private double total;
	
	
	/*
	 * public Payment getOrderPayment () { super(Payment orderPayment); }
	 */
	
	
	public  Payment (double subtotal) {
		this.getSubtotal=Subtotal;
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
	

	public double gettaxAmount() {
		return taxAmount;
	}
	
	/*
	 * public double gettotal() { return total; }
	 */
	
	public Payment(Order order) {
		subtotal = order.getSubtotal;
		
	}
	
	
	@Override
	public String toString() {
		return "Payment [subtotal=" + subtotal + ", taxRate=" + taxRate + ", taxAmount=" + taxAmount + ", total="
				+ total + "]";
	
	}
	
	TODO add a method to print receipt 
	TODO add a method that prints out what type of payments the customer wants and then 
>>>>>>> Stashed changes
}
