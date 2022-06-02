import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPayment extends Payment{
	
	private String CheckNumber;
	private Scanner scnr;
	static final String paymentType = "check";
	
	/**
	 * Simple constructor initializing scanner and setting cost fields
	 * 
	 * @param order Order object containing order details and costs
	 */
	CheckPayment(Order order) {
		super(order);
		order.setPaymentType(paymentType);
		scnr = new Scanner(System.in);
	}
	
	
	/**
	 * basic io method to prompt user input for check number and print order receipt
	 * 
	 * @TimeComplexity "O(1)"
	 */
	public void pay() {
		
		System.out.println("Please enter your Check Number");
		CheckNumber = scnr.nextLine();
		
		String CheckNumber = "Check Number";
		Pattern pattern = Pattern.compile("(\\d{4})");

		printReceipt();
		
	}
	
	public void printReceipt() {
		super.printReceipt();
		System.out.printf("%6s%37.2f%n", "Check Amt", total);
		System.out.printf("%7s%36.2f%n", "Change", 0.00);
		System.out.println("--------------------------------------------\n");
		System.out.printf("%n%27s%n", "Thank You!");

	}
}
