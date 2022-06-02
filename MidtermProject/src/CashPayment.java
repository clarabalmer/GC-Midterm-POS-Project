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
	static final String paymentType = "cash";

	// Fields
	private double amountTendered; // Amount of cash customer paid with
	private double change; // change to be made

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
		order.setPaymentType(paymentType);
		amountTendered = 0.0;
		change = 0.0;
		scnr = new Scanner(System.in);
	}

	/**
	 * basic io method to prompt user input for cash tendered, calculate change to
	 * be returned, and print order receipt
	 * 
	 * @TimeComplexity "O(n)"
	 */
	public void pay() {
		String in = "";
		
		while (amountTendered == 0.0) {

			System.out.print("Enter the Amount: ");
			in = scnr.nextLine();
			
			try {
				amountTendered = Double.valueOf(in);
			} catch (Exception e) {
				System.out.println("\nCash amount must be in the form of a number");
			}
		}
		
		change = amountTendered - total;

		// Loops until the order balance is met
		while (change < 0) {
			System.out.printf("\n The customer still owes $%.2f", (-1.0 * (float) change));
			System.out.printf("\n\nEnter new amount of cash tendered: ");
			in = scnr.nextLine();
			try {
				amountTendered = Double.valueOf(in);
			} catch (Exception e) {
				System.out.println("\nCash amount must be in the form of a number");
				continue;
			}
			//amountTendered = scnr.nextDouble();
			change += amountTendered;
		}

		double totalChange = change;

		while (totalChange >= dollarValue) {
			if (totalChange >= twentyValue) {
				twentyChange = (int) totalChange / twentyValue;
				totalChange %= twentyValue;
			} else if (totalChange >= tenValue) {
				tenChange = (int) totalChange / tenValue;
				totalChange %= tenValue;
			} else if (totalChange >= fiveValue) {
				fiveChange = (int) totalChange / fiveValue;
				totalChange %= fiveValue;
			} else {
				dollarChange = (int) totalChange / dollarValue;
				totalChange %= dollarValue;
			}
		}

		while (totalChange != 0) {

			if (totalChange < 1) {
				totalChange = (float) totalChange * convertCoins;
			} else if (totalChange >= quarterValue) {
				quarterChange = (int) totalChange / quarterValue;
				totalChange %= quarterValue;

			} else if (totalChange >= dimeValue) {
				dimeChange = (int) totalChange / dimeValue;
				totalChange %= dimeValue;

			} else if (totalChange >= nickelValue) {
				nickelChange = (int) totalChange / nickelValue;
				totalChange %= nickelValue;

			} else {
				pennyChange = (int) totalChange;
				totalChange = 0;
			}
		}
		System.out.printf("\nTotal Change: $%.2f\n", (float) change);
		System.out.println("\nMake the following change");
		System.out.println("-------------------------");
		System.out.println("Bills: $20 = " + twentyChange + ", $10 = " + tenChange + ", $5 = " + fiveChange + ", $1 = "
				+ dollarChange);
		System.out.println("Coins: Quarters = " + quarterChange + ", Dimes = " + dimeChange + ", Nickles = "
				+ nickelChange + ", Pennies = " + pennyChange);

		printReceipt();
	}
	
	public void printReceipt() {
		super.printReceipt();
		System.out.printf("%5s%38.2f%n", "Cash", getAmountTendered());
		System.out.printf("%7s%36.2f%n", "Change", getChange());
		System.out.println("--------------------------------------------\n");
		System.out.printf("%n%27s%n", "Thank You!");

	}
	
	// Getters and setters
	public double getAmountTendered() {
		return amountTendered;
	}

	public void setAmountTendered(double amountTendered) {
		this.amountTendered = amountTendered;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
