import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPayment extends Payment{
	
	private String CheckNumber;
	private Scanner scnr;
	
	/**
	 * Simple constructor initializing scanner and setting cost fields
	 * 
	 * @param order Order object containing order details and costs
	 */
	CheckPayment(Order order) {
		super(order);
		
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
}
