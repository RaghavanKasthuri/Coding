package helloworld.main.java;

//import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import static org.junit.Assert.*;

import helloworld.main.java.ArithmeticOperations;

public class CucumberJava {
	int totalBill;
	int noOfColleagues;
	int actuals;
	int expected;
	@Given("We are out for lunch with colleagues")
	public void we_are_out_for_lunch_with_colleagues() {
		System.out.println("Inside GIVEN");
		//write code here
		totalBill = 200;
		noOfColleagues = 5;
	}

	@When("We received the bill amount")
	public void we_received_the_bill_amount() {
		ArithmeticOperations arithmetic = new ArithmeticOperations();
		int actuals = arithmetic.divide(totalBill, noOfColleagues);
		int expected = 40;
		System.out.println("Expected = "+ expected);
		System.out.println("Actuals = "+ actuals);
	}

	@Then("The bill amount was shared equally")
	public void the_bill_amount_was_shared_equally() {
	    assertEquals(actuals, expected);
	    System.out.println("Assertion pass");
	}
}