package countryapi.controller;

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

import countryapi.model.CountryList;
import countryapi.restcontroller.CountryRestController;

@Controller
@RequestMapping("/hello")
public class CountryController {
	
	//AutowiringService aw = new AutowiringService();
	
   @Autowired
   CountryRestController restAPI;

   @RequestMapping(value = "/print", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }

   /**
    * Method invoked when the user wants to land on the country search page.
    * @param model returned to the JSP page to print the required values.
    * @return
    */
   @RequestMapping(value = "/countryinfo", method = RequestMethod.GET)
   public String countryInfo(ModelMap model) {
	   //CountryRestController restAPI = new CountryRestController();
	   System.out.println("Country Controller:CountryInfo() @Autowire");
	   CountryList country = restAPI.getCountryInfo("AU");
	   //aw.setAutowire("Autowire Set in CountryController");
	   System.out.println("Country Controller /HelloWorld/hello");
	   model.addAttribute("countryName", country.getRestResponse().getResult().getName());
	   model.addAttribute("alpha2", country.getRestResponse().getResult().getAlpha2Code());
	   model.addAttribute("alpha3", country.getRestResponse().getResult().getAlpha3Code());

  	return "hello";
   }
   
   /**
    * Method invoked once the user has landed on the country search page and enters the country code.
    * @param code Country code to search for a specific country's details.
    * @param modell
    * @return
    */
   @RequestMapping(value = "/countrydetails", method = RequestMethod.GET)
   public ModelAndView countryDetails(@RequestParam("code") String code, ModelMap modell) {
	   System.out.println("/countrydetails: code = "+ code);
	   ModelAndView model = new ModelAndView("hello");
	   //CountryRestController restAPI = new CountryRestController();
	   System.out.println("Country Controller:CountryDetails() @Autowired");
	   CountryList country = restAPI.getCountryInfo(code.toUpperCase());
	   model.addObject("msg", "Details submitted: code = " + code.toUpperCase());
	   modell.addAttribute("countryName", country.getRestResponse().getResult().getName());
	   modell.addAttribute("alpha2", country.getRestResponse().getResult().getAlpha2Code());
	   modell.addAttribute("alpha3", country.getRestResponse().getResult().getAlpha3Code());

  	return model;
   }
}