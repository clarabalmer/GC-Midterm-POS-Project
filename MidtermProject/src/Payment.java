
public abstract class Payment {


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


}
