import java.util.Scanner;

public class CashPayment extends Payment {
	// Constants
	final int twentyValue = 20;
	final int tenValue = 10;
	final int fiveValue = 5;
	final int dollarValue = 1;
	final int quarterValue = 25;
	final int dimeValue = 10;
	final int nickelValue = 5;
	final int convertCoins = 100; // converts coin values to int

	// Fields
	double amountTendered; // Amount of cash customer paid with
	double purchaseAmount; // Total cost of purchase
	double change = 0; // change to be made

	// Change amounts initialized to 0 in case none are needed to make change
	int twentyChange = 0;
	int tenChange = 0;
	int fiveChange = 0;
	int dollarChange = 0;
	int quarterChange = 0;
	int nickelChange = 0;
	int dimeChange = 0;
	int pennyChange = 0;

	Scanner scnr;
	
	public void pay() {
		
		System.out.println("Enter the Amount: ");
		amountTendered = scnr.nextDouble();
		change = amountTendered - total;
	
		while(change < 0) {
			System.out.printf("\n The customer still owes $%.2f", (-1.0 * (float) change));
			System.out.printf("\n\nEnter new amount of cash tendered: ");
			amountTendered = scnr.nextDouble();
			change += amountTendered;
		}
	
		float totalchange = (float)change;
	
		while (change >= dollarValue) {
			if (change >= twentyValue) {
				twentyChange = (int) change / twentyValue;
			} else if (change >= tenValue) {
				change %= fiveValue; 
				
			}else { 
				dollarChange = (int)change/dollarValue;
				change %= dollarValue;	
			}
		}
	
		while (change !=0) {
			
			if(change < 1) {
				change = (float)change * convertCoins;
			 }else if(change >= quarterValue){
		         quarterChange = (int)change / quarterValue;
		         change %= quarterValue;
		      
		         }else if(change >= dimeValue){
		         dimeChange = (int)change / dimeValue;
		         change %= dimeValue;
		      
		         }else if(change >= nickelValue){
		         nickelChange = (int)change / nickelValue;
		         change %= nickelValue;
		      
		         }else{
		         pennyChange = (int)change;
		         change = 0;
			}
		}
		  System.out.printf("\nTotal Change: $%.2f\n", (float)totalchange);
		   System.out.println("\nMake the following change");
		   System.out.println("-------------------------");
		   System.out.println("Bills: $20 = " + twentyChange + ", $10 = " + tenChange +
		   ", $5 = " + fiveChange + ", $1 = " + dollarChange);
		   System.out.println("Coins: Quarters = " + quarterChange + ", Dimes = " +
		   dimeChange + ", Nickles = " + nickelChange + ", Pennies = " +pennyChange);
		   
	}


	//Constructors:

	public CashPayment(Order order) {
		super(order);
		//this.amountTendered = amountTendered;
		scnr = new Scanner(System.in);

	}
//	public void pay () {
//		//Create scanner object
//		scnr = new Scanner(System.in);
//		
//		//Get purchase amount from user
//		System.out.println("Enter the amount of cash tendered:");
//		purchaseAmount = scnr.nextDouble();
//		
//		printReceipt(); 
//		
//	}
	
}
