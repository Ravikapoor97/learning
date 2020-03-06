package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory-Object Repogitary
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbutton;
	
	@FindBy(linkText="https://api.cogmento.com/register")
	WebElement SingUP;
	
	//initializing the page object
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	//Action
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	public HomePage login(String Un,String Pwd) {
		username.sendKeys(Un);
		 password.sendKeys(Pwd);
		 loginbutton.click();
		 
		 return new HomePage();
		
	
	}
	
	

}
