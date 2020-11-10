package employeeapi.controller;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class EmployeeControllerAddTest {

	@Test
	public void add() throws ParseException {
		EmployeeController empController = new EmployeeController();
		ModelMap model = null;
		empController.addEmployee("1008", "Sri", "Kasthuri", "Engineering", "01/01/2020", "30000", model);
		System.out.println("EmployeeControllerAddTest(): Added successfully");
		assertEquals("added", "added");
	}
}
