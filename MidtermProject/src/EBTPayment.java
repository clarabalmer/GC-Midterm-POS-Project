import java.io.Console;
import java.util.Scanner;

public class EBTPayment extends Payment {
	
	static final String paymentType = "EBT";
	private Scanner scnr;
	private String EBTCardNumber;
	private String PIN;
	
	EBTPayment(Order order) {
		super(order);
		order.setPaymentType(paymentType);
		scnr = new Scanner(System.in);
	}
	
	public void pay() {
		if (order.getTotalTax() != 0) {
			validTransaction = false;
			System.out.println("Non-grocery items are not eligible.");
			System.out.println("Please repeat transaction without taxable items.");
		} else {
			System.out.print("Please enter the card number: ");
			EBTCardNumber = scnr.nextLine();
			System.out.print("Please enter your PIN: ");
			PIN = scnr.nextLine();
			
			printReceipt();
		}
	}
	
	public void printReceipt() {
		super.printReceipt();
		//more stuff here
		
	}
}
