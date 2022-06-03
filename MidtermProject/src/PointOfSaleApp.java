import java.util.Scanner;

/**
 * PointOfSaleApp is the main class for the POS system. 
 * Cashier on shift enters their name, facilitates customer transactions, or adds specials to the menu.
 * Closing the register prints totals by type for balancing at end of shift.
 */
public class PointOfSaleApp {

	private static Scanner scnr;
	private static Catalog generalStore;
	

	public static void main(String[] args) {
		generalStore = new Catalog();
		scnr = new Scanner(System.in);
		fillGeneralStore();
		
		System.out.print("Good morning! Please enter your Cashier ID: ");
		Report report = new Report(scnr.nextLine());
		cashierMenu(report);
		
	}
	public static void cashierMenu(Report report) {
		boolean repeatCashierMenu = true;
		while (repeatCashierMenu) {
			System.out.println("Select one:");
			System.out.println("1  New Transaction");
			System.out.println("2  Add Special sale item");
			System.out.println("3  Close Register");
			String in = scnr.nextLine();
			if (!in.equals("1") && !in.equals("2") && !in.equals("3")) {
				System.out.println("Invalid input, try again.");
			} else if (in.equals("1")) {
				transaction(report);
			} else if (in.equals("2")) {
				addSpecial();
			} else {
				report.printReport();
				repeatCashierMenu = false;
			}
		}
		
	}
	/**
	 * addSpecials method prompts cashier to add extra products to the catalog
	 * before opening the register.
	 */
	public static void addSpecial() {
		Product special = new Product();
		System.out.print("Enter product name: ");
		special.setName(scnr.nextLine());
		System.out.print("Enter product category: ");
		special.setCategory(scnr.nextLine());
		System.out.print("Enter product description: ");
		special.setDescription(scnr.nextLine());
		double price = 0;
		while (price == 0) {
			System.out.print("Enter product price (#.## format): ");
			String priceString = scnr.nextLine();
			try {
				price = Double.parseDouble(priceString);
				special.setPrice(price);
			} catch (NumberFormatException e) {
				System.out.println("Wrong format! Try again.");
			}
		}
		System.out.print("Is the product taxable?");
		special.setTaxable(yesOrNo(scnr));
		generalStore.addProduct(special);
	}
	
	/**
	 * transaction method collects user input for items
	 * to add to the order, collects payment type and calls appropriate methods for completing
	 * the order and printing the receipt 
	 */
	public static void transaction(Report report) {
		generalStore.printCatalog();
		
		Order userOrder = new Order(generalStore);
		
		boolean repeatOrder = true;
		while (repeatOrder) {
			int menuChoice = getItemNum(generalStore);
			if (menuChoice != 0) {
				userOrder.addProduct(menuChoice, getQuantity());
			} else {
				repeatOrder = false;
			}
		}
		
		userOrder.displaySummary();
		
		Payment payment = getPaymentType(userOrder);
		payment.pay();
		
		if (userOrder.getPaymentType().equals("cash")) {
			report.addToCash(userOrder.getRoundedTax() + userOrder.getSubtotal());
		} else if (userOrder.getPaymentType().equals("check")) {
			report.addToCheck(userOrder.getRoundedTax() + userOrder.getSubtotal());
		} else if (userOrder.getPaymentType().equals("credit")) {
			report.addToCredit(userOrder.getRoundedTax() + userOrder.getSubtotal());
		}
	}
	
	/**
	 * Scanner method to translate a 'y' or 'n' input into an equivalent boolean
	 * 
	 * @param scnr Scanner object used for console input
	 * @return true if user enters 'y', false otherwise
	 */
	public static boolean yesOrNo(Scanner scnr) {
		System.out.print(" y/n ");
		String response = scnr.nextLine();
		if (response.equalsIgnoreCase("y")) {
			return true;
		} else if (response.equalsIgnoreCase("n")) {
			return false;
		} else {
			System.out.print("I didn't understand. Please try again. ");
			return yesOrNo(scnr);
		}
		
	}
	
	/**
	 * io method dedicated to collecting user input for desired item to be ordered
	 * 
	 * @param catalog the catalog of items ordering from
	 * @return the item number entered by user
	 */
	private static int getItemNum(Catalog catalog) {
		String userNumString = "";
		int itemNum = -1;
		
		do{
			System.out.print("Enter item number: ");
			
			try{
				userNumString = scnr.nextLine();
				itemNum = Integer.parseInt(userNumString);
			}catch(Exception e) {
				scnr.next();
				System.out.println("Error: Invalid item selection.\n");
			}
			
			if(itemNum < 0 || itemNum > catalog.getSize()) {
				System.out.println("Item number must exist on item list");
			}
			
		} while (itemNum < 0 || itemNum > catalog.getSize());
		
		return itemNum;
	}
	
	/**
	 * io method for collecting desired item quantity from user
	 * 
	 * @return the quantity entered by user
	 */
	private static int getQuantity() {
		String userQuantString = "";
		int quantity = -1;
		
		do{
			System.out.print("Enter desired quantity: ");
			try{
				userQuantString = scnr.nextLine();
				quantity = Integer.parseInt(userQuantString);
			}catch(Exception e) {
				scnr.next();
				System.out.println("Error: Invalid quantity entered.\n");
			}
			
			if(quantity < 0) {
				System.out.println("Quantity must be positive");
			}
			
		} while (quantity < 0);
		return quantity;
	}
	
	/**
	 * io method for prompting and collecting the user's payment method for paying
	 * 
	 * @return a new payment object of the type to be used by the user
	 */
	private static Payment getPaymentType(Order order) {
		Payment paymentType;
		String in = "";
		
		do {
			
			try {
				System.out.print("Please enter payment method (cash, card, or check): ");
				in = scnr.nextLine().toLowerCase();
			} catch(Exception e) {}
			
			if(!in.equals("cash") && !in.equals("card") && !in.equals("check")) {
				System.out.println("We only accept cash, card, and check\n");
			}
			
		} while (!in.equals("cash") && !in.equals("card") && !in.equals("check"));
		
		
		if(in.equals("cash")) {
			paymentType = new CashPayment(order);
		}
		else if(in.equals("card")) {
			paymentType = new CreditCardPayment(order);
		}
		else {
			paymentType = new CheckPayment(order);
		}
		
		return paymentType;
		
	}
	
	//public Product(String name, String category, String description, double price, boolean taxable)
	private static void fillGeneralStore() {
		generalStore.addProduct(new Product("Notebook", "Office", "College Ruled 1-Subject, 70 sheets", 1.19, true));
		generalStore.addProduct(new Product("Stapler", "Office", "Mini Standard Stapler with Staples", 2.40, true));
		generalStore.addProduct(new Product("Bic Pens", "Office", "Medium Point Gel Pens, 2 ct", 6.68, true));
		generalStore.addProduct(new Product("Honeycrisp Apple", "Produce", "Organic apple from Minnesota", 1.49, false));
		generalStore.addProduct(new Product("Campari Tomatoes", "Produce", "Medium tomatoes on the vine, 16 oz", 3.99, false));
		generalStore.addProduct(new Product("Doritos", "Pantry", "Nacho Cheese falvor, 9.25 oz", 4.99, false));
		generalStore.addProduct(new Product("Pringles", "Pantry", "Sour Cream and Onion Potato Crisps", 1.89, false));
		generalStore.addProduct(new Product("Rice", "Pantry", "Enriched Long Grain White Rice, 32 oz", 1.49, false));
		generalStore.addProduct(new Product("Black Beans", "Pantry", "15.25 oz canned black beans", 0.79, false));
		generalStore.addProduct(new Product("Eggs", "Dairy & Eggs", "12 ct Grade A Large Eggs", 3.69, false));
		generalStore.addProduct(new Product("Oat Milk", "Dairy & Eggs", "64 fl oz Extra Creamy", 2.77, false));
		generalStore.addProduct(new Product("Butter", "Dairy & Eggs", "Kerrygold Pure Irish Butter, 4 oz unsalted", 4.49, false));
		generalStore.addProduct(new Product("Ramen", "Pantry", "Sapporo Ramen Ichi Tonkotsu Noodles 5 Pack", 5.49, false));
		generalStore.addProduct(new Product("Roast Chicken", "Deli", "Fresh Roasted Rotisserie Chicken", 8.99, true));
		generalStore.addProduct(new Product("Sushi", "Deli", "California Roll combo", 8.99, false));
	}
	

}
