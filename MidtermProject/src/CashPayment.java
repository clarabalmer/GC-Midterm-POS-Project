import java.util.Scanner;

public class CashPayment extends Payment {
	//fields:
	//amount tendered
	//change

	//constructor takes in the subtotal and cashtendered
	//
	//method: tell customer what their change is
	
	//getters and setters: setAmountTendered, getChange
	
	
	// Fields 
	
	double amountTendered; //Amount of cash customer paid with
	double purchaseAmount; //Total cost of purchase
	double change = 0; // change to be made
	
	
	
	//Declare constant values
	final int twentyValue = 20;
	final int tenValue = 10;
	final int fiveValue = 5;
	final int dollarValue = 1;
	final int quarterValue = 25;
	final int dimeValue = 10;
	final int nickelValue = 5;
	final int convertCoins = 100; //converts coin values to int
	
	  //Create scanner object
	   Scanner keyboard = new Scanner(System.in);
	   
	   //Get purchase amount from user
	   System.out.println("Enter the amount of cash tendered:");
	   purchaseAmount = keyboard.nextDouble();

	//Constructors:
	
	public CashPayment (int subtotal, int amountTendered) {
		super(subtotal);
		this.amountTendered=amountTendered;
	
	}
	//Methods 
	
	
	public void giveChange () {
		
		
	}
	
	
}
