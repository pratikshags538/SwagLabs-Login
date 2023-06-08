package com.utility;

import org.openqa.selenium.WebDriver;
public class Config {

	public static WebDriver driver;
	
	public static String projectPath = System.getProperty("user.dir");
	
	public static String chromeDriverPath = projectPath + "\\drivers\\chromedriver.exe";
	public static String geckoDriverPath = projectPath + "\\drivers\\geckodriver.exe";
	
	public static String url = "https://www.saucedemo.com";
	
	public static String screenshotsPath = projectPath + "\\Screenshots\\";
	
	public static String filePath = projectPath + "\\src\\main\\java\\com\\config\\Config.properties";
	
    public static String excelPath = projectPath + "\\src\\main\\java\\com\\testdata\\testdata.xlsx";

	
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
}
