package helloworld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;

import java.util.List;
public class HelloControllerTest {

	@Test
	public void hello() {
		CountryController hc = new CountryController();
		ModelMap model = new ModelMap();
		String expected = hc.printHello(model);
		System.out.println(expected);
		assertEquals(expected, "hello");
	}
}
