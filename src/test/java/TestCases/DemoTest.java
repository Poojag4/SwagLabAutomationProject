package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class DemoTest  extends TestBase{


	LoginPage login; //= new  LoginPage();
	
	@BeforeMethod
	public void setup() throws Exception
    {
	 initilazition();	
	 login = new  LoginPage();
	}
	
	// run same test case multiple times to ensure that their is no error when we run it several times
	@Test(invocationCount=3,enabled=false)
	public void verifyTitleTest1() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	
	@Test(timeOut = 3000) // we are getting org.testng.internal.thread.ThreadTimeoutException  didn't finish within the time-out 200 if it will not open within time
	public void verifyTitleTest2() throws Exception 
	{
		String expTitle="1Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle,"test case fail zali ka");// this msg will print when fail test case
       Reporter.log("  Title of Web Application : "  + actTitle) ;
       Assert.assertTrue(true);// it will fail your test case
       
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	
}
