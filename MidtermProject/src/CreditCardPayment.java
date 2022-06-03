
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * basic io method to prompt user input for name on card, card num, cvv, and
	 * expiration date and print order receipt
	 * 
	 * @TimeComplexity "O(1)"
	 */
	public void pay() {

		System.out.println("Please enter your name on the Credit Card: ");
		CardName = scnr.nextLine();

		System.out.println("Please enter your Credit Card Number: ");
		CreditCardNumber = scnr.nextLine();

		String CreditCardNumberRegex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		Pattern pattern = Pattern.compile(CreditCardNumberRegex);

		// Strip all hyphens
		CreditCardNumber = CreditCardNumber.replaceAll("-", "");
		Matcher matcher = pattern.matcher(CreditCardNumber);
		while (!matcher.matches()) {
			System.out.println("Invalid card number please enter again:");
			CreditCardNumber = scnr.nextLine();
			matcher = pattern.matcher(CreditCardNumber);
		}

		System.out.println("Please enter your Credit Card Security Code: ");
		CCV = scnr.nextLine();

		String CcvRegex = "^[0-9]{3,4}$";

		Pattern ccvpattern = Pattern.compile(CcvRegex);

		Matcher ccvmatcher = ccvpattern.matcher(CCV);
		while (!ccvmatcher.matches()) {
			System.out.println("Invalid Security Code please enter again:");
			CCV = scnr.nextLine();
			ccvmatcher = ccvpattern.matcher(CCV);
		}

		System.out.println("Please enter Expiration Date MM/YY: ");
		ExpirationDate = scnr.nextLine();

		String ExpirationDateRegex = "\\b(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})\\b";

		Pattern ExpirationDatepattern = Pattern.compile(ExpirationDateRegex);
		ExpirationDate = ExpirationDate.replaceAll("/", "");
		Matcher ExpirationDatematcher = ExpirationDatepattern.matcher(ExpirationDate);
		while (!ExpirationDatematcher.matches()) {
			System.out.println("Invalid Expiration Date please enter again: ");
			ExpirationDate = scnr.nextLine();
			ExpirationDatematcher = ExpirationDatepattern.matcher(ExpirationDate);

		}

		printReceipt();
	}

	public void printReceipt() {
		super.printReceipt();
		System.out.printf("%12s%31.2f%n", "Credit Tend", total);
		System.out.printf("%7s%36.2f%n%n", "Change", 0.00);
		System.out.printf("%10s%33s%n", "Account #", (CreditCardNumber.substring(CreditCardNumber.length() - 4)));
		System.out.println("--------------------------------------------\n");
		System.out.printf("%n%27s%n", "Thank You! " + CardName);

	}

}
