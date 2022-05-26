
public abstract class Payment {

<<<<<<< HEAD
=======
	//Fields:
	//subtotal
	//taxRate
	//taxAmount
	//total
	
	//constructor takes in the subtotal
	
	//methods:
	//override tostring
	
	//getters for all, setter for subtotal

<<<<<<< HEAD
=======
	
>>>>>>> 0c1b82ff2779d6cedd4516dc591e80dfdb0a698b
	
	//private double subtotal;
	//private double taxRate;
	private double taxAmount;
	//private double total;
	
	
	/*
	 * public Payment getOrderPayment () { super(Payment orderPayment); }
	 */
	
	
	public  Payment (double subtotal) {

		this.getSubtotal=Subtotal;

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
>>>>>>> f8c577712a562cf703ce25b12efac03b69020468

<<<<<<< HEAD
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


	}

	public abstract void Pay();
	
	public void PrintReceipt() {
		
	}
		
	
	@Override
	public String toString() {
		return "Payment [taxAmount=" + taxAmount + "]";

	}



	/*
	 * TODO add a method to print receipt TODO add a method that prints out what
	 * type of payments the customer wants and then
	 */


>>>>>>> 0c1b82ff2779d6cedd4516dc591e80dfdb0a698b
}
