package com.test.framework.automation.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.framework.automation.baseTest.BaseTest;
import com.test.framework.automation.pages.AddItemToCartPage;
import com.test.framework.automation.pages.LoginPage;
import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;


public class TC3_AddItemToCardTest extends BaseTest 
{
		 
	  
  @BeforeClass
  public void setUp() {
   driver = getDriver(); 
		}	
	
  
  @Test
	public void SelectItemToCard() throws Throwable {		
		try{ 

		System.out.println("entering to select an item to cart");

		LoginPage check = new LoginPage (driver);
		check.LoginPageMethod();
		
		AddItemToCartPage item1 = new AddItemToCartPage(driver);
		item1.AddItemToCartMethod();
	   
	}
	
	catch(Throwable t)
  {
    t.printStackTrace();
		
}
       	
  }}
