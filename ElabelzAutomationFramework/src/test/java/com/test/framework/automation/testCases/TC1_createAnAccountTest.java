package com.test.framework.automation.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.framework.automation.baseTest.BaseTest;
import com.test.framework.automation.pages.CreateAnAccountPage;
import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;


public class TC1_createAnAccountTest extends BaseTest 
{
		 
	  
  @BeforeClass
  public void setUp() {
   driver = getDriver(); 
		}	
	
  
  @Test
	public void CreateAnAccountTest() throws Throwable {		
		try{ 

		System.out.println("entering to Register an account");

		CreateAnAccountPage login = new CreateAnAccountPage (driver);
		login.CreateAnAccountMethod();
	   
	}
	
	catch(Throwable t)
  {
                  t.printStackTrace();
		
}
       	
  }}
