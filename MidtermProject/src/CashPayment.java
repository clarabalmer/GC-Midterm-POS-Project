import java.util.Scanner;

public class CashPayment extends Payment {
	// Constants
	static final int twentyValue = 20;
	static final int tenValue = 10;
	static final int fiveValue = 5;
	static final int dollarValue = 1;
	static final int quarterValue = 25;
	static final int dimeValue = 10;
	static final int nickelValue = 5;
	static final int convertCoins = 100; // converts coin values to int

	// Fields
	private double amountTendered; // Amount of cash customer paid with
	private double purchaseAmount; // Total cost of purchase
	private double change = 0; // change to be made

	// Change amounts initialized to 0 in case none are needed to make change
	private int twentyChange = 0;
	private int tenChange = 0;
	private int fiveChange = 0;
	private int dollarChange = 0;
	private int quarterChange = 0;
	private int nickelChange = 0;
	private int dimeChange = 0;
	private int pennyChange = 0;

	private Scanner scnr;

	/**
	 * CashPayment's constructor only differs from super by instantiating the scanner
	 * 
	 * @param order object of type Order which contains order and price details
	 */
	public CashPayment(Order order) {
		super(order);
		scnr = new Scanner(System.in);
	}

	/**
	 * basic io method to prompt user input for cash tendered, calculate change to
	 * be returned, and print order receipt
	 * 
	 * @TimeComplexity "O(n)"
	 */
	public void pay() {

		System.out.println("Enter the Amount: ");
		amountTendered = scnr.nextDouble();
		change = amountTendered - total;

		while (change < 0) {
			System.out.printf("\n The customer still owes $%.2f", (-1.0 * (float) change));
			System.out.printf("\n\nEnter new amount of cash tendered: ");
			amountTendered = scnr.nextDouble();
			change += amountTendered;
		}

		float totalchange = (float) change;

		while (change >= dollarValue) {
			if (change >= twentyValue) {
				twentyChange = (int) change / twentyValue;
			} else if (change >= tenValue) {
				change %= fiveValue;

			} else {
				dollarChange = (int) change / dollarValue;
				change %= dollarValue;
			}
		}

		while (change != 0) {

			if (change < 1) {
				change = (float) change * convertCoins;
			} else if (change >= quarterValue) {
				quarterChange = (int) change / quarterValue;
				change %= quarterValue;

			} else if (change >= dimeValue) {
				dimeChange = (int) change / dimeValue;
				change %= dimeValue;

			} else if (change >= nickelValue) {
				nickelChange = (int) change / nickelValue;
				change %= nickelValue;

			} else {
				pennyChange = (int) change;
				change = 0;
			}
		}
		System.out.printf("\nTotal Change: $%.2f\n", (float) totalchange);
		System.out.println("\nMake the following change");
		System.out.println("-------------------------");
		System.out.println("Bills: $20 = " + twentyChange + ", $10 = " + tenChange + ", $5 = " + fiveChange + ", $1 = "
				+ dollarChange);
		System.out.println("Coins: Quarters = " + quarterChange + ", Dimes = " + dimeChange + ", Nickles = "
				+ nickelChange + ", Pennies = " + pennyChange);

		printReceipt();
	}

}
