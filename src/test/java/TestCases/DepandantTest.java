package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class DepandantTest extends TestBase {
	LoginPage login; //= new  LoginPage();
	
	@BeforeMethod
	public void setup() throws Exception
    {
	 initilazition();	
	 login = new  LoginPage();
	}
	
	@Test()
	public void verifyTitleTest() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	
	@Test(dependsOnMethods="verifyTitleTest")
	public void verifyCurrentUrlTest() throws Exception
	{
		String actUrl=login.verifyCurrentUrl();
		String expUrl="https://www.saucedemo.com/";
		Assert.assertEquals(expUrl,actUrl);
		 Reporter.log("  Url of Web Application : "  + actUrl) ;
	}	

	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	
	
	
	
}



