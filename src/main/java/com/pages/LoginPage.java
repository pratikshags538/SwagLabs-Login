package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class LoginPage extends Utility{
	
	@FindBy(xpath = "//*[@placeholder='Username']")
	WebElement Username;
	
	@FindBy(xpath = "//*[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id = 'login-button']")
	WebElement login;
	
	@FindBy(xpath = "//*[@class = 'login_logo']")
	WebElement textElement;
	
	@FindBy(xpath = "//*[@class = 'login_credentials_wrap']")
	WebElement div;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return validatePageTitle();
	}
	
	public String textCapture() {
        return textElement.getText();
    }  
	
	public void enableUserName() throws InterruptedException {
		if (Username.isDisplayed() == true && Username.isEnabled() == true) {
			System.out.println("Username TextBox is enabled");
			} 
		else {
			System.out.println("Username Textbox is not enabled");
			}
	}
	
	public void enablePassword() throws InterruptedException {
		if (Password.isDisplayed() == true && Password.isEnabled() == true) {
			System.out.println("Password TextBox is enabled");
			} 
		else {
			System.out.println("Password Textbox is not enabled");
			}
	}
	
	public void loginHover() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(login).perform();
		System.out.println("Login button is enabled");
	}
	
	
	public void displayFooter() {
		if(div.isDisplayed() == true) {
			System.out.println("Footer is displayed");
		}
	}
	public void loginUserName(String un) {
		Username.sendKeys(un);
	}
	
	public void loginPassword(String pw) {
		Password.sendKeys(pw);
	}
	
	public HomePage loginButton() throws IOException{
		login.click();
		return new HomePage();
	}
}
