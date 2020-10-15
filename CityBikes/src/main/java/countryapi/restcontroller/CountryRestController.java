package countryapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import countryapi.model.CountryList;
import countryapi.service.CountryService;

@Component
@Configurable
@RestController
public class CountryRestController {
	
	//@Autowired
	//AutowiringService aw;

	@RequestMapping(value = "/countryinfo", method = RequestMethod.GET)
	public CountryList getCountryInfo(String countryCode) {
		//System.out.println("Autowiring Value set in CountryController = " + aw.getAutowire());
		CountryService countryService = new CountryService();
		CountryList employee = countryService.getCountryInfo(countryCode);
	  	return employee;
	}
}