package citybikesapitest;

import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 

@CucumberOptions(
		//features= {"Frankfurt.feature"}, 
		//glue="citybikesapitest"
		//)

		features="/Users/Raghavan/Desktop/SOAP UI Tutorials/JBossFuse/HelloWorld/",
		//tags= {"@Frankfurt.feature, @citybikes.feature"},
		glue="citybikesapitest"
		)

public class runTest { }
