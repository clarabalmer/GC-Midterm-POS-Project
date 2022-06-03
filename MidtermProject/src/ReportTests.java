import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReportTests {

	@Test
	void testConstructor() {
		Report report = new Report("testCashierID");
		assertEquals("testCashierID", report.getCashierID());
	}
	
	@Test
	void testAddToCash1() {
		Report report = new Report("test");
		report.addToCash(4.98);
		report.addToCash(12.00);
		report.addToCash(30.99);
		
		assertEquals((4.98 + 12.00 + 30.99), report.getCashTotal());
	}
	
	@Test
	void testAddToCash2() {
		Report report = new Report("test");
		report.addToCash(0.0);
		
		assertEquals(0.0, report.getCashTotal());
	}
	
	@Test
	void testAddToCash3() {
		Report report = new Report("test");
		report.addToCash(-4.40);
		
		assertEquals(-4.4, report.getCashTotal());
	}
	
	@Test
	void testAddToCredit1() {
		Report report = new Report("test");
		report.addToCredit(0.0);
		
		assertEquals(0.0, report.getCreditTotal());
	}
	
	@Test
	void testAddToCredit2() {
		Report report = new Report("test");
		report.addToCredit(4.98);
		report.addToCredit(12.00);
		report.addToCredit(30.99);
		
		assertEquals((4.98 + 12.00 + 30.99), report.getCreditTotal());
	}
	
	@Test
	void testAddToCheck1() {
		Report report = new Report("test");
		report.addToCheck(4.98);
		report.addToCheck(12.00);
		report.addToCheck(30.99);
		
		assertEquals((4.98 + 12.00 + 30.99), report.getCheckTotal());
	}
	
	@Test
	void testAddToCheck2() {
		Report report = new Report("test");
		report.addToCheck(0.0);
		
		assertEquals(0.0, report.getCreditTotal());
	}
	
	@Test 
	void testCashTransactions1() {
		Report report = new Report("test");
		assertEquals(0, report.getCashTransactions());
	}
	
	@Test 
	void testCashTransactions2() {
		Report report = new Report("test");
		report.addToCash(0);
		report.addToCash(0);
		report.addToCash(0);
		report.addToCash(0);

		assertEquals(4, report.getCashTransactions());
	}
	
	@Test 
	void testCreditTransactions1() {
		Report report = new Report("test");
		assertEquals(0, report.getCreditTransactions());
	}
	
	@Test 
	void testCreditTransactions2() {
		Report report = new Report("test");
		report.addToCredit(0);
		report.addToCredit(0);
		report.addToCredit(0);
		report.addToCredit(0);

		assertEquals(4, report.getCreditTransactions());
	}
	
	@Test 
	void testCheckTransactions1() {
		Report report = new Report("test");
		assertEquals(0, report.getCheckTransactions());
	}
	
	@Test 
	void testCheckTransactions2() {
		Report report = new Report("test");
		report.addToCheck(0);
		report.addToCheck(0);
		report.addToCheck(0);
		report.addToCheck(0);

		assertEquals(4, report.getCheckTransactions());
	}
	

}
