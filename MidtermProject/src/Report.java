import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
	//Report class holds register information for one cashier's shift.
	//Holds cashier'sname, grand totals for all cash, credit, and check transactions, as well as
	//total number of each type of transaction.
	
	//fields:
	private String cashierID;
	private double cashTotal;
	private int cashTransactions = 0;
	private double creditTotal;
	private int creditTransactions = 0;
	private double checkTotal;
	private int checkTransactions = 0;
	private double EBTTotal;
	private int EBTTransactions = 0;
	
	//Constructor:
	public Report(String cashierName) {
		setCashierID(cashierName);
	}
	
	//methods:
	public void addToCash(double cash) {
		cashTotal += cash;
		cashTransactions++;
	}
	public void addToCredit(double credit) {
		creditTotal += credit;
		creditTransactions++;
	}
	public void addToCheck(double check) {
		checkTotal += check;
		checkTransactions++;
	}
	public void addToEBT(double EBT) {
		EBTTotal += EBT;
		EBTTransactions++;
	}
	public void printReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.printf("%n%n%30s%n%n%30s%n%n%30s%n%n", "Register Report", "GC General Store", "Cashier: " + cashierID);
		System.out.println("--------------------------------------------\n");
		System.out.printf("%32s%n%n", formatter.format(date));
		System.out.printf("%4s%8s%31s%n", "TXNs", "Type", "TOTAL");
		System.out.println("--------------------------------------------\n");
		
		if (cashTransactions > 0) {
			System.out.printf(" %-7d", cashTransactions); 
			System.out.printf("%-23s", "cash");
			System.out.printf("%12.2f%n", cashTotal);
		}
		if (creditTransactions > 0) {
			System.out.printf(" %-7d", creditTransactions); 
			System.out.printf("%-23s", "credit");
			System.out.printf("%12.2f%n", creditTotal);
		}
		if (checkTransactions > 0) {
			System.out.printf(" %-7d", checkTransactions); 
			System.out.printf("%-23s", "check");
			System.out.printf("%12.2f%n", checkTotal);
		}
		if (EBTTransactions > 0) {
			System.out.printf(" %-7d", EBTTransactions); 
			System.out.printf("%-23s", "EBT");
			System.out.printf("%12.2f%n", EBTTotal);
		}
	}
	
	
	//getters/setters:
	public String getCashierID() {
		return cashierID;
	}
	public void setCashierID(String cashierID) {
		this.cashierID = cashierID;
	}
	public double getCashTotal() {
		return cashTotal;
	}
	public void setCashTotal(double cashTotal) {
		this.cashTotal = cashTotal;
	}
	public int getCashTransactions() {
		return cashTransactions;
	}
	public void setCashTransactions(int cashTransactions) {
		this.cashTransactions = cashTransactions;
	}
	public double getCreditTotal() {
		return creditTotal;
	}
	public void setCreditTotal(double creditTotal) {
		this.creditTotal = creditTotal;
	}
	public int getCreditTransactions() {
		return creditTransactions;
	}
	public void setCreditTransactions(int creditTransactions) {
		this.creditTransactions = creditTransactions;
	}
	public double getCheckTotal() {
		return checkTotal;
	}
	public void setCheckTotal(double checkTotal) {
		this.checkTotal = checkTotal;
	}
	public int getCheckTransactions() {
		return checkTransactions;
	}
	public void setCheckTransactions(int checkTransactions) {
		this.checkTransactions = checkTransactions;
	}
	public double getEBTTotal() {
		return EBTTotal;
	}
	public void setEBTTotal(double EBTTotal) {
		this.EBTTotal = EBTTotal;
	}
	public int getEBTTransactions() {
		return EBTTransactions;
	}
	public void setEBTTransactions(int EBTTransactions) {
		this.EBTTransactions = EBTTransactions;
	}
}
