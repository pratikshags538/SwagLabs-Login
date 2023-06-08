package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility extends Config{
	
	 //Extent Report Code(Below 2 lines)
    //getReportInstance() method
    public static ExtentReports report = ExtentReporterManager.getReportInstance();
    public static ExtentTest logger;
	
	static ConfigReader configReader = new ConfigReader();
	static Properties prop = configReader.init_prop();
	
	public static WebDriver launchingBrowser() {
		
		String browser = prop.getProperty("Browser");
		
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
			break;
			
		case "HTMLUNIT":
			driver = new HtmlUnitDriver();
			break;

		
	default:
		System.out.println("Browser is not supported");
		}
		return driver;
	}
	
	
	public static void browserMaximize() {
		driver.manage().window().maximize();
	}


	public static void pageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		
	}

	public static void launchingApp() {
		driver.get(prop.getProperty("url"));
	}

	public static void closingBrowser() {
		driver.quit();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

    public static String getDate() {
        Date date = new Date();
        return date.toString().replaceAll(":", "-").replaceAll(" ", "_");
        }


        public void captureScreenshotOnFailure() throws IOException {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File binaryFile = ts.getScreenshotAs(OutputType.FILE);

            String customizedFilePath = screenshotsPath + getDate() + ".png";

            File imageFile = new File(customizedFilePath); 

            FileUtils.copyFile(binaryFile, imageFile);

            //Extent Report Method
            logger.addScreenCaptureFromPath(customizedFilePath);

        }
	}
