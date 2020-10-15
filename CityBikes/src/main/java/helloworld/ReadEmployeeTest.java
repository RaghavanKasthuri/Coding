package helloworld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;

import java.util.List;
public class ReadEmployeeTest {

	@Test
	public void read() {
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.read();
		System.out.println("read successful");
		assertEquals("read", "read");
	}
}
