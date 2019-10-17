package com.test.framework.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;

public class CreateAnAccountPage {
	
	 DataReader loadData =new DataReader();;
	 public String xmlLocatorsPath = Constants.xmlLocatorsPath + "Locators.xml";
	 public WebDriver driver;
	 public String TC_ID;	
     // Below are the locators from the locators.xml file	  
	  public String SignIn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "signin");
	  public String EmailRegister = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "emailRegister");
	  public String CreateAccount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "createAccount");
	  public String Title = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "title");
	  public String FirstName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "firstName");
	  public String LastName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "lastName");
	  public String Email = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "email");
	  public String Password = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "password");
	  public String FirstName1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "firstName1");
	  public String LastName1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "lastName1");
	  public String CompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "company");
	  public String Address = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "address");
	  public String Address2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "address2");
	  public String City = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "city");
	  public String PostalCode = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "postalCode");
	  public String AdditionalInfo = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "additionalInfo");
	  public String HomePhone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "homePhone");
	  public String MobilePhone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "mobilePhone");
	  public String AlisAddress = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "alisAddress");
	  public String Register = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "register");
	 
	  
public CreateAnAccountPage(WebDriver d){
	this.driver = d;
		}

public void CreateAnAccountMethod() throws InterruptedException {
	
	   String Currenttitle = driver.getTitle();
	   String expectedTitle = "My Store";
	   Assert.assertEquals(expectedTitle,Currenttitle);
	   System.out.println("Expected automation practice page is opened");
	   driver.findElement(By.xpath(SignIn)).click(); //Click Sign in button
	   driver.findElement(By.xpath(EmailRegister)).sendKeys(DataReader.readExcel("UserData", 2, "EmailRegister"));
	   driver.findElement(By.xpath(CreateAccount)).click(); // click create an account button
	   Thread.sleep(6000);
	   driver.findElement(By.id("id_gender1")).click(); // radio button selection for title
	   driver.findElement(By.xpath(FirstName)).sendKeys(DataReader.readExcel("UserData", 2, "FirstName"));
	   driver.findElement(By.xpath(LastName)).sendKeys(DataReader.readExcel("UserData", 2, "LastName"));
	   driver.findElement(By.xpath(Email)).sendKeys(DataReader.readExcel("UserData", 2, "Email"));
	   driver.findElement(By.xpath(Password)).sendKeys(DataReader.readExcel("UserData", 2, "Password"));
	   driver.findElement(By.id("days")).sendKeys(DataReader.readExcel("UserData", 2, "BirthDate"));
	   driver.findElement(By.id("months")).sendKeys(DataReader.readExcel("UserData", 2, "BirthMonth"));
	   driver.findElement(By.id("years")).sendKeys(DataReader.readExcel("UserData", 2, "BirthYear"));   
	   Thread.sleep(4000);
	//   driver.findElement(By.xpath(FirstName1)).sendKeys(DataReader.readExcel("UserData", 2, "FirstName1"));
	//   driver.findElement(By.xpath(LastName1)).sendKeys(DataReader.readExcel("UserData", 2, "LastName1"));
	 //  driver.findElement(By.xpath(CompanyName)).sendKeys(DataReader.readExcel("UserData", 2, "CompanyName"));
	   WebElement companyName = driver.findElement(By.xpath(CompanyName));
	   //This will scroll the page till the element is found	
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView();",companyName);
	   companyName.sendKeys(DataReader.readExcel("UserData", 2, "CompanyName"));
	   Thread.sleep(4000);
	   System.out.println("Company Name is entered");
	   driver.findElement(By.xpath(Address)).sendKeys(DataReader.readExcel("UserData", 2, "Address"));
	   driver.findElement(By.xpath(Address2)).sendKeys(DataReader.readExcel("UserData", 2, "Address2"));
	   driver.findElement(By.xpath(City)).sendKeys(DataReader.readExcel("UserData", 2, "City"));
	   System.out.println("City Name is entered");
	   driver.findElement(By.id("id_state")).sendKeys(DataReader.readExcel("UserData", 2, "State"));
	//   driver.findElement(By.xpath(PostalCode)).sendKeys(DataReader.readExcel("UserData", 2, "PostalCode"));
	   driver.findElement(By.xpath(PostalCode)).sendKeys("99501");
	   driver.findElement(By.id("id_country")).sendKeys(DataReader.readExcel("UserData", 2, "Country"));
	   System.out.println("Country Name is selected");
	   driver.findElement(By.xpath(AdditionalInfo)).sendKeys(DataReader.readExcel("UserData", 2, "AdditionalInfo"));
	   driver.findElement(By.xpath(HomePhone)).sendKeys(DataReader.readExcel("UserData", 2, "HomePhone"));
	   driver.findElement(By.xpath(MobilePhone)).sendKeys(DataReader.readExcel("UserData", 2, "MobilePhone"));
	   System.out.println("Mobile Name is entered");
	   //driver.findElement(By.xpath(AlisAddress)).sendKeys(DataReader.readExcel("UserData", 2, "AlisAddress"));
	 //  System.out.println("Alis address is entered");
	   driver.findElement(By.xpath(Register)).click();
	   Thread.sleep(6000);
	   System.out.println("User is registered");
	   
	   String CurrentTitleAfterLogin = driver.getTitle();
	   String expectedTitleAfterLogin = "My account - My Store";
	   Assert.assertEquals(expectedTitleAfterLogin,CurrentTitleAfterLogin);
	   System.out.println("Registration is successful");
	    }

}
