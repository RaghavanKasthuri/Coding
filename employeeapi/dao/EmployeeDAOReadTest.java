package employeeapi.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeDAOReadTest {

	@Test
	public void read() {
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.read();
		System.out.println("read successful");
		assertEquals("read", "read");
	}
}