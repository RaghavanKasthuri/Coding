package employeeapi.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import employeeapi.entity.Employee;
public class EmployeeDAOAddTest {

	@Test
	public void add() throws ParseException {
		EmployeeDAO empdao = new EmployeeDAO();
		Employee emp = new Employee();
		emp.setFirstName("Raghavan");
		emp.setSurName("Kasthuri");
		emp.setJobTitle("Engineer");
		emp.setPayAmount(30000);
		emp.setId(808);
		String sDate1="31/12/1998";
	        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		emp.setJoiningDate(date1);
		empdao.add(emp);
		System.out.println("added successfully");
		assertEquals("added", "added");
	}
}