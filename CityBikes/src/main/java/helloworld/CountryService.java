package helloworld;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class CountryService {
	
	@RequestMapping(value = "/countryinfo", method = RequestMethod.GET)
	public CountryList getCountryInfo(String countryCode) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://www.groupkt.com/country/get/iso2code/{code}";
		System.out.println("********CountryRESTController*********");
		
		Map<String, String> vars = new HashMap<>();
		vars.put("code", countryCode);
	  		
		//System.out.println((restTemplate.getForObject(url, String.class)).toString());
		CountryList country = restTemplate.getForObject(url, CountryList.class, vars);
	  	System.out.println("CountryRESTController: Country Name = "+ country.getRestResponse().getResult().getName());
	    //model.addAttribute("message", "Country Information is Australia!");**/
		
	  	return country;
	}
}