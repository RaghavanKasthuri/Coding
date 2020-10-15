package citybikesapis.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import citybikesapis.model.Network;
import citybikesapis.model.Root;

@Service
@Component
public class CitybikesServices{
	
	@RequestMapping(value = "/citybikesinfo", method = RequestMethod.GET)
	public Root getCitybikeNetworks() throws JsonProcessingException, IOException {
		String countryName;
		int index = 0;
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://api.citybik.es/v2/networks";
		System.out.println("URL = " + url);

		String json = restTemplate.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
	    //mapper.configure(DeserializationConfig.this.

		//JSON from file to Object
		//Root root = mapper.readValue(new File("c:\\root.json"), Root.class);

		Root root = mapper.readValue(json, Root.class);
		
		List<Network> networks = root.getNetworks();
		System.out.format("%32s %32s %32s", "Citybikes Network", "Country", "City");
		System.out.println();

		for (int i=0; i<networks.size(); i++) {
			//if (networks.get(i).getLocation().getCity().equalsIgnoreCase("Frankfurt")) {
				//index = i;
				System.out.format("%32s %32s %32s", networks.get(i).getName(), networks.get(i).getLocation().getCountry(), networks.get(i).getLocation().getCity());
				System.out.println();
			//}
		}
		
		for (int i=0; i<networks.size(); i++) {
			if (networks.get(i).getLocation().getCity().equalsIgnoreCase("Frankfurt")) {
				index = i;
				System.out.format("%32s %32s %32s", networks.get(i).getName(), networks.get(i).getLocation().getCountry(), networks.get(i).getLocation().getCity());
				System.out.println();
			}
		}
		System.out.println("Index = " + index);
		countryName = networks.get(index).getLocation().getCountry();
		System.out.println("Lattitude = " + networks.get(index).getLocation().getLatitude());
		System.out.println("Longitude = " + networks.get(index).getLocation().getLongitude());
		
		System.out.println("Objectmapper root.getNetworks().get(0).getName() = " + root.getNetworks().get(0).getName());
		System.out.println("Network getForObject. root.getNetwork().getCity() = " + root.getNetworks().get(0).getLocation().getCity());
		System.out.println("Network getForObject. root.getNetwork().getCountry() = " + root.getNetworks().get(0).getLocation().getCountry());

		System.out.println("CityBikesServices: Results obtained");
			  	
		return root;
	}
}