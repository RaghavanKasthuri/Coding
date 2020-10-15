package citybikesapis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.picocontainer.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import citybikesapis.model.Citybikeshome;
import citybikesapis.model.Network;
import citybikesapis.model.Root;
import citybikesapis.controller.CitybikesRestController;

@Controller
@RequestMapping("/citybikes")
public class CitybikesController {
	
   //AutowiringService aw = new AutowiringService();
	
   //@Autowired
   CitybikesRestController restAPI = new CitybikesRestController();

@RequestMapping(value = "/listallcitybikes", method = RequestMethod.GET)
   public String listallcitybikes(ModelMap model) {   
	System.out.println("CitybikesController: /listallcitybikes(modelmap)");
  	return "CitybikesHome";
   }
   
   /**
    * Method invoked when the biker wants to land on the Citybikes Home Page.
    * @return ModelAndView returning a list of all bike networks, country name, city across the world.
    */
   @RequestMapping(value = "/CitybikesHome", method = RequestMethod.GET)
   public ModelAndView CitybikesHome() throws JsonProcessingException, IOException {
	   
	   System.out.println("Citybikes Controller:CitybikesHome()");
	   
	   ModelAndView model = new ModelAndView("CitybikesHome");
	   
	   List<Citybikeshome> list = new ArrayList<Citybikeshome>();
	   Root root = restAPI.getCitybikesinfo();
	   List<Network> networks = root.getNetworks();
	   System.out.format("%32s %32s %32s", "Citybikes Network", "Country", "City");
	   System.out.println();
	   
	for (int i=0; i<networks.size(); i++) {
	   System.out.format("%32s %32s %32s", networks.get(i).getName(), networks.get(i).getLocation().getCountry(), networks.get(i).getLocation().getCity());
	   
	   Citybikeshome citybikes = new Citybikeshome();
	   citybikes.setNetworkName(networks.get(i).getName());
	   citybikes.setCountry(networks.get(i).getLocation().getCountry());
	   citybikes.setCity(networks.get(i).getLocation().getCity());
	   list.add(citybikes);
	   System.out.println();
	}
	
	System.out.println("Citybikeslist size = " + list.size());
	for (int i=0; i<list.size(); i++) {
		System.out.println("Printing from inside Citybikes List");
		System.out.format("%32s %32s %32s", list.get(i).getNetworkName(), list.get(i).getCountry(), list.get(i).getCity());
	}
	model.addObject("list", list);
	   
  	return model;
   }
}