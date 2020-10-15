package helloworld.main.java;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

//@RunWith(Cucumber.class)

public class CucumberBDDTestAssertion {
	
    @Given("^the response body tag (.*) contains the following values:$")
    public void the_response_body_tag_contains_the_following_values(String tag) {
    	System.out.println("CucumberBDDTestAssertion - the_response_body_tag_contains_the_following_values");
     
    	// Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the response body attribute (.*) contains the following values:$")
    public void the_response_body_attribute_contains_the_following_values(String attribute) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the response body XPath (.*) contains the following values:$")
    public void the_response_body_XPath_contains_the_following_values(String xpath) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}