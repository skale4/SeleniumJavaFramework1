package com.test.framework.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;

public class LoginPage {
	
	 DataReader loadData =new DataReader();;
	 public String xmlLocatorsPath = Constants.xmlLocatorsPath + "Locators.xml";
	 public WebDriver driver;
	 public String TC_ID;	
	
	 public String SignIn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "signin");
	 public String Email = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "emailLogin");
	 public String Password = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "passwordLogin");
	 public String SignInLogin = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "signInLogin");
	  
public LoginPage(WebDriver d){
	this.driver = d;
		}

public void LoginPageMethod() throws InterruptedException {
	
	 driver.findElement(By.xpath(SignIn)).click(); //Click Sign in button
	 driver.findElement(By.xpath(Email)).sendKeys(DataReader.readExcel("UserData", 3, "EmailRegister"));
	 driver.findElement(By.xpath(Password)).sendKeys(DataReader.readExcel("UserData", 3, "Password"));
     driver.findElement(By.xpath(SignInLogin)).click(); // click sign in button on login screen
     System.out.println("User is logged in to screen");
     
	 String CurrentTitleAfterLogin = driver.getTitle();
	 String expectedTitleAfterLogin = "My account - My Store";
	 Assert.assertEquals(expectedTitleAfterLogin,CurrentTitleAfterLogin);
	 System.out.println("Login is successful");
	    }

}
