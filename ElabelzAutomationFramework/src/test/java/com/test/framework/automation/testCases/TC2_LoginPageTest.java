package com.test.framework.automation.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.framework.automation.baseTest.BaseTest;
import com.test.framework.automation.pages.LoginPage;
import com.test.framework.automation.testData.DataReader;
import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;


public class TC2_LoginPageTest extends BaseTest 
{
		 
	  
  @BeforeClass
  public void setUp() {
   driver = getDriver(); 
		}	
	
  
  @Test
	public void LoginPageTest() throws Throwable {		
		try{ 

		System.out.println("entering to Login an account");

		LoginPage check = new LoginPage (driver);
		check.LoginPageMethod();
	   
	}
	
	catch(Throwable t)
  {
                  t.printStackTrace();
		
}
       	
  }}
