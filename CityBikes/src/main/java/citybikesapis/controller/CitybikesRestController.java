package citybikesapis.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import citybikesapis.model.Network;
import citybikesapis.model.Root;
import citybikesapis.service.CitybikesServices;

@Component
@Configurable
@RestController
public class CitybikesRestController {
	
	//@Autowired
	//AutowiringService aw;

	@RequestMapping(value = "/citybikesinfo", method = RequestMethod.GET)
	public Root getCitybikesinfo() throws JsonProcessingException, IOException {
		//System.out.println("Autowiring Value set in CountryController = " + aw.getAutowire());
		CitybikesServices citybikesServices = new CitybikesServices();
		Root root = citybikesServices.getCitybikeNetworks();
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

	  	return root;
	}
}