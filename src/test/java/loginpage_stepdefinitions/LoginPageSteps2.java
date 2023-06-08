package loginpage_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.aventstack.extentreports.Status;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps2 extends Utility{
	
	public LoginPage lp;
	public HomePage hp;
	ExcelReader reader;
	
	public void objectMethod() throws IOException {
		lp = new LoginPage();
		hp = new HomePage();
		}

	
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String pword) throws IOException, InterruptedException {
	    objectMethod();
	    lp.loginUserName(uname);
	    lp.loginPassword(pword);
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 8 is passed");
	}
	
	@When("User enters username and password from sheetname {string} and rownumber {int}")
	public void user_enters_username_and_password_from_sheetname_and_rownumber(String sheetname, int rownumber) throws IOException, InvalidFormatException {
		objectMethod();
		
		reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetname);
        
        String uname = testData.get(rownumber).get("username");
        String pword = testData.get(rownumber).get("password");
        
        lp.loginUserName(uname);
	    lp.loginPassword(pword);
	    
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 9 is executed");
	}
	
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws IOException, InterruptedException {
		objectMethod();
		lp.loginButton();
		Utility.implicitWait();
	    logger.log(Status.INFO, "Step 10 is executed");

	}
	
	@Then("It shows Home Page")
	public void it_shows_home_page() throws IOException, InterruptedException {
		objectMethod();
		String expectedTitle = "Swag Labs";
		String actualTitle = hp.validateHomePageTitle();

		try {
		assertEquals(actualTitle, expectedTitle);
		logger.log(Status.PASS, "Step 11 is passed");
		System.out.println(actualTitle);
	    assert true;
		}
		catch(AssertionError e) {
			e.printStackTrace();
	    	logger.log(Status.FAIL, "Step11 is failed");
	    	captureScreenshotOnFailure();
	    	assert false;
		}
		System.out.println("Home page is visible");
		Utility.implicitWait();
		
	}
	
	@Then("It shows Login Page")
	public void it_shows_login_page() throws IOException, InterruptedException {
		objectMethod();
		
		String actualtitle = lp.validateLoginPageTitle();
		String expectedtitle = "Swag Labs"; 

		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step12 is passed");
			System.out.println(actualtitle); 
			assert true;
	    }
		catch(AssertionError e){
	    	e.printStackTrace();
	    	logger.log(Status.FAIL, "Step12 is failed");
	    	captureScreenshotOnFailure();
	    	assert false;
	    }
		Utility.implicitWait();
		System.out.println("Login page is visible");
		logger.log(Status.INFO, "Step 12 is executed");
	}
}

