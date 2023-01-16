package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventroyPage;
import Pages.LoginPage;

public class InventoryPageTest  extends TestBase  {
	
	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	
	@BeforeMethod(alwaysRun =true)
	public void setup() throws Exception {
		
		initilazition();
		login = new LoginPage();
		login.LoginToApp();
		 inventory = new InventroyPage();
	}
	

	

	@Test(enabled=true)
	public void verifyInvCurrentUrlTest() {
		
		 String actuUrl=inventory.verifyInvCurrentUrl();
		 String expUrl ="https://www.saucedemo.com/inventory.html";
		 Assert.assertEquals(actuUrl,expUrl);
		 System.out.println(" Inventory url--->"+actuUrl );
		 Reporter.log(" Url of Inventory Page: "+  actuUrl);
	}
	
	@Test(enabled=false)
	public void verifyProductTextTest() {
		
		String actuText=inventory.verifyProductText();
		String expText ="PRODUCTS";
		Assert.assertEquals(actuText, expText);
		System.out.println(actuText);
		Reporter.log(" Label of Inventory Page: "+  actuText);
	}
	
	
	
	@Test(enabled=true)
	public void verifyredLogoPeekTest() {
		
		boolean result = inventory.verifyredLogoPeek();
		Assert.assertEquals(result, false);
		Reporter.log(" PeekLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true , groups="Regression")
	public void verifyfooterLogoTest() {
		
		 boolean result = inventory.verifyfooterLogo();
		 Assert.assertEquals(result, true);
		 Reporter.log(" FooterLogo available on invenorty page: "+  result);
	}
	
	@Test(enabled=true)
	public void verifytwitterLogoTest() {
		
		 boolean result = inventory.verifytwitterLogo();
		 Assert.assertEquals(result, true); 
		 Reporter.log(" TwitterLogo available on invenorty page: "+  result);
	}
	
	
	@Test(enabled=false)
	public void addProductTest() throws Exception {
		
		  String result = inventory.addProduct();
		  Assert.assertEquals(result, "4");
		  Reporter.log("count of product =>" + result );
	}
	
	
	
	

	@AfterMethod(alwaysRun =true)
	public void closeBrowser() {
		
		driver.close();
		
	}
	
	
}
