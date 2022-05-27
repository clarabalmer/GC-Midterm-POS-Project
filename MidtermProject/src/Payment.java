import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Payment {

	protected double taxAmount;
	protected double subtotal;
	protected double total;
	protected Order order;

	public Payment(Order order) {
		this.order = order;
		taxAmount = order.getTotalTax();
		subtotal = order.getSubtotal();
		total = taxAmount+subtotal;


	}

	public abstract void pay();
	
	public void printReceipt() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.printf("%n%n%30s%n%n%30s%n%n", "Receipt Of Sales", "GC General Store");
		System.out.println("--------------------------------------------\n");
		System.out.printf("%32s%n%n", formatter.format(date));
		System.out.printf("%4s%8s%31s%n", "QTY", "ITEM", "AMT");
		System.out.println("--------------------------------------------\n");
		
		for(int i = 0; i < order.getOrderQuantities().length; i++) {
			
			if(order.getOrderQuantities()[i] > 0) {
				
				int curQuantity = order.getOrderQuantities()[i];
				String curItem = order.getCatalog().getProducts().get(i).getName();
				double curAmt = order.getCatalog().getProducts().get(i).getPrice() * curQuantity;
				
				System.out.printf(" %-7d", curQuantity); 
				System.out.printf("%-23s", curItem);
				System.out.printf("%12.2f%n", curAmt);

			}
		}
		
		System.out.println("--------------------------------------------\n");
		System.out.printf("%9s%34.2f%n", "Subtotal", subtotal);
		System.out.printf("%4s%39.2f%n", "Tax", taxAmount);
		System.out.printf("%6s%37.2f%n", "Total", total);
		System.out.println("--------------------------------------------\n");
	}
		
	
	@Override
	public String toString() {
		return "Payment [taxAmount=" + taxAmount + "]";

	}


}
