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

public class CitybikesFrankfurtTest {
	
	int actuals = 0;
    int expected = 0;
    Root root;
    int index = 0;
    String countryName;
    String latitude;
    String longitude;
    
@Given("^I'm a Biker$")
public void i_m_a_Biker() throws JsonProcessingException, IOException {
    // Write code here that turns the phrase above into concrete actions
	CitybikesServices bikes = new CitybikesServices();
    root = bikes.getCitybikeNetworks();
}

@When("^I login into the Citybikes application to verify that the city Frankfurt is in Germany$")
public void i_login_into_the_Citybikes_application_to_verify_that_the_city_Frankfurt_is_in_Germany() {
    // Write code here that turns the phrase above into concrete actions
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
	//latitude = networks.get(index).getLocation().getLatitude();
	//longitude = networks.get(index).getLocation().getLongitude();
	
	latitude = Double.toString(networks.get(index).getLocation().getLatitude());
	longitude = Double.toString(networks.get(index).getLocation().getLongitude());
	
	System.out.println("Frankfurt is in the country of " + countryName);
}

@Then("^I'm displayed that the city of Frankfurt is in Germany alongside the corresponding latitude and longitude$")
public void i_m_displayed_that_the_city_of_Frankfurt_is_in_Germany_alongside_the_corresponding_latitude_and_longitude() {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(countryName, "DE");
    System.out.println("Assertion pass");
    assertEquals(latitude, "50.1072");
    assertEquals(longitude, "8.66375");
    System.out.println (latitude + " " + longitude);
}
}