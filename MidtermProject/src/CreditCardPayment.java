import java.util.Scanner;

public class CreditCardPayment extends Payment {
	//fields:
	//creditcardnumber
	//expiration date YYMM
	//CVV 
	//(all strings, use regex to validate)
	
	//constructor takes in the subtotal, three CC fields
	

	public String creditcardnumber;
	public String experationdate;
	public String CVV;
	

	String CardName; 
	String ExpirationDate;
	String CreditCardNumber;
	String CCV;
	
	Scanner scnr; 
	
	CreditCardPayment(Order order) {
		super(order);
		
		scnr = new Scanner(System.in);
	}
	
	public void pay() {
		
		System.out.println("Please enter your name on the Credit Card");
		CardName = scnr.nextLine();
		
		System.out.println("Please enter your Credit Card Number: \n, ACCEDPTED : VISA, MASTERCARD, AMEX");
		
	//String CreditCardNumber =	"^(?:4[0-9]{12}(?:[0-9]{3})? | 5[1-5][0-9]{14} |	3[47][0-9]{13})$";
		
		CreditCardNumber=scnr.nextLine();
		
		System.out.println("Please enter your Credit Card Security Code: ");
		
		CCV =scnr.nextLine();
		
		
		System.out.println("Please enter Expiration Date YY/MM: ");
		
		ExpirationDate =scnr.nextLine();
		
		printReceipt();
	}

}
