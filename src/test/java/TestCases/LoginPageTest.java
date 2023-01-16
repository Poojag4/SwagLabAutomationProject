package TestCases;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage login; //= new  LoginPage();
	
	@BeforeMethod
	public void setup() throws Exception
	    {
		 initilazition();	
		 login = new  LoginPage();
		}
	
	
	
	@Test(enabled=false)
	public void verifyerrorMsgUsernameTest() throws Exception {
		
		 String result = login.verifyerrorMsgUsername();
		 Reporter.log( " Error Message: "+result);
		  System.out.println(result);
	}
	
	
	@Test(enabled=false)
	public void verifyerrorMsgPassworTest() throws Exception {
		
		 String result = login.verifyerrorMsgPassword();
		 Reporter.log( " Error Message: "+result);
		  System.out.println(result);
	}
	
	
	@Test(enabled=true)
	public void verifyTitleTest() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	
	@Test(enabled=true)
	public void verifyCurrentUrlTest() throws Exception
	{
		String actUrl=login.verifyCurrentUrl();
		String expUrl="https://www.saucedemo.com/";
		Assert.assertEquals(expUrl,actUrl);
		 Reporter.log("  Url of Web Application : "  + actUrl) ;
	}	
	
	
	@Test(enabled=false)
	public void verifyLoginLogoTest() {
		 boolean result = login.verifyLoginLogo();
		 Assert.assertEquals(result, true);
		 Reporter.log(" Login Logo available :" + result);
		
	}
	
   @Test(enabled=false)
	public void verifyBottomLogoTest() {
		  boolean result = login.verifyBottomLogo();
		  Assert.assertEquals(result, true);
		  Reporter.log(" bottom Logo available :" + result);
		
	}
	
	@Test(enabled=true)
   public void LoginToAppTest() throws Exception {
		String actUrl= login.LoginToApp();
	      String expUrl="https://www.saucedemo.com/inventory.html";
	     // System.out.println(driver.getCurrentUrl());
	      Assert.assertEquals(actUrl, expUrl);
	      Reporter.log(" Url of Inventory page : " +actUrl );
		//login.LoginToApp();
	   
   }
	
	@Test(enabled=false)
    public void verifyProductTextTest() throws Exception {
		
		String actuText=login.verifyProductText();
		String expText ="PRODUCTS";
		System.out.println(actuText);
		Assert.assertEquals(actuText, expText);
		Reporter.log(" Label of Inventory page : " + actuText);
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	
	
	
	
	
	
}
