package helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import java.util.Date;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

   @RequestMapping(value = "/employeeinfo", method = RequestMethod.GET)
   public String employeeInfo(ModelMap model) {   
	System.out.println("EmployeeController: /employeeinfo");
  	return "addemployee";
   }

   /**
    * Method to add new employee details.
    * @param model returned to the JSP page to print the required values.
    * @return
    * @throws ParseException 
    */
   @RequestMapping(value = "/addemployee", method = RequestMethod.GET)
   public String addEmployee(@RequestParam("employeeid") String employeeid, @RequestParam("firstname") String firstname, @RequestParam("surname") String surname, @RequestParam("jobtitle") String jobtitle, @RequestParam("joiningdate") String joiningdate, @RequestParam("pay") String pay, ModelMap model) throws ParseException {
	  
       System.out.println("Inside EmployeeController addEmployee() successfully");
       EmployeeDAO dao = new EmployeeDAO();
       Employee emp = new Employee();
       emp.setFirstName(firstname);
       emp.setSurName(surname);
       emp.setJobTitle(jobtitle);
       emp.setPayAmount(new Integer(Integer.parseInt(pay)));
       int i = Integer.parseInt(employeeid);
       System.out.println("EmployeeController Add() Employee Id = i = "+i);
       Integer in = new Integer(i);
       emp.setId(in);
       Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(joiningdate);
       emp.setJoiningDate(date1);

       dao.add(emp);   
       model.addAttribute("msg", "Added a new employee successfully");
       System.out.println("Country Controller /employee/addemployee");
	
    return "addemployee";

   }
}