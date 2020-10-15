package helloworld.main.java;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.math.*;

import helloworld.main.java.ArithmeticOperations;

class JunitTestAssertion {

	int a = 4;
	int b = 1;
	
	ArithmeticOperations arithmetic = new ArithmeticOperations();

	@Test
	public void testAdd() {
		int actuals = arithmetic.add(a, b);
		int expected = 5;
		assertEquals(expected, actuals, "Add JUNIT successful");
		assertTrue(actuals == expected, "Add JUNIT successful");
	}
	
	@Test
	public void testSubtract() {
		int actuals = arithmetic.subtract(a, b);
		int expected = 3;
		assertTrue(actuals == expected, "Subtract JUNIT successful");
	}
	
	@Test
	public void testMultiply() {
		int actuals = arithmetic.multiply(a, b);
		int expected = 4;
		assertTrue(actuals == expected, "Multiply JUNIT successful");
	}
	
	@Test
	public void testDivide() {
		int actuals = arithmetic.divide(a, b);
		int expected = 4;
		assertTrue(actuals == expected, "Division JUNIT successful");
	}
	
	@Test
	public void testDivideFail() {
		int actuals = arithmetic.divide(a, b);
		int expected = 3;
		assertTrue(actuals != expected, "Division JUNIT successful");
	}
	
}
