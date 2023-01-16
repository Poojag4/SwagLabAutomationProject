package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.UtilityMethod;

public class CaptureScreeshotfailedTest extends TestBase{
	
LoginPage login; //= new  LoginPage();
	
	@BeforeMethod
	public void setup() throws Exception
	    {
		 initilazition();	
		 login = new  LoginPage();
		}
	
	
	
	
	
	@Test(enabled=true)
	public void verifyTitleTest() throws Exception 
	{
		String expTitle="Swag. Labs";
       String actTitle= login.verifyTitle();
       Assert.assertEquals(expTitle, actTitle);
       Reporter.log("  Title of Web Application : "  + actTitle) ;
	}
	

	
	
	@Test(enabled=false)
	public void verifyLoginLogoTest() {
		 boolean result = login.verifyLoginLogo();
		 Assert.assertEquals(result, true);
		 Reporter.log(" Login Logo available :" + result);
		
	}
	
  
	
	
	
	@AfterMethod
	public void closeBrowser(ITestResult a) throws Exception {
		
		if(ITestResult.FAILURE == a.getStatus() ) {
			
			UtilityMethod.Screenshot(a.getName());
		}
		driver.close();
	}
	

}
