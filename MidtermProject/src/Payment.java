import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Payment {

	private double taxAmount;
	private double subtotal;
	private double total;
	private Order order;

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
		System.out.printf("%40s%n%35s%n%n%n%n", "Receipt Of Sale", "GC General Store");
		System.out.println("----------------------------------------------------\n");
		System.out.printf("%25s%n%n", formatter.format(date));
		System.out.printf("%4s%8s%30s%n", "QTY", "ITEM", "AMT");
		System.out.println("----------------------------------------------------\n");
		
		for(int i = 0; i < order.getOrderQuantities().length; i++) {
			
			if(order.getOrderQuantities()[i] > 0) {
				
				int curQuantity = order.getOrderQuantities()[i];
				String curItem = order.getCatalog().getProducts().get(i).getName();
				double curAmt = order.getCatalog().getProducts().get(i).getPrice() * curQuantity;
				
				System.out.printf(" %-7d", curQuantity); 
				System.out.printf(" %-25s", curItem);
				System.out.printf(" %7f", curAmt);

			}
		}
		
		System.out.println("----------------------------------------------------\n");
		System.out.printf(" %-28s%8.2f", "Subtotal", subtotal);
		System.out.printf(" %-37s%8.2f", "Tax", taxAmount);
		System.out.printf(" %-35s%8.2f", "Total", total);
		System.out.println("----------------------------------------------------\n");
	}
		
	
	@Override
	public String toString() {
		return "Payment [taxAmount=" + taxAmount + "]";

	}


}
