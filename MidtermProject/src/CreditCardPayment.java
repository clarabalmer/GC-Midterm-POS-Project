import java.util.Scanner;

public class CreditCardPayment extends Payment {
	
	private String CardName; 
	private String ExpirationDate;
	private String CreditCardNumber;
	private String CCV;
	static final String paymentType = "credit";
	
	Scanner scnr; 
	
	/**
	 * Simple constructor initializing scanner and setting cost fields
	 * 
	 * @param order Order object containing order details and costs
	 */
	CreditCardPayment(Order order) {
		super(order);
		order.setPaymentType(paymentType);
		scnr = new Scanner(System.in);
	}
	
	/**
	 * basic io method to prompt user input for name on card, card num, cvv, and expiration date
	 * and print order receipt
	 * 
	 * @TimeComplexity "O(1)"
	 */
	public void pay() {
		
		System.out.println("Please enter your name on the Credit Card");
		CardName = scnr.nextLine();
		
		System.out.println("Please enter your Credit Card Number: \n, ACCEPTED : VISA, MASTERCARD, AMEX");
		
	    //String CreditCardNumber =	"^(?:4[0-9]{12}(?:[0-9]{3})? | 5[1-5][0-9]{14} |	3[47][0-9]{13})$";
		
		CreditCardNumber=scnr.nextLine();
		
		System.out.println("Please enter your Credit Card Security Code: ");
		
		CCV =scnr.nextLine();
		
		
		System.out.println("Please enter Expiration Date YY/MM: ");
		
		ExpirationDate =scnr.nextLine();
		
		printReceipt();
	}
	
	public void printReceipt() {
		super.printReceipt();
		System.out.printf("%12s%31.2f%n", "Credit Tend", total);
		System.out.printf("%7s%36.2f%n%n", "Change", 0.00);
		System.out.printf("%10s%33s%n", "Account #", ("****-****-****-" + (CreditCardNumber.length() - 6)));
		System.out.println("--------------------------------------------\n");
		System.out.printf("%n%27s%n", "Thank You!");

	}

}
