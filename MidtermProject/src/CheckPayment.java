import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPayment extends Payment{
	//fields:
	//checkNumber (String w/ regex data val)
	
	//constructor takes in the subtotal, check number
	
	
	String CheckNumber;
	
	
	Scanner scnr;
	
	CheckPayment(Order order) {
		super(order);
		
		scnr = new Scanner(System.in);
	}
	
	public void pay() {
		
		System.out.println("Please enter your Check Number");
		CheckNumber = scnr.nextLine();
		
		String CheckNumber = "Check Number";
		Pattern pattern = Pattern.compile("(\\d{4})");

		printReceipt();
		
	}
}
