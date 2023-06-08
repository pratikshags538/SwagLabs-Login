package loginpage_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import com.aventstack.extentreports.Status;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.Utility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class LoginPageSteps extends Utility{
	
	public LoginPage lp;
	public HomePage hp;

	public void objectMethod() throws IOException {
		lp = new LoginPage();
		hp = new HomePage();
		}
	
	@Given("Chrome is opened and Swaglabs is opened")
	public void chrome_is_opened_and_swaglabs_is_opened() throws IOException {
		objectMethod();
		lp.validateLoginPageTitle();
	}
	
	@Then("It navigates on to login page")
	public void it_navigates_on_to_login_page() throws IOException, InterruptedException {
		objectMethod();
		
		logger = report.createTest("test01");
		logger.log(Status.INFO,"Validating Login Page title");
		
		String actualtitle = lp.validateLoginPageTitle();
		String expectedtitle = "Swag Labs"; 

		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step1 is passed");
			System.out.println(actualtitle); 
			Utility.implicitWait();
			assert true;
	    }
		catch(AssertionError e){
	    	e.printStackTrace();
	    	logger.log(Status.FAIL, "Step1 is failed");
	    	captureScreenshotOnFailure();
	    	assert false;
	    }
	}
	
	@Then("It shows elements on login page")
	public void it_shows_elements_on_login_page() throws IOException, InterruptedException {
		objectMethod();
		lp.displayFooter();
		String actualText = lp.textCapture();
        String expectedText = "Swag Labs";
        
		logger.log(Status.INFO,"Validating Logo text");
        
        try {
        	assertEquals(expectedText, actualText);
        	logger.log(Status.PASS,"Step 2 is passed");
        	System.out.println("Actual Text is " + actualText);
			Utility.implicitWait();
        	assert true;
	    }
        catch(AssertionError e){
        	e.printStackTrace();
	    	logger.log(Status.FAIL, "Step2 is failed");
	    	captureScreenshotOnFailure();
	    	assert false;
        }
	}
	
	@When("User clicks on Username and Password")
	public void user_clicks_on_Username_and_Password() throws IOException, InterruptedException {
		objectMethod();
		lp.enableUserName();
		lp.enablePassword();
		lp.loginHover();
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 3 is executed");
	}
	
	@Then("Username and Password fields are enabled on login page")
	public void username_and_password_fields_are_enabled_on_login_page() throws IOException, InterruptedException {
	    objectMethod();
		Utility.implicitWait();
	    System.out.println("Username and password fields are enabled");
	    logger.log(Status.INFO, "Step 4 is executed");
	}
	
	@When("User enters 'standard_user' and 'secret_sauce'")
	public void user_enters_standard_user_and_secret_sauce(String uname, String pword) throws IOException, InterruptedException {
		objectMethod();
		lp.loginUserName(uname);
		lp.loginPassword(pword);
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 5 is executed");

	}
	
	@And("User clicks on login button")
	public void user_clicks_on_login_button() throws IOException, InterruptedException {
		objectMethod();
		lp.loginButton();
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 6 is executed");
	}
	
	@Then("It shows home page")
	public void it_shows_home_page() throws IOException, InterruptedException {
		objectMethod();
	    logger.log(Status.INFO, "Validating Home Page title");
		
		String expectedTitle = "Swag Labs";
		String actualTitle = hp.validateHomePageTitle();

		try {
		assertEquals(actualTitle, expectedTitle);
		logger.log(Status.PASS, "Step 7 is passed");
		System.out.println(actualTitle);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    assert true;
		}
		catch(AssertionError e) {
			e.printStackTrace();
	    	logger.log(Status.FAIL, "Step 7 is failed");
	    	captureScreenshotOnFailure();
	    	assert false;
		}
		Utility.implicitWait();
		System.out.println("Home page is visible");
	}
		
	
}
