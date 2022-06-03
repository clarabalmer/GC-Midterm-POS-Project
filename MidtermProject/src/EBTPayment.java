import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			
			String EBTNumberRegex = "\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";
			
			Pattern EBTpat = Pattern.compile(EBTNumberRegex);
			
			Matcher EBTmatch = EBTpat.matcher(EBTCardNumber);
			while (!EBTmatch.matches()) {
				System.out.println("Invalid card number, please try again: ");
				EBTCardNumber = scnr.nextLine();
				EBTmatch = EBTpat.matcher(EBTCardNumber);
			}
			
			System.out.print("Please enter your PIN: ");
			PIN = scnr.nextLine();
			
			String PINRegex = "\\d\\d\\d\\d";
			Pattern PINpat = Pattern.compile(PINRegex);
			Matcher PINmatch = PINpat.matcher(PIN);
			while (!PINmatch.matches()) {
				System.out.println("Invalid PIN, please try again: ");
				PIN = scnr.nextLine();
				PINmatch = PINpat.matcher(PIN);
			}
			
			printReceipt();
		}
	}
	
	public void printReceipt() {
		super.printReceipt();
		System.out.printf("%4s%39.2f%n", "EBT", total);
		System.out.printf("%10s%31s%n", "Account #", "************" + (EBTCardNumber.substring(EBTCardNumber.length() - 4)));
		System.out.println("--------------------------------------------\n");
		System.out.printf("%n%27s%n", "Thank You!");
	}
}
