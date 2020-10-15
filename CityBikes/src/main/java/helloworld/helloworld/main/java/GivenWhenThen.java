package helloworld.main.java;

import static org.junit.Assert.assertEquals;

import java.util.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GivenWhenThen {
	int totalBill;
	int noOfColleagues;
	int actuals;
	int expected;
    ArrayList<Integer> expectedArrayList = new ArrayList<Integer>();
    ArrayList<Integer> actualArrayList = new ArrayList<Integer>();

    /**
     * Scenario 1: Share a lunch bill. Data Table, Parameterizing test data.
     * @param arg1
     */
	@Given("^We are out for lunch with a team of (\\d+)$")
	public void we_are_out_for_lunch_with_a_team_of(int arg1) {
		noOfColleagues = arg1;
		System.out.println("Inside GIVEN noOfColleagues = " + noOfColleagues);
	}
	
	@When("^The bill amount was$")
	public void the_bill_amount_was(DataTable args2) {
		ArithmeticOperations arithmetic = new ArithmeticOperations();
	    try {    
	    for (List<String> Bills : args2.raw()) {
	        int totalBill = Integer.parseInt(Bills.get(0));
	        System.out.println("TotalBill list: "+ totalBill);
	        int actuals = arithmetic.divide(totalBill, noOfColleagues);
	        System.out.println("Expected Bill to share" + actuals);
	        int expected = totalBill/noOfColleagues;
	        assertEquals(expected,actuals);
	        expectedArrayList.add(expected);
	        actualArrayList.add(actuals);
	  	    }
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.out.println("division by zero exception");
	    }
	}

	@Then("The bill was settled by sharing equally")
	public void the_bill_amount_was_equally_shared() {
		assertEquals(expectedArrayList.size(), actualArrayList.size());
		for (int i=0; i==expectedArrayList.size(); i++) {
		assertEquals(expectedArrayList.get(i), actualArrayList.get(i));	
		}
	}
	
	/**
	 * Scenario 2: 
	 */
	
}