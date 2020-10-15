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
import countryapi.service.CountryJdbcDAO;

@Controller
@RequestMapping("/country")
public class CountryControllerNew {
	
   /**
    * Method invoked when the user wants to land on the country search page.
    * @param model returned to the JSP page to print the required values.
    * @return
    */
   @RequestMapping(value = "/countryhistory", method = RequestMethod.GET)
   public String countryInfo(ModelMap modell) {
	   
	   System.out.println("Inside /country/countryhistory");
	   ModelAndView model = new ModelAndView("countryspec");

	   CountryJdbcDAO dao = new CountryJdbcDAO();
	   dao.read();

	   System.out.println("dao.read() successful");
	   
	   model.addObject("msg", "Country DAO invoked fine");
	   modell.addAttribute("dao", "Country DAO invoked fine");
	   System.out.println("Model and Modell objects set fine");

  	return "countryspec";
   }
}