package helloworld.main.java;
import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 

@CucumberOptions(
		features= {"Calculator.feature"}, 
		glue="helloworld.main.java"
		)

public class runTest { }