package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	
	///constructor
	
	public TestBase() {
	
		try {
	prop= new Properties();
	
	FileInputStream ip= new FileInputStream("C:\\Users\\Ravi Kapoor\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	//FileInputStream connect between config.properties file and java code
	prop.load(ip);
		}
		
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	
	}
	
	public static void intializaion() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
		}
		else if(browserName.contentEquals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\selenium\\selenium-java-3.141.59\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver(); 
		}
		
		        driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				driver.get(prop.getProperty("url"));
				
				
	}
	
}
