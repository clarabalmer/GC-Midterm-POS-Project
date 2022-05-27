
public class CheckPayment extends Payment{
	//fields:
	//checkNumber (String w/ regex data val)
	
	//constructor takes in the subtotal, check number
	
	
	String FirstName;
	String LastName;
	String CheckNumber;
	
	
	CheckPayment(double Value, String FirstName, String LastName, String CheckNumber) {
		super(Value);
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.CheckNumber = CheckNumber;
	}
}
