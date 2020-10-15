package citybikesapitest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import static org.junit.Assert.*;

import citybikesapis.model.Network;
import citybikesapis.model.Root;
import citybikesapis.service.CitybikesServices;

public class CitybikesTest {

	int actuals = 0;
    int expected = 0;
    Root root;
    int index = 0;
    String countryName;
    
	@Given("^I want to know the location of citybikes across the world$")
	public void i_want_to_know_the_location_of_citybikes_across_the_world() throws JsonProcessingException, IOException {
	    // Write code here that turns the phrase above into concrete actions
	    CitybikesServices bikes = new CitybikesServices();
	    root = bikes.getCitybikeNetworks();
	}

	@When("^I login to the citybikes application$")
	public void i_login_to_the_citybikes_application() {
	    // Write code here that turns the phrase above into concrete actions
	    expected = root.getNetworks().size();
	    actuals = 645;
	    
		List<Network> networks = root.getNetworks();
	    for (int i=0; i<networks.size(); i++) {
			if (networks.get(i).getLocation().getCity().equalsIgnoreCase("Frankfurt")) {
				index = i;
				System.out.format("%32s %32s %32s", networks.get(i).getName(), networks.get(i).getLocation().getCountry(), networks.get(i).getLocation().getCity());
				System.out.println();
			}
		}
		System.out.println("Index = " + index);
		countryName = networks.get(index).getLocation().getCountry();
		System.out.println("Frankfurt is in the country of " + countryName);
	}

	@Then("^The location of citybikes across the world is displayed to me$")
	public void the_location_of_citybikes_across_the_world_is_displayed_to_me() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(expected, actuals);
	    assertEquals(countryName, "DE");
	    System.out.println("Assertion pass");
	}

}
