package com.test.framework.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;

public class AddItemToCartPage {
	
	 DataReader loadData =new DataReader();;
	 public String xmlLocatorsPath = Constants.xmlLocatorsPath + "Locators.xml";
	 public WebDriver driver;
	 public String TC_ID;	
	
	 public String Tab1Women = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "tab1Women");
	 public String TShirt1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "tshirt1");
	 public String AddToCart1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "addToCart1");
	 public String ProceedToCheckout1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "proceedToCheckOut1");
	 public String ProceedToCheckout2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "proceedToCheckOut2");
	 public String ProceedToCheckout3 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "proceedToCheckOut3");
	 public String ProceedToCheckout4 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "proceedToCheckOut4");
	 
public AddItemToCartPage(WebDriver d){
	this.driver = d;
		}

public void AddItemToCartMethod() throws InterruptedException {	
	
	 System.out.println("Running add item to cart method");
	 if(driver.findElements(By.xpath(Tab1Women)).size() != 0)
{
	driver.findElement(By.xpath(Tab1Women)).click(); // Click on Women Tab
	
	 Actions actions = new Actions(driver);
	 actions.moveToElement(driver.findElement(By.xpath(TShirt1))).perform();	 
//	driver.findElement(By.xpath(TShirt1)).click(); // Click on First Item	 
	driver.findElement(By.xpath(AddToCart1)).click(); // Added first item to cart
	driver.findElement(By.xpath(ProceedToCheckout1)).click(); //Click to checkout
     String CurrentTitleAftercheckout = driver.getTitle();
	 String expectedTitleAftercheckout= "Order - My Store";
	if(CurrentTitleAftercheckout.equals(expectedTitleAftercheckout))
	 {
		System.out.println("Item is procceed to checkout successfully on summary page"); 
		driver.findElement(By.xpath(ProceedToCheckout2)).click();
		System.out.println("Item is procceed to checkout second time successfully"); 
		driver.findElement(By.xpath(ProceedToCheckout3)).click();
		System.out.println("Item is procceed to checkout Third time successfully"); 
		if ( !driver.findElement(By.id("cgv")).isSelected() )
		{
		     driver.findElement(By.id("cgv")).click();
		}
		driver.findElement(By.xpath(ProceedToCheckout4)).click();
		System.out.println("Item is procceed to checkout Fourth time successfully"); 
		
	 }
	String currentURL = driver.getCurrentUrl();
	String expectedURL= "http://automationpractice.com/index.php?controller=order&multi-shipping=";
	Assert.assertEquals(expectedURL,currentURL);
	System.out.println("Reached to payment tab successfully");
	
}
	 
	    }

}
