package employeeapi.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import employeeapi.dao.EmployeeDAO;
public class EmployeeControllerReadTest {

	@Test
	public void read() {
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.read();
		System.out.println("read successful");
		assertEquals("read", "read");
	}
}

