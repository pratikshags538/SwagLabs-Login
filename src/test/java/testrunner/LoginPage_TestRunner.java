package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/Login.feature", "src/test/resources/features/LoginDataDriven.feature","src/test/resources/features/LoginExcel.feature"},
		glue = {"loginpage_stepdefinitions", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
		
		)
public class LoginPage_TestRunner extends AbstractTestNGCucumberTests{
  
}


//"src/test/resources/features/Login.feature", "src/test/resources/features/LoginDataDriven.feature"