package helloworld.main.java;

import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 

@CucumberOptions(
		features="/Users/Raghavan/Desktop/SOAP UI Tutorials/JBossFuse/HelloWorld/",
		tags= {"@BillCalculator.feature, @Calculator.feature"},
		glue="helloworld.main.java"
		)

public class runCalculatorTest { }
