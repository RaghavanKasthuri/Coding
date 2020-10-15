package countryapi.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
public class CountryControllerTest {

	@Test
	public void hello() {
		CountryController hc = new CountryController();
		ModelMap model = new ModelMap();
		String expected = hc.printHello(model);
		System.out.println(expected);
		assertEquals(expected, "hello");
	}
}

