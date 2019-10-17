package com.test.framework.automation.baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.test.framework.automation.utilities.Common_Functions;
import com.test.framework.automation.utilities.Constants;

/**
 * Hello world!
 *
 */
public class BaseTest 
{
   // public static WebDriver driver;
	public WebDriver driver;
    public String TC_ID=null;
    
  /*  @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
    	driver = new ChromeDriver();
    } */
    
    public WebDriver getDriver() {
        
        return driver;
 }

    @BeforeClass 
    @Parameters("browserType")
    public void setDriver(String browserType) {
 	//   Extent_Reporting.Log_Pass("URL", appURL);
    	  switch (browserType) {
           case "CHROME":
                  driver = initChromeDriver();
                  break;
           case "FIREFOX":
                  driver = initFirefoxDriver();
                  break;
           default:
                  System.out.println("browser : " + browserType
                               + " is invalid, Launching Firefox as default for execution...");
                  driver = initFirefoxDriver();
           }
    	  driver.manage().timeouts().implicitlyWait(Integer.parseInt(new Common_Functions().GetXMLTagValue(Constants.configPath+"Config.xml", "timeout")), TimeUnit.SECONDS);
    }
           
        
        private WebDriver initChromeDriver() {
               System.out.println("Launching google chrome with new profile..");          
               System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");              
               WebDriver driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.navigate().to("http://automationpractice.com/index.php");
               return driver;

        }

        private WebDriver initFirefoxDriver() {
               System.out.println("Launching Firefox browser..");
               System.setProperty("webdriver.gecko.driver","geckodriver.exe");
               WebDriver driver = new FirefoxDriver();
               driver.manage().window().maximize();
               driver.navigate().to("http://automationpractice.com/index.php");
               return driver;
        }
    

    @AfterClass
    public void endTest() {
    	driver.close();
    }
}
