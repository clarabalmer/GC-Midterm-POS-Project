
public class PointOfSaleApp {
	
	
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * io method dedicated to collecting user input for desired item to be ordered
	 * 
	 * @param catalog the catalog of items ordering from
	 * @return the item number entered by user
	 */
	private static int getItemNum(Catalog catalog) {
		int itemNum = -1;
		
		do{
			System.out.print("Enter item number: ");
			try{
				itemNum = scnr.nextInt();
			}catch(Exception e) {
				System.out.println("Error: Invalid item selection.\n");
			}
			
			if(itemNum < 1 || itemNum > catalog.getSize()) {
				System.out.println("Item number must exist on item list");
			}
			
		} while (itemNum < 1 || itemNum > catalog.getSize());
		
		return itemNum;
	}
	
	/**
	 * io method for collecting desired item quantity from user
	 * 
	 * @return the quantity entered by user
	 */
	private static int getQuantity() {
		int quantity = -1;
		
		do{
			System.out.print("Enter desired quantity: ");
			try{
				quantity = scnr.nextInt();
			}catch(Exception e) {
				System.out.println("Error: Invalid quantity entered.\n");
			}
			
			if(quantity < 1) {
				System.out.println("Quantity must be a number greater than 0");
			}
			
		} while (quantity < 1);
		
		return quantity;
	}
	
	/**
	 * io method for prompting and collecting the user's payment method for paying
	 * 
	 * @return a new payment object of the type to be used by the user
	 */
	private static Payment getPaymentType() {
		Payment paymentType;
		String in = "";
		
		do {
			System.out.print("");
		}
		
		
		return paymentType;
		
	}

}
