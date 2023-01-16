package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class PriorityTest  extends TestBase{
	LoginPage login; //= new  LoginPage();
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
    {
	 initilazition();	
	 login = new  LoginPage();
	}
	
	@Test(priority=3 , groups="sanity")
	public void verifyTitleTest1() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	@Test(priority=1)
	public void verifyTitleTest2() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	
	@Test(priority=-1)
	public void verifyTitleTest3() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	
	@Test(priority=2)
	public void verifyTitleTest4() throws Exception 
	{
		String expTitle="Swag Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}

	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		
		driver.close();
	}
	
	
	

}
