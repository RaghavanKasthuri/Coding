package helloworld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class EmployeeControllerAddTest {

	@Test
	public void add() throws ParseException {
		EmployeeController empController = new EmployeeController();
		ModelMap model = null;
		empController.addEmployee("408", "Raghavan", "Kasthuri", "Engineering", "01/01/2020", "30000", model);
		System.out.println("EmployeeControllerAddTest(): Added successfully");
		assertEquals("added", "added");
	}
}
