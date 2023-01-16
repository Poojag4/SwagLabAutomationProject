package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.InventroyPage;
import Pages.LoginPage;

public class FailedTest extends TestBase {

	
	

	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initilazition();
		login = new LoginPage();
		login.LoginToApp();
		 inventory = new InventroyPage();
	}
	
	
	
	@Test(enabled=true)
	public void Test1() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, true);
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true)
	public void Test2() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, true);
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true)
	public void Test3() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, true);
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true)
	public void Test4() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, true);
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true)
	public void Test5() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, false);// we can ru this fail test case fom failedtest.xml file
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	
	
	
	

	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
		
	}
}
