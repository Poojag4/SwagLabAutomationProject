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

public class SoftAssertTest extends TestBase {

	
	
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
	public void verifyredLogoPeekTest() {
		System.out.println("Program started");
		SoftAssert soft = new SoftAssert();
		boolean result = inventory.verifyredLogoPeek();
		//soft.assertEquals(result, false);//  soft will execute our whole prog it will not terminate anywhere but assert won't execute our method only 1st stamenet will print and rest will skip
		Assert.assertEquals(result, false);
		System.out.println("Program ended");
		//soft.assertAll();// this will throw an error otherwise soft will not show any error it will run progr smooth
		//soft.assertEquals(actual, expected);
	 //  Assert.assertEquals(actual, expected);
	   
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	
	
	
	

	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
		
	}
}
